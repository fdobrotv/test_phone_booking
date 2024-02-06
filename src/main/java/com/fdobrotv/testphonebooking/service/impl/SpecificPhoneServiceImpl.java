package com.fdobrotv.testphonebooking.service.impl;

import com.fdobrotv.testphonebooking.dto.SpecificPhone;
import com.fdobrotv.testphonebooking.dto.SpecificPhoneIn;
import com.fdobrotv.testphonebooking.dto.SpecificPhoneState;
import com.fdobrotv.testphonebooking.entity.PhoneEntity;
import com.fdobrotv.testphonebooking.entity.SpecificPhoneBookEntity;
import com.fdobrotv.testphonebooking.entity.SpecificPhoneEntity;
import com.fdobrotv.testphonebooking.mapper.SpecificPhoneMapper;
import com.fdobrotv.testphonebooking.mapper.UserMapper;
import com.fdobrotv.testphonebooking.repository.SpecificPhoneBookEntityRepository;
import com.fdobrotv.testphonebooking.repository.SpecificPhoneEntityRepository;
import com.fdobrotv.testphonebooking.service.CRUDService;
import com.fdobrotv.testphonebooking.service.EntityService;
import com.fdobrotv.testphonebooking.service.SpecificPhoneStatusService;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.StreamSupport;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@Transactional
public class SpecificPhoneServiceImpl implements CRUDService<SpecificPhone, SpecificPhoneIn>,
        EntityService<SpecificPhoneEntity>, SpecificPhoneStatusService {
    private final SpecificPhoneStatusService specificPhoneStatusService;
    private final SpecificPhoneEntityRepository specificPhoneModelEntityRepository;
    private final SpecificPhoneBookEntityRepository specificPhoneBookEntityRepository;
    private final EntityService<PhoneEntity> phoneEntityService;
    private final Supplier<ResponseStatusException> unableToFindResource =
            () -> new ResponseStatusException(NOT_FOUND, "Unable to find SpecificPhone Mark by id");

    public SpecificPhoneServiceImpl(SpecificPhoneStatusService specificPhoneStatusService,
                                    SpecificPhoneEntityRepository specificPhoneModelEntityRepository,
                                    SpecificPhoneBookEntityRepository specificPhoneBookEntityRepository,
                                    EntityService<PhoneEntity> phoneEntityService) {
        this.specificPhoneModelEntityRepository = specificPhoneModelEntityRepository;
        this.specificPhoneStatusService = specificPhoneStatusService;
        this.specificPhoneBookEntityRepository = specificPhoneBookEntityRepository;
        this.phoneEntityService = phoneEntityService;
    }

    @Override
    @Transactional(readOnly = true)
    public SpecificPhone getById(UUID id) {
        Optional<SpecificPhoneEntity> specificPhoneModelEntityOptional =
                specificPhoneModelEntityRepository.findById(id);
        SpecificPhoneEntity specificPhoneEntity = specificPhoneModelEntityOptional.orElseThrow(unableToFindResource);
        SpecificPhoneState specificPhoneState = specificPhoneStatusService.getStatusById(id);
        return SpecificPhoneMapper.toDTO(specificPhoneEntity, specificPhoneState);
    }

    @Override
    public void deleteById(UUID id) {
        Optional<SpecificPhoneEntity>
                specificPhoneModelEntityOptional = specificPhoneModelEntityRepository.findById(id);
        SpecificPhoneEntity specificPhoneModelEntity =
                specificPhoneModelEntityOptional.orElseThrow(unableToFindResource);
        specificPhoneModelEntityRepository.delete(specificPhoneModelEntity);
    }

    @Override
    public SpecificPhone create(SpecificPhoneIn specificPhoneModelIn) {
        PhoneEntity phoneEntity =
                phoneEntityService.getEntityById(specificPhoneModelIn.getPhoneId());
        SpecificPhoneEntity specificPhoneModelEntity =
                SpecificPhoneMapper.toEntity(specificPhoneModelIn, phoneEntity);
        SpecificPhoneEntity saved = specificPhoneModelEntityRepository.save(specificPhoneModelEntity);
        SpecificPhoneState specificPhoneState = new SpecificPhoneState();
        return SpecificPhoneMapper.toDTO(saved, specificPhoneState);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SpecificPhone> getList(Pageable pageable) {
        Iterable<SpecificPhoneEntity> all = specificPhoneModelEntityRepository.findAll(pageable);
        List<Pair<SpecificPhoneEntity, SpecificPhoneState>> list = StreamSupport.stream(all.spliterator(), false)
                .map(specificPhoneEntity -> {
                    SpecificPhoneState specificPhoneState =
                            specificPhoneStatusService.getStatusById(specificPhoneEntity.getId());
                    return Pair.of(specificPhoneEntity, specificPhoneState);
                }).toList();
        return SpecificPhoneMapper.toDTO(list);
    }

    @Override
    @Transactional(readOnly = true)
    public SpecificPhoneEntity getEntityById(UUID id) {
        Optional<SpecificPhoneEntity> specificPhoneModelEntityOptional =
                specificPhoneModelEntityRepository.findById(id);
        return specificPhoneModelEntityOptional.orElseThrow(unableToFindResource);
    }

    @Override
    @Transactional(readOnly = true)
    public SpecificPhoneState getStatusById(UUID phoneId) {
        SpecificPhoneState specificPhoneState = new SpecificPhoneState();
        Optional<SpecificPhoneBookEntity> firstByPhoneIdAndOrderByCreatedAtDesc =
                specificPhoneBookEntityRepository.findFirstBySpecificPhoneIdOrderByCreatedAtDesc(phoneId);
        if (firstByPhoneIdAndOrderByCreatedAtDesc.isPresent()) {
            SpecificPhoneBookEntity specificPhoneBookEntity = firstByPhoneIdAndOrderByCreatedAtDesc.get();
            OffsetDateTime returnedAt = specificPhoneBookEntity.getReturnedAt();
            specificPhoneState.setIsAvailable(returnedAt == null);
            specificPhoneState.setLastBookTime(specificPhoneBookEntity.getCreatedAt());
            specificPhoneState.setLastHolder(UserMapper.toDTO(specificPhoneBookEntity.getUser()));
        }
        return specificPhoneState;
    }
}
