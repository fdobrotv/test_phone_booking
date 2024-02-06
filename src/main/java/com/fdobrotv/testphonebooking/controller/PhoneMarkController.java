package com.fdobrotv.testphonebooking.controller;

import com.fdobrotv.testphonebooking.api.PhoneMarksApi;
import com.fdobrotv.testphonebooking.dto.PhoneMark;
import com.fdobrotv.testphonebooking.dto.PhoneMarkIn;
import com.fdobrotv.testphonebooking.service.CRUDService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("${openapi.test-phone-booking.base-path:/v1}")
public class PhoneMarkController implements PhoneMarksApi {

    private final CRUDService<PhoneMark, PhoneMarkIn> phoneMarkService;

    public PhoneMarkController(CRUDService<PhoneMark, PhoneMarkIn> phoneMarkService) {
        this.phoneMarkService = phoneMarkService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return PhoneMarksApi.super.getRequest();
    }

    @Override
    public ResponseEntity<Void> deletePhoneMarkById(UUID id) {
        phoneMarkService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<PhoneMark> getPhoneMarkById(UUID id) {
        PhoneMark phoneMark = phoneMarkService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(phoneMark);
    }

    @Override
    public ResponseEntity<PhoneMark> createPhoneMark(PhoneMarkIn phoneModelIn) {
        PhoneMark phoneMark = phoneMarkService.create(phoneModelIn);
        return ResponseEntity.status(HttpStatus.CREATED).body(phoneMark);
    }

    @Override
    public ResponseEntity<List<PhoneMark>> listPhoneMarks(Integer limit) {
        //TODO: De hard-code it.
        int pageNumber = 0;
        PageRequest pageRequest = PageRequest.of(pageNumber, limit);
        List<PhoneMark> phoneMarks = phoneMarkService.getList(pageRequest);
        return ResponseEntity.status(HttpStatus.OK).body(phoneMarks);
    }
}
