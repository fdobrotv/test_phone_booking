package com.fdobrotv.testphonebooking.mapper;

import com.fdobrotv.testphonebooking.dto.PhoneMark;
import com.fdobrotv.testphonebooking.dto.PhoneMarkIn;
import com.fdobrotv.testphonebooking.entity.PhoneMarkEntity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class PhoneMarkMapper {
    public static PhoneMark toDTO(PhoneMarkEntity phoneMarkEntity) {
        PhoneMark phoneMark = new PhoneMark();
        phoneMark.id(phoneMarkEntity.getId());
        phoneMark.name(phoneMarkEntity.getName());
        return phoneMark;
    }

    public static List<PhoneMark> toDTO(List<PhoneMarkEntity> phoneMarkEntities) {
        return phoneMarkEntities.stream()
                .map(PhoneMarkMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static List<PhoneMark> toDTO(Iterable<PhoneMarkEntity> phoneMarkEntities) {
        Stream<PhoneMarkEntity> targetStream = StreamSupport.stream(phoneMarkEntities.spliterator(), false);
        return toDTO(targetStream.toList());
    }

    public static PhoneMarkEntity toEntity(PhoneMarkIn phoneMarkIn) {
        PhoneMarkEntity phoneMarkEntity = new PhoneMarkEntity();
        phoneMarkEntity.setName(phoneMarkIn.getName());
        return phoneMarkEntity;
    }
}
