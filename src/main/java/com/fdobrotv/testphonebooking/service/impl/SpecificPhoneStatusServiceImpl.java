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
import com.fdobrotv.testphonebooking.service.BookingService;
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
public class SpecificPhoneStatusServiceImpl implements SpecificPhoneStatusService {
    private final SpecificPhoneBookEntityRepository specificPhoneBookEntityRepository;

    public SpecificPhoneStatusServiceImpl(SpecificPhoneBookEntityRepository specificPhoneBookEntityRepository) {
        this.specificPhoneBookEntityRepository = specificPhoneBookEntityRepository;
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
            specificPhoneState.setIsAvailable(returnedAt != null);
            specificPhoneState.setLastBookTime(specificPhoneBookEntity.getCreatedAt());
            specificPhoneState.setLastHolder(UserMapper.toDTO(specificPhoneBookEntity.getUser()));
        } else
            specificPhoneState.setIsAvailable(true);
        return specificPhoneState;
    }
}
