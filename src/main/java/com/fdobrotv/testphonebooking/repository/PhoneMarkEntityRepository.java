package com.fdobrotv.testphonebooking.repository;

import com.fdobrotv.testphonebooking.entity.PhoneMarkEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface PhoneMarkEntityRepository extends PagingAndSortingRepository<PhoneMarkEntity, UUID>, CrudRepository<PhoneMarkEntity, UUID> {
}