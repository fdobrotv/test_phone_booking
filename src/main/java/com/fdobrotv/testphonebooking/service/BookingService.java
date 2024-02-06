package com.fdobrotv.testphonebooking.service;

import com.fdobrotv.testphonebooking.dto.SpecificPhoneBook;
import com.fdobrotv.testphonebooking.dto.SpecificPhoneState;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public interface BookingService {
    SpecificPhoneBook bookById(@NotNull @Valid UUID phoneId, @NotNull @Valid UUID userId);

    SpecificPhoneBook returnById(@NotNull @Valid UUID phoneId);
}
