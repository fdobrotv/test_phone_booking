package com.fdobrotv.testphonebooking.repository;

import com.fdobrotv.testphonebooking.entity.SpecificPhoneEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface SpecificPhoneEntityRepository extends PagingAndSortingRepository<SpecificPhoneEntity, UUID>, CrudRepository<SpecificPhoneEntity, UUID> {
}