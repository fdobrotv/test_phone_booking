package com.fdobrotv.testphonebooking.repository;

import com.fdobrotv.testphonebooking.entity.PhoneEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface PhoneEntityRepository extends PagingAndSortingRepository<PhoneEntity, UUID>, CrudRepository<PhoneEntity, UUID> {
}