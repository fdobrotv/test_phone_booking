package com.fdobrotv.testphonebooking.controller;

import com.fdobrotv.testphonebooking.api.SpecificPhonesApi;
import com.fdobrotv.testphonebooking.api.SpecificPhonesbookApi;
import com.fdobrotv.testphonebooking.api.SpecificPhonesreturnApi;
import com.fdobrotv.testphonebooking.dto.*;
import com.fdobrotv.testphonebooking.service.BookingService;
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
public class SpecificPhoneBookReturnController implements SpecificPhonesbookApi, SpecificPhonesreturnApi {

    @Autowired
    private BookingService bookingService;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return SpecificPhonesbookApi.super.getRequest();
    }

    @Override
    public ResponseEntity<SpecificPhoneBook> bookSpecificPhoneById(SpecificPhoneBookIn specificPhoneBookIn) {
        SpecificPhoneBook specificPhoneBook = bookingService.bookById(specificPhoneBookIn.getSpecificPhoneId(),
                specificPhoneBookIn.getUserId());
        return ResponseEntity.status(CREATED).body(specificPhoneBook);
    }

    @Override
    public ResponseEntity<SpecificPhoneBook> returnSpecificPhoneById(SpecificPhoneReturnIn specificPhoneReturnIn) {
        SpecificPhoneBook specificPhoneReturn = bookingService.returnById(specificPhoneReturnIn.getSpecificPhoneId());
        return ResponseEntity.status(HttpStatus.OK).body(specificPhoneReturn);
    }
}
