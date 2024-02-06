package com.fdobrotv.testphonebooking.service.impl;

import com.fdobrotv.testphonebooking.dto.SpecificPhoneBook;
import com.fdobrotv.testphonebooking.dto.SpecificPhoneBookIn;
import com.fdobrotv.testphonebooking.dto.SpecificPhoneState;
import com.fdobrotv.testphonebooking.entity.SpecificPhoneBookEntity;
import com.fdobrotv.testphonebooking.entity.SpecificPhoneEntity;
import com.fdobrotv.testphonebooking.entity.UserEntity;
import com.fdobrotv.testphonebooking.mapper.SpecificPhoneBookMapper;
import com.fdobrotv.testphonebooking.mapper.UserMapper;
import com.fdobrotv.testphonebooking.repository.SpecificPhoneBookEntityRepository;
import com.fdobrotv.testphonebooking.service.BookingService;
import com.fdobrotv.testphonebooking.service.CRUDService;
import com.fdobrotv.testphonebooking.service.EntityService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

import static java.time.ZoneOffset.UTC;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@Transactional
public class SpecificPhoneBookServiceImpl implements CRUDService<SpecificPhoneBook, SpecificPhoneBookIn>,
        BookingService {
    private final SpecificPhoneBookEntityRepository specificPhoneBookEntityRepository;

    private final EntityService<UserEntity> userEntityService;

    private final EntityService<SpecificPhoneEntity> specificPhoneEntityService;

    private final Supplier<ResponseStatusException> unableToFindResource =
            () -> new ResponseStatusException(NOT_FOUND, "Unable to find SpecificPhoneBook by id");

    public SpecificPhoneBookServiceImpl(SpecificPhoneBookEntityRepository specificPhoneBookEntityRepository,
                                        EntityService<UserEntity> userEntityService,
                                        EntityService<SpecificPhoneEntity> specificPhoneEntityService) {
        this.specificPhoneBookEntityRepository = specificPhoneBookEntityRepository;
        this.userEntityService = userEntityService;
        this.specificPhoneEntityService = specificPhoneEntityService;
    }

    @Override
    @Transactional(readOnly = true)
    public SpecificPhoneBook getById(UUID id) {
        Optional<SpecificPhoneBookEntity> specificPhoneBookByID = specificPhoneBookEntityRepository.findById(id);
        return SpecificPhoneBookMapper.toDTO(specificPhoneBookByID.orElseThrow(unableToFindResource));
    }

    @Override
    public void deleteById(UUID id) {
        Optional<SpecificPhoneBookEntity>
                SpecificPhoneBookEntityOptional = specificPhoneBookEntityRepository.findById(id);
        SpecificPhoneBookEntity SpecificPhoneBookEntity =
                SpecificPhoneBookEntityOptional.orElseThrow(unableToFindResource);
        specificPhoneBookEntityRepository.delete(SpecificPhoneBookEntity);
    }

    @Override
    public SpecificPhoneBook create(SpecificPhoneBookIn specificPhoneBookIn) {
        SpecificPhoneEntity specificPhoneEntity =
                specificPhoneEntityService.getEntityById(specificPhoneBookIn.getSpecificPhoneId());
        UserEntity userEntity = userEntityService.getEntityById(specificPhoneBookIn.getUserId());

        SpecificPhoneBookEntity specificPhoneBookEntity = SpecificPhoneBookMapper.toEntity(
                specificPhoneEntity,
                userEntity
        );
        SpecificPhoneBookEntity saved = specificPhoneBookEntityRepository.save(specificPhoneBookEntity);
        return SpecificPhoneBookMapper.toDTO(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SpecificPhoneBook> getList(Pageable pageable) {
        Iterable<SpecificPhoneBookEntity> all = specificPhoneBookEntityRepository.findAll(pageable);
        return SpecificPhoneBookMapper.toDTO(all);
    }

    @Override
    @Transactional
    public SpecificPhoneBook bookById(@NotNull @Valid UUID phoneId, @NotNull @Valid UUID userId) {
        Optional<SpecificPhoneBookEntity> alreadyBooked =
                specificPhoneBookEntityRepository.getOneBySpecificPhoneIdAndReturnedAt(phoneId, null);

        if (alreadyBooked.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_ACCEPTABLE, "Can't do, booked at the moment");
        }

        SpecificPhoneBookEntity specificPhoneBookEntity = new SpecificPhoneBookEntity();
        specificPhoneBookEntity.setUser(userEntityService.getEntityById(userId));
        specificPhoneBookEntity.setSpecificPhone(specificPhoneEntityService.getEntityById(phoneId));
        specificPhoneBookEntity.setCreatedAt(OffsetDateTime.now(UTC));
        specificPhoneBookEntityRepository.save(specificPhoneBookEntity);

        return SpecificPhoneBookMapper.toDTO(specificPhoneBookEntity);
    }

    @Override
    @Transactional
    public SpecificPhoneBook returnById(UUID phoneId) {
        Optional<SpecificPhoneBookEntity> yetBooked =
                specificPhoneBookEntityRepository.getOneBySpecificPhoneIdAndReturnedAt(phoneId, null);

        SpecificPhoneBookEntity specificPhoneBookEntity = yetBooked.orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_ACCEPTABLE, "Can't do, not booked at the moment"));

        specificPhoneBookEntity.setReturnedAt(OffsetDateTime.now(UTC));
        specificPhoneBookEntityRepository.save(specificPhoneBookEntity);

        return SpecificPhoneBookMapper.toDTO(specificPhoneBookEntity);
    }
}
