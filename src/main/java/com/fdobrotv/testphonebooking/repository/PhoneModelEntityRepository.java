package com.fdobrotv.testphonebooking.repository;

import com.fdobrotv.testphonebooking.entity.PhoneModelEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface PhoneModelEntityRepository extends PagingAndSortingRepository<PhoneModelEntity, UUID>, CrudRepository<PhoneModelEntity, UUID> {
}