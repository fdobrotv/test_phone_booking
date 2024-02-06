package com.fdobrotv.testphonebooking.mapper;

import com.fdobrotv.testphonebooking.dto.SpecificPhoneBook;
import com.fdobrotv.testphonebooking.entity.SpecificPhoneEntity;
import com.fdobrotv.testphonebooking.entity.SpecificPhoneBookEntity;
import com.fdobrotv.testphonebooking.entity.UserEntity;
import lombok.extern.java.Log;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.time.ZoneOffset.UTC;

@Log
public class SpecificPhoneBookMapper {
    public static SpecificPhoneBook toDTO(SpecificPhoneBookEntity specificPhoneBookEntity) {
        SpecificPhoneBook specificPhoneBook = new SpecificPhoneBook();
        UUID id = specificPhoneBookEntity.getId();
        specificPhoneBook.id(id);
        specificPhoneBook.setSpecificPhoneId(specificPhoneBookEntity.getSpecificPhone().getId());
        specificPhoneBook.createdAt(specificPhoneBookEntity.getCreatedAt());
        specificPhoneBook.returnedAt(specificPhoneBookEntity.getReturnedAt());
        specificPhoneBook.user(UserMapper.toDTO(specificPhoneBookEntity.getUser()));
        return specificPhoneBook;
    }

    public static List<SpecificPhoneBook> toDTO(List<SpecificPhoneBookEntity> specificPhoneBookEntities) {
        return specificPhoneBookEntities.stream()
                .map(SpecificPhoneBookMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static List<SpecificPhoneBook> toDTO(Iterable<SpecificPhoneBookEntity> specificPhoneBookEntities) {
        Stream<SpecificPhoneBookEntity> targetStream = StreamSupport.stream(specificPhoneBookEntities.spliterator(), false);
        return toDTO(targetStream.toList());
    }

    public static SpecificPhoneBookEntity toEntity(SpecificPhoneEntity specificPhoneEntity,
                                                   UserEntity userEntity) {
        SpecificPhoneBookEntity specificPhoneBookEntity = new SpecificPhoneBookEntity();
        specificPhoneBookEntity.setSpecificPhone(specificPhoneEntity);
        specificPhoneBookEntity.setCreatedAt(OffsetDateTime.now(UTC));
        specificPhoneBookEntity.setUser(userEntity);
        return specificPhoneBookEntity;
    }
}
