package com.fdobrotv.testphonebooking.controller;

import com.fdobrotv.testphonebooking.api.TechnologiesApi;
import com.fdobrotv.testphonebooking.dto.Technology;
import com.fdobrotv.testphonebooking.dto.TechnologyIn;
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
public class TechnologyController implements TechnologiesApi {

    private final CRUDService<Technology, TechnologyIn> technologyService;

    public TechnologyController(CRUDService<Technology, TechnologyIn> technologyService) {
        this.technologyService = technologyService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return TechnologiesApi.super.getRequest();
    }

    @Override
    public ResponseEntity<Void> deleteTechnologyById(UUID id) {
        technologyService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<Technology> getTechnologyById(UUID id) {
        Technology technology = technologyService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(technology);
    }

    @Override
    public ResponseEntity<Technology> createTechnology(TechnologyIn phoneModelIn) {
        Technology technology = technologyService.create(phoneModelIn);
        return ResponseEntity.status(HttpStatus.CREATED).body(technology);
    }

    @Override
    public ResponseEntity<List<Technology>> listTechnologies(Integer limit) {
        //TODO: De hard-code it.
        int pageNumber = 0;
        PageRequest pageRequest = PageRequest.of(pageNumber, limit);
        List<Technology> technologies = technologyService.getList(pageRequest);
        return ResponseEntity.status(HttpStatus.OK).body(technologies);
    }
}
