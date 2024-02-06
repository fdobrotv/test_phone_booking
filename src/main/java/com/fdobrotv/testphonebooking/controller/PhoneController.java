package com.fdobrotv.testphonebooking.controller;

import com.fdobrotv.testphonebooking.api.PhonesApi;
import com.fdobrotv.testphonebooking.dto.Phone;
import com.fdobrotv.testphonebooking.dto.PhoneIn;
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
@RequestMapping("${openapi.phonegoDelivery.base-path:/v1}")
public class PhoneController implements PhonesApi {

    @Autowired
    private CRUDService<Phone, PhoneIn> phoneService;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return PhonesApi.super.getRequest();
    }

    @Override
    public ResponseEntity<Void> deletePhoneById(UUID id) {
        phoneService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<Phone> getPhoneById(UUID id) {
        Phone phone = phoneService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(phone);
    }

    @Override
    public ResponseEntity<Phone> createPhone(PhoneIn phoneIn) {
        Phone phone = phoneService.create(phoneIn);
        return ResponseEntity.status(CREATED).body(phone);
    }

    @Override
    public ResponseEntity<List<Phone>> listPhones(Integer limit) {
        //TODO: De hard-code it.
        int pageNumber = 0;
        PageRequest pageRequest = PageRequest.of(pageNumber, limit);
        List<Phone> phones = phoneService.getList(pageRequest);
        return ResponseEntity.status(HttpStatus.OK).body(phones);
    }
}
