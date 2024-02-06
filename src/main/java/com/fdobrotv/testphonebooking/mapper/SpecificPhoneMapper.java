package com.fdobrotv.testphonebooking.mapper;

import com.fdobrotv.testphonebooking.dto.SpecificPhone;
import com.fdobrotv.testphonebooking.dto.SpecificPhoneIn;
import com.fdobrotv.testphonebooking.dto.SpecificPhoneState;
import com.fdobrotv.testphonebooking.entity.PhoneEntity;
import com.fdobrotv.testphonebooking.entity.SpecificPhoneEntity;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class SpecificPhoneMapper {
    public static SpecificPhone toDTO(SpecificPhoneEntity specificPhoneEntity, SpecificPhoneState specificPhoneState) {
        SpecificPhone specificPhone = new SpecificPhone();
        specificPhone.id(specificPhoneEntity.getId());
        specificPhone.phoneId(specificPhoneEntity.getPhone().getId());
        specificPhone.inventoryNumber(specificPhoneEntity.getInventoryNumber());
        specificPhone.state(specificPhoneState);
        return specificPhone;
    }

    public static List<SpecificPhone> toDTO(List<Pair<SpecificPhoneEntity, SpecificPhoneState>> specificPhoneEntities) {
        return specificPhoneEntities.stream()
                .map(SpecificPhoneMapper::toDTO)
                .collect(Collectors.toList());
    }

    private static SpecificPhone toDTO(Pair<SpecificPhoneEntity,
            SpecificPhoneState> specificPhoneEntitySpecificPhoneStateEntry) {
        return toDTO(
                specificPhoneEntitySpecificPhoneStateEntry.getLeft(),
                specificPhoneEntitySpecificPhoneStateEntry.getRight()
        );
    }

    public static SpecificPhoneEntity toEntity(SpecificPhoneIn specificPhoneIn, PhoneEntity phoneEntity) {
        SpecificPhoneEntity specificPhoneEntity = new SpecificPhoneEntity();
        specificPhoneEntity.setPhone(phoneEntity);
        specificPhoneEntity.setInventoryNumber(specificPhoneIn.getInventoryNumber());
        return specificPhoneEntity;
    }
}
