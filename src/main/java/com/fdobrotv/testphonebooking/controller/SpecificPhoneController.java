package com.fdobrotv.testphonebooking.controller;

import com.fdobrotv.testphonebooking.api.SpecificPhonesApi;
import com.fdobrotv.testphonebooking.api.SpecificPhonesbookApi;
import com.fdobrotv.testphonebooking.dto.SpecificPhone;
import com.fdobrotv.testphonebooking.dto.SpecificPhoneIn;
import com.fdobrotv.testphonebooking.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;

@Controller
@RequestMapping("${openapi.test-phone-booking.base-path:/v1}")
public class SpecificPhoneController implements SpecificPhonesApi {

    @Autowired
    private CRUDService<SpecificPhone, SpecificPhoneIn> specificPhoneService;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return SpecificPhonesApi.super.getRequest();
    }

    @Override
    public ResponseEntity<Void> deleteSpecificPhoneById(UUID id) {
        specificPhoneService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<SpecificPhone> getSpecificPhoneById(UUID id) {
        SpecificPhone specificPhone = specificPhoneService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(specificPhone);
    }

    @Override
    public ResponseEntity<SpecificPhone> createSpecificPhone(SpecificPhoneIn specificPhoneIn) {
        SpecificPhone specificPhone = specificPhoneService.create(specificPhoneIn);
        return ResponseEntity.status(CREATED).body(specificPhone);
    }

    @Override
    public ResponseEntity<List<SpecificPhone>> listSpecificPhones(Integer limit) {
        //TODO: De hard-code it.
        int pageNumber = 0;
        PageRequest pageRequest = PageRequest.of(pageNumber, limit);
        List<SpecificPhone> specificPhones = specificPhoneService.getList(pageRequest);
        return ResponseEntity.status(HttpStatus.OK).body(specificPhones);
    }
}
