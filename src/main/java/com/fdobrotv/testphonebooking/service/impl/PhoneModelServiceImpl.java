package com.fdobrotv.testphonebooking.service.impl;

import com.fdobrotv.testphonebooking.dto.PhoneModel;
import com.fdobrotv.testphonebooking.dto.PhoneModelIn;
import com.fdobrotv.testphonebooking.entity.PhoneMarkEntity;
import com.fdobrotv.testphonebooking.entity.PhoneModelEntity;
import com.fdobrotv.testphonebooking.mapper.PhoneModelMapper;
import com.fdobrotv.testphonebooking.repository.PhoneModelEntityRepository;
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
public class PhoneModelServiceImpl implements CRUDService<PhoneModel, PhoneModelIn>, EntityService<PhoneModelEntity> {

    private final PhoneModelEntityRepository phoneModelEntityRepository;

    private final EntityService<PhoneMarkEntity> phoneMarkEntityService;
    private final Supplier<ResponseStatusException> unableToFindResource =
            () -> new ResponseStatusException(NOT_FOUND, "Unable to find Phone Mark by id");

    public PhoneModelServiceImpl(PhoneModelEntityRepository phoneModelEntityRepository,
                                 EntityService<PhoneMarkEntity> phoneMarkEntityService) {
        this.phoneModelEntityRepository = phoneModelEntityRepository;
        this.phoneMarkEntityService = phoneMarkEntityService;
    }

    @Override
    @Transactional(readOnly = true)
    public PhoneModel getById(UUID id) {
        Optional<PhoneModelEntity> phoneModelEntityOptional = phoneModelEntityRepository.findById(id);
        return PhoneModelMapper.toDTO(phoneModelEntityOptional.orElseThrow(unableToFindResource));
    }

    @Override
    public void deleteById(UUID id) {
        Optional<PhoneModelEntity> phoneModelEntityOptional = phoneModelEntityRepository.findById(id);
        PhoneModelEntity phoneModelEntity = phoneModelEntityOptional.orElseThrow(unableToFindResource);
        phoneModelEntityRepository.delete(phoneModelEntity);
    }

    @Override
    public PhoneModel create(PhoneModelIn phoneModelIn) {
        PhoneMarkEntity phoneMarkEntity = phoneMarkEntityService.getEntityById(phoneModelIn.getPhoneMarkId());
        PhoneModelEntity phoneModelEntity = PhoneModelMapper.toEntity(phoneModelIn, phoneMarkEntity);
        PhoneModelEntity saved = phoneModelEntityRepository.save(phoneModelEntity);
        return PhoneModelMapper.toDTO(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PhoneModel> getList(Pageable pageable) {
        Iterable<PhoneModelEntity> all = phoneModelEntityRepository.findAll(pageable);
        return PhoneModelMapper.toDTO(all);
    }

    @Override
    @Transactional(readOnly = true)
    public PhoneModelEntity getEntityById(UUID id) {
        Optional<PhoneModelEntity> phoneModelEntityOptional = phoneModelEntityRepository.findById(id);
        return phoneModelEntityOptional.orElseThrow(unableToFindResource);
    }
}
