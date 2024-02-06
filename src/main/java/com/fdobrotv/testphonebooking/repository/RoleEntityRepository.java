package com.fdobrotv.testphonebooking.repository;

import com.fdobrotv.testphonebooking.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RoleEntityRepository extends PagingAndSortingRepository<RoleEntity, UUID>, CrudRepository<RoleEntity, UUID> {
}