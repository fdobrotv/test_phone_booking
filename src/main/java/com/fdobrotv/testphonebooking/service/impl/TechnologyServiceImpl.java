package com.fdobrotv.testphonebooking.service.impl;

import com.fdobrotv.testphonebooking.dto.Technology;
import com.fdobrotv.testphonebooking.dto.TechnologyIn;
import com.fdobrotv.testphonebooking.entity.TechnologyEntity;
import com.fdobrotv.testphonebooking.mapper.TechnologyMapper;
import com.fdobrotv.testphonebooking.repository.TechnologyEntityRepository;
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
public class TechnologyServiceImpl implements CRUDService<Technology, TechnologyIn>, EntityService<TechnologyEntity> {

    private final TechnologyEntityRepository technologyEntityRepository;
    private final Supplier<ResponseStatusException> unableToFindResource =
            () -> new ResponseStatusException(NOT_FOUND, "Unable to find Technology by id");

    public TechnologyServiceImpl(TechnologyEntityRepository technologyEntityRepository) {
        this.technologyEntityRepository = technologyEntityRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Technology getById(UUID id) {
        Optional<TechnologyEntity> technologyByID = technologyEntityRepository.findById(id);
        return TechnologyMapper.toDTO(technologyByID.orElseThrow(unableToFindResource));
    }

    @Override
    public void deleteById(UUID id) {
        Optional<TechnologyEntity> TechnologyEntityOptional = technologyEntityRepository.findById(id);
        TechnologyEntity TechnologyEntity = TechnologyEntityOptional.orElseThrow(unableToFindResource);
        technologyEntityRepository.delete(TechnologyEntity);
    }

    @Override
    public Technology create(TechnologyIn technologyIn) {
        TechnologyEntity technologyEntity = TechnologyMapper.toEntity(technologyIn);
        TechnologyEntity saved = technologyEntityRepository.save(technologyEntity);
        return TechnologyMapper.toDTO(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Technology> getList(Pageable pageable) {
        Iterable<TechnologyEntity> all = technologyEntityRepository.findAll(pageable);
        return TechnologyMapper.toDTO(all);
    }

    @Override
    public TechnologyEntity getEntityById(UUID id) {
        Optional<TechnologyEntity> technologyEntityById = technologyEntityRepository.findById(id);
        return technologyEntityById.orElseThrow(unableToFindResource);
    }
}
