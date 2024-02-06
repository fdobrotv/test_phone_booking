package com.fdobrotv.testphonebooking.mapper;

import com.fdobrotv.testphonebooking.dto.Band;
import com.fdobrotv.testphonebooking.dto.Phone;
import com.fdobrotv.testphonebooking.dto.PhoneIn;
import com.fdobrotv.testphonebooking.entity.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class PhoneMapper {
    public static Phone toDTO(PhoneEntity phoneEntity) {
        Phone phone = new Phone();
        phone.id(phoneEntity.getId());
        phone.model(phoneEntity.getModel().getName());
        phone.technologies(TechnologyMapper.toDTO(phoneEntity.getTechnologies()));
        phone.bands(BandMapper.toDTO(phoneEntity.getBands()));
        return phone;
    }

    public static List<Phone> toDTO(List<PhoneEntity> phoneEntities) {
        return phoneEntities.stream()
                .map(PhoneMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static List<Phone> toDTO(Iterable<PhoneEntity> phoneEntities) {
        Stream<PhoneEntity> targetStream = StreamSupport.stream(phoneEntities.spliterator(), false);
        return toDTO(targetStream.toList());
    }

    public static PhoneEntity toEntity(PhoneModelEntity phoneModelEntity,
                                       List<TechnologyEntity> technologies, List<BandEntity> bands) {
        PhoneEntity phoneEntity = new PhoneEntity();
        phoneEntity.setModel(phoneModelEntity);
        phoneEntity.setTechnologies(technologies);
        phoneEntity.setBands(bands);
        return phoneEntity;
    }
}
