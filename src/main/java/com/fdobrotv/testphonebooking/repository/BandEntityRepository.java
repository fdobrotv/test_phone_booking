package com.fdobrotv.testphonebooking.repository;

import com.fdobrotv.testphonebooking.entity.BandEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BandEntityRepository extends PagingAndSortingRepository<BandEntity, UUID>, CrudRepository<BandEntity, UUID> {
}