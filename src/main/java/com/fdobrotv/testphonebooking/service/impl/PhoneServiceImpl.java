package com.fdobrotv.testphonebooking.service.impl;

import com.fdobrotv.testphonebooking.dto.Phone;
import com.fdobrotv.testphonebooking.dto.PhoneIn;
import com.fdobrotv.testphonebooking.entity.BandEntity;
import com.fdobrotv.testphonebooking.entity.PhoneEntity;
import com.fdobrotv.testphonebooking.entity.PhoneModelEntity;
import com.fdobrotv.testphonebooking.entity.TechnologyEntity;
import com.fdobrotv.testphonebooking.mapper.PhoneMapper;
import com.fdobrotv.testphonebooking.repository.PhoneEntityRepository;
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
public class PhoneServiceImpl implements CRUDService<Phone, PhoneIn>, EntityService<PhoneEntity> {

    private final PhoneEntityRepository phoneEntityRepository;

    private final EntityService<PhoneModelEntity> phoneModelEntityService;
    private final EntityService<TechnologyEntity> technologyEntityService;
    private final EntityService<BandEntity> bandEntityService;

    public PhoneServiceImpl(PhoneEntityRepository phoneEntityRepository,
                            EntityService<PhoneModelEntity> phoneModelEntityService,
                            EntityService<TechnologyEntity> technologyEntityService,
                            EntityService<BandEntity> bandEntityService) {
        this.phoneEntityRepository = phoneEntityRepository;
        this.phoneModelEntityService = phoneModelEntityService;
        this.technologyEntityService = technologyEntityService;
        this.bandEntityService = bandEntityService;
    }

    private final Supplier<ResponseStatusException> unableToFindResource =
            () -> new ResponseStatusException(NOT_FOUND, "Unable to find Phone by id");

    @Override
    @Transactional(readOnly = true)
    public Phone getById(UUID id) {
        Optional<PhoneEntity> phoneByID = phoneEntityRepository.findById(id);
        return PhoneMapper.toDTO(phoneByID.orElseThrow(unableToFindResource));
    }

    @Override
    public void deleteById(UUID id) {
        Optional<PhoneEntity> PhoneEntityOptional = phoneEntityRepository.findById(id);
        PhoneEntity PhoneEntity = PhoneEntityOptional.orElseThrow(unableToFindResource);
        phoneEntityRepository.delete(PhoneEntity);
    }

    @Override
    public Phone create(PhoneIn phoneIn) {
        PhoneModelEntity phoneModelEntity = phoneModelEntityService.getEntityById(phoneIn.getModelId());
        List<TechnologyEntity> technologies = phoneIn.getTechnologyIds().stream()
                .map(technologyEntityService::getEntityById).toList();
        List<BandEntity> bands = phoneIn.getBandIds().stream()
                .map(bandEntityService::getEntityById).toList();
        PhoneEntity phoneEntity = PhoneMapper.toEntity(
                phoneModelEntity,
                technologies,
                bands
        );
        PhoneEntity saved = phoneEntityRepository.save(phoneEntity);
        return PhoneMapper.toDTO(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Phone> getList(Pageable pageable) {
        Iterable<PhoneEntity> all = phoneEntityRepository.findAll(pageable);
        return PhoneMapper.toDTO(all);
    }

    @Override
    @Transactional(readOnly = true)
    public PhoneEntity getEntityById(UUID id) {
        Optional<PhoneEntity> phoneByID = phoneEntityRepository.findById(id);
        return phoneByID.orElseThrow(unableToFindResource);
    }
}
