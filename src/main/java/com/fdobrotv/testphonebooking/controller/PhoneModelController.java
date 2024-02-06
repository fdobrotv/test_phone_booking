package com.fdobrotv.testphonebooking.controller;

import com.fdobrotv.testphonebooking.api.PhoneModelsApi;
import com.fdobrotv.testphonebooking.dto.PhoneModel;
import com.fdobrotv.testphonebooking.dto.PhoneModelIn;
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
public class PhoneModelController implements PhoneModelsApi {

    private final CRUDService<PhoneModel, PhoneModelIn> phoneModelService;

    public PhoneModelController(CRUDService<PhoneModel, PhoneModelIn> phoneModelService) {
        this.phoneModelService = phoneModelService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return PhoneModelsApi.super.getRequest();
    }

    @Override
    public ResponseEntity<Void> deletePhoneModelById(UUID id) {
        phoneModelService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<PhoneModel> getPhoneModelById(UUID id) {
        PhoneModel phoneModel = phoneModelService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(phoneModel);
    }

    @Override
    public ResponseEntity<PhoneModel> createPhoneModel(PhoneModelIn phoneModelIn) {
        PhoneModel phoneModel = phoneModelService.create(phoneModelIn);
        return ResponseEntity.status(HttpStatus.CREATED).body(phoneModel);
    }

    @Override
    public ResponseEntity<List<PhoneModel>> listPhoneModels(Integer limit) {
        //TODO: De hard-code it.
        int pageNumber = 0;
        PageRequest pageRequest = PageRequest.of(pageNumber, limit);
        List<PhoneModel> phoneModels = phoneModelService.getList(pageRequest);
        return ResponseEntity.status(HttpStatus.OK).body(phoneModels);
    }
}
