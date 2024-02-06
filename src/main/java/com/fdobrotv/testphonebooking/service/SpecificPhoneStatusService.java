package com.fdobrotv.testphonebooking.service;

import com.fdobrotv.testphonebooking.dto.SpecificPhoneState;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public interface SpecificPhoneStatusService {
    SpecificPhoneState getStatusById(@NotNull @Valid UUID phoneId);
}
