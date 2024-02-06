package com.fdobrotv.testphonebooking.mapper;

import com.fdobrotv.testphonebooking.dto.Technology;
import com.fdobrotv.testphonebooking.dto.TechnologyIn;
import com.fdobrotv.testphonebooking.entity.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class TechnologyMapper {
    public static Technology toDTO(TechnologyEntity technologyEntity) {
        Technology technology = new Technology();
        technology.id(technologyEntity.getId());
        technology.name(technologyEntity.getName());
        return technology;
    }

    public static List<Technology> toDTO(List<TechnologyEntity> technologyEntities) {
        return technologyEntities.stream()
                .map(TechnologyMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static List<Technology> toDTO(Iterable<TechnologyEntity> technologyEntities) {
        Stream<TechnologyEntity> targetStream = StreamSupport.stream(technologyEntities.spliterator(), false);
        return toDTO(targetStream.toList());
    }

    public static TechnologyEntity toEntity(TechnologyIn technologyIn) {
        TechnologyEntity technologyEntity = new TechnologyEntity();
        technologyEntity.setName(technologyIn.getName());
        return technologyEntity;
    }
}
