package com.fdobrotv.testphonebooking.repository;

import com.fdobrotv.testphonebooking.entity.SpecificPhoneBookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

public interface SpecificPhoneBookEntityRepository extends PagingAndSortingRepository<SpecificPhoneBookEntity, UUID>, CrudRepository<SpecificPhoneBookEntity, UUID> {
    Optional<SpecificPhoneBookEntity> getOneBySpecificPhoneIdAndReturnedAt(UUID phoneId, OffsetDateTime returnedAt);
    Optional<SpecificPhoneBookEntity> findFirstBySpecificPhoneIdOrderByCreatedAtDesc(UUID phoneId);
}