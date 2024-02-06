package com.fdobrotv.testphonebooking.mapper;

import com.fdobrotv.testphonebooking.dto.Band;
import com.fdobrotv.testphonebooking.dto.BandIn;
import com.fdobrotv.testphonebooking.entity.BandEntity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class BandMapper {
    public static Band toDTO(BandEntity bandEntity) {
        Band band = new Band();
        band.id(bandEntity.getId());
        band.name(bandEntity.getName());
        band.subName(bandEntity.getSubName());
        band.channel(bandEntity.getChannel());
        return band;
    }

    public static List<Band> toDTO(List<BandEntity> bandEntities) {
        return bandEntities.stream()
                .map(BandMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static List<Band> toDTO(Iterable<BandEntity> bandEntities) {
        Stream<BandEntity> targetStream = StreamSupport.stream(bandEntities.spliterator(), false);
        return toDTO(targetStream.toList());
    }

    public static BandEntity toEntity(BandIn bandIn) {
        BandEntity bandEntity = new BandEntity();
        bandEntity.setName(bandIn.getName());
        bandEntity.setSubName(bandIn.getSubName());
        bandEntity.setChannel(bandIn.getChannel());
        return bandEntity;
    }
}
