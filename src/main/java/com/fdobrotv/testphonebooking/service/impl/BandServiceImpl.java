package com.fdobrotv.testphonebooking.service.impl;

import com.fdobrotv.testphonebooking.dto.Band;
import com.fdobrotv.testphonebooking.dto.BandIn;
import com.fdobrotv.testphonebooking.entity.BandEntity;
import com.fdobrotv.testphonebooking.mapper.BandMapper;
import com.fdobrotv.testphonebooking.repository.BandEntityRepository;
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
public class BandServiceImpl implements CRUDService<Band, BandIn>, EntityService<BandEntity> {

    private final BandEntityRepository bandEntityRepository;
    private final Supplier<ResponseStatusException> unableToFindResource =
            () -> new ResponseStatusException(NOT_FOUND, "Unable to find Band by id");

    public BandServiceImpl(BandEntityRepository bandEntityRepository) {
        this.bandEntityRepository = bandEntityRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Band getById(UUID id) {
        Optional<BandEntity> bandByID = bandEntityRepository.findById(id);
        return BandMapper.toDTO(bandByID.orElseThrow(unableToFindResource));
    }

    @Override
    public void deleteById(UUID id) {
        Optional<BandEntity> BandEntityOptional = bandEntityRepository.findById(id);
        BandEntity BandEntity = BandEntityOptional.orElseThrow(unableToFindResource);
        bandEntityRepository.delete(BandEntity);
    }

    @Override
    public Band create(BandIn bandIn) {
        BandEntity bandEntity = BandMapper.toEntity(bandIn);
        BandEntity saved = bandEntityRepository.save(bandEntity);
        return BandMapper.toDTO(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Band> getList(Pageable pageable) {
        Iterable<BandEntity> all = bandEntityRepository.findAll(pageable);
        return BandMapper.toDTO(all);
    }

    @Override
    public BandEntity getEntityById(UUID id) {
        Optional<BandEntity> bandEntityById = bandEntityRepository.findById(id);
        return bandEntityById.orElseThrow(unableToFindResource);
    }
}
