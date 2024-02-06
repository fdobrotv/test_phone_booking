package com.fdobrotv.testphonebooking.repository;

import com.fdobrotv.testphonebooking.entity.TechnologyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface TechnologyEntityRepository extends PagingAndSortingRepository<TechnologyEntity, UUID>,
        CrudRepository<TechnologyEntity, UUID> {
}