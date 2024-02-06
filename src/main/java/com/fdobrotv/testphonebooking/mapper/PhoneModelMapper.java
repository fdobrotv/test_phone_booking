package com.fdobrotv.testphonebooking.mapper;

import com.fdobrotv.testphonebooking.dto.PhoneMark;
import com.fdobrotv.testphonebooking.dto.PhoneMarkIn;
import com.fdobrotv.testphonebooking.dto.PhoneModel;
import com.fdobrotv.testphonebooking.dto.PhoneModelIn;
import com.fdobrotv.testphonebooking.entity.PhoneMarkEntity;
import com.fdobrotv.testphonebooking.entity.PhoneModelEntity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class PhoneModelMapper {
    public static PhoneModel toDTO(PhoneModelEntity phoneModelEntity) {
        PhoneModel phoneModel = new PhoneModel();
        phoneModel.id(phoneModelEntity.getId());
        phoneModel.phoneMarkId(phoneModelEntity.getMark().getId());
        phoneModel.name(phoneModelEntity.getName());
        return phoneModel;
    }

    public static List<PhoneModel> toDTO(List<PhoneModelEntity> PhoneModelEntities) {
        return PhoneModelEntities.stream()
                .map(PhoneModelMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static List<PhoneModel> toDTO(Iterable<PhoneModelEntity> PhoneModelEntities) {
        Stream<PhoneModelEntity> targetStream = StreamSupport.stream(PhoneModelEntities.spliterator(), false);
        return toDTO(targetStream.toList());
    }

    public static PhoneModelEntity toEntity(PhoneModelIn PhoneModelIn, PhoneMarkEntity phoneMarkEntity) {
        PhoneModelEntity PhoneModelEntity = new PhoneModelEntity();
        PhoneModelEntity.setMark(phoneMarkEntity);
        PhoneModelEntity.setName(PhoneModelIn.getName());
        return PhoneModelEntity;
    }
}
