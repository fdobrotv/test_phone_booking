package com.fdobrotv.testphonebooking.service.impl;

import com.fdobrotv.testphonebooking.dto.PhoneMark;
import com.fdobrotv.testphonebooking.dto.PhoneMarkIn;
import com.fdobrotv.testphonebooking.entity.PhoneMarkEntity;
import com.fdobrotv.testphonebooking.mapper.PhoneMarkMapper;
import com.fdobrotv.testphonebooking.repository.PhoneMarkEntityRepository;
import com.fdobrotv.testphonebooking.service.CRUDService;
import com.fdobrotv.testphonebooking.service.EntityService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@Transactional
public class PhoneMarkServiceImpl implements CRUDService<PhoneMark, PhoneMarkIn>, EntityService<PhoneMarkEntity> {

    private final PhoneMarkEntityRepository phoneMarkEntityRepository;
    private final Supplier<ResponseStatusException> unableToFindResource =
            () -> new ResponseStatusException(NOT_FOUND, "Unable to find Phone Mark by id");

    public PhoneMarkServiceImpl(PhoneMarkEntityRepository phoneMarkEntityRepository) {
        this.phoneMarkEntityRepository = phoneMarkEntityRepository;
    }

    @Override
    public PhoneMark getById(UUID id) {
        Optional<PhoneMarkEntity> phoneMarkEntity = phoneMarkEntityRepository.findById(id);
        return PhoneMarkMapper.toDTO(phoneMarkEntity.orElseThrow(unableToFindResource));
    }

    @Override
    public void deleteById(UUID id) {
        Optional<PhoneMarkEntity> phoneMarkEntityOptional = phoneMarkEntityRepository.findById(id);
        PhoneMarkEntity phoneMarkEntity = phoneMarkEntityOptional.orElseThrow(unableToFindResource);
        phoneMarkEntityRepository.delete(phoneMarkEntity);
    }

    @Override
    public PhoneMark create(PhoneMarkIn phoneMarkIn) {
        PhoneMarkEntity phoneMarkEntity = PhoneMarkMapper.toEntity(phoneMarkIn);
        PhoneMarkEntity saved = phoneMarkEntityRepository.save(phoneMarkEntity);
        return PhoneMarkMapper.toDTO(saved);
    }

    @Override
    public List<PhoneMark> getList(Pageable pageable) {
        Iterable<PhoneMarkEntity> all = phoneMarkEntityRepository.findAll(pageable);
        return PhoneMarkMapper.toDTO(all);
    }

    @Override
    public PhoneMarkEntity getEntityById(UUID id) {
        Optional<PhoneMarkEntity> phoneMarkEntity = phoneMarkEntityRepository.findById(id);
        return phoneMarkEntity.orElseThrow(unableToFindResource);
    }
}
