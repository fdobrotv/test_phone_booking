package com.fdobrotv.testphonebooking.controller;

import com.fdobrotv.testphonebooking.api.BandsApi;
import com.fdobrotv.testphonebooking.dto.Band;
import com.fdobrotv.testphonebooking.dto.BandIn;
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
public class BandController implements BandsApi {

    private final CRUDService<Band, BandIn> bandService;

    public BandController(CRUDService<Band, BandIn> bandService) {
        this.bandService = bandService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return BandsApi.super.getRequest();
    }

    @Override
    public ResponseEntity<Void> deleteBandById(UUID id) {
        bandService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<Band> getBandById(UUID id) {
        Band band = bandService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(band);
    }

    @Override
    public ResponseEntity<Band> createBand(BandIn phoneModelIn) {
        Band band = bandService.create(phoneModelIn);
        return ResponseEntity.status(HttpStatus.CREATED).body(band);
    }

    @Override
    public ResponseEntity<List<Band>> listBands(Integer limit) {
        //TODO: De hard-code it.
        int pageNumber = 0;
        PageRequest pageRequest = PageRequest.of(pageNumber, limit);
        List<Band> bands = bandService.getList(pageRequest);
        return ResponseEntity.status(HttpStatus.OK).body(bands);
    }
}
