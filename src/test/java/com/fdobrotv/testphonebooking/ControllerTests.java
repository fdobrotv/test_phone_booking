package com.fdobrotv.testphonebooking;

import com.fdobrotv.testphonebooking.dto.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.OffsetDateTime;
import java.util.*;

import static java.time.ZoneOffset.UTC;
import static org.assertj.core.api.Assertions.assertThat;


class ControllerTests extends BaseIntegrationTest {

    @Test
    void bookAndReturnSpecificPhoneByIdTest() {
        List<SpecificPhone> specificPhones = createSpecificPhones();

        SpecificPhone specificPhone = specificPhones.get(0);

        Role role = createRole("Tester");

        User user = createUser("Test", "Testovich", "Testov", role, 1112223344, "test@email.ru");

        SpecificPhoneBook specificPhoneBook =
                createSpecificPhoneBook(specificPhone, user, HttpStatus.CREATED);
        SpecificPhoneBook specificPhoneReturn = specificPhoneReturn(specificPhone, user, HttpStatus.OK);

        assertBooking(specificPhoneBook, specificPhoneReturn, user, specificPhone);
    }

    @Test
    void bookAndReturnTheSameSpecificPhoneByIdTwiceTest() {
        List<SpecificPhone> specificPhones = createSpecificPhones();

        SpecificPhone specificPhone = specificPhones.get(0);

        Role role = createRole("Tester");

        User user = createUser("Test", "Testovich", "Testov", role, 1112223344, "test@email.ru");

        SpecificPhoneBook specificPhoneBook =
                createSpecificPhoneBook(specificPhone, user, HttpStatus.CREATED);
        SpecificPhoneBook specificPhoneBook2 =
                createSpecificPhoneBook(specificPhone, user, HttpStatus.NOT_ACCEPTABLE);

        SpecificPhoneBook specificPhoneReturn = specificPhoneReturn(specificPhone, user, HttpStatus.OK);
        SpecificPhoneBook specificPhoneReturn2 = specificPhoneReturn(specificPhone, user, HttpStatus.NOT_ACCEPTABLE);

        assertBooking(specificPhoneBook, specificPhoneReturn, user, specificPhone);
    }

    @Test
    void informationAboutSpecificPhoneByIdProvidedTest() {
        List<SpecificPhone> specificPhones = createSpecificPhones();

        SpecificPhone specificPhone = specificPhones.get(0);

        Role role = createRole("Tester");

        User user = createUser("Test", "Testovich", "Testov", role, 1112223344, "test@email.ru");

        SpecificPhone specificPhoneBeforeBook = getSpecificPhoneState(specificPhone.getId());

        assertThat(specificPhoneBeforeBook.getInventoryNumber()).isEqualTo(specificPhone.getInventoryNumber());
        assertThat(specificPhoneBeforeBook.getPhoneId()).isNotNull();
        assertThat(specificPhoneBeforeBook.getState().getIsAvailable()).isEqualTo(true);
        assertThat(specificPhoneBeforeBook.getState().getLastBookTime()).isNull();
        assertThat(specificPhoneBeforeBook.getState().getLastHolder()).isNull();

        SpecificPhoneBook specificPhoneBook =
                createSpecificPhoneBook(specificPhone, user, HttpStatus.CREATED);

        SpecificPhone specificPhoneAfterBook = getSpecificPhoneState(specificPhone.getId());

        assertThat(specificPhoneAfterBook.getInventoryNumber()).isEqualTo(specificPhone.getInventoryNumber());
        assertThat(specificPhoneAfterBook.getPhoneId()).isNotNull();
        assertThat(specificPhoneAfterBook.getState().getIsAvailable()).isEqualTo(false);
        assertThat(specificPhoneAfterBook.getState().getLastBookTime()).isBefore(OffsetDateTime.now(UTC));
        assertThat(specificPhoneAfterBook.getState().getLastHolder().getLastName()).isEqualTo(user.getLastName());

        SpecificPhoneBook specificPhoneReturn = specificPhoneReturn(specificPhone, user, HttpStatus.OK);

        SpecificPhone specificPhoneAfterReturn = getSpecificPhoneState(specificPhone.getId());

        assertThat(specificPhoneAfterReturn.getInventoryNumber()).isEqualTo(specificPhone.getInventoryNumber());
        assertThat(specificPhoneAfterReturn.getPhoneId()).isNotNull();
        assertThat(specificPhoneAfterReturn.getState().getIsAvailable()).isEqualTo(true);
        assertThat(specificPhoneAfterReturn.getState().getLastBookTime()).isBefore(OffsetDateTime.now(UTC));
        assertThat(specificPhoneAfterReturn.getState().getLastHolder().getLastName()).isEqualTo(user.getLastName());
    }

    private SpecificPhone getSpecificPhoneState(UUID id) {
        ResponseEntity<SpecificPhone> response = testRestTemplate
                .getForEntity("/v1/specificPhones/" + id, SpecificPhone.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        SpecificPhone specificPhone = response.getBody();
        assertThat(specificPhone.getId()).isNotNull();
        return specificPhone;
    }

    private Technology createTechnology(String name) {
        TechnologyIn technologyIn = new TechnologyIn().name(name);

        ResponseEntity<Technology> response =
                testRestTemplate.postForEntity("/v1/technologies", technologyIn, Technology.class);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());

        Technology technology = response.getBody();

        assertThat(technology.getId()).isNotNull();
        assertThat(technology.getName()).isEqualTo(name);

        return technology;
    }

    private void assertBooking(SpecificPhoneBook specificPhoneBook,
                               SpecificPhoneBook specificPhoneReturn,
                               User user,
                               SpecificPhone specificPhone) {
        assertThat(specificPhoneBook.getId()).isNotNull();
        assertThat(specificPhoneBook.getUser().getId()).isEqualTo(user.getId());
        assertThat(specificPhoneBook.getCreatedAt()).isBefore(OffsetDateTime.now(UTC));
        assertThat(specificPhoneBook.getSpecificPhoneId()).isEqualTo(specificPhone.getId());
        assertThat(specificPhoneReturn.getReturnedAt()).isBefore(OffsetDateTime.now(UTC));
    }

    private List<SpecificPhone> createSpecificPhones() {
        Band cdma1900 = createBand("2G", "CDMA", "1900");
        Band gsm1900 = createBand("2G", "GSM", "1900");
        Band lte66 = createBand("4G", "LTE", "66");

        List<Band> bands = List.of(cdma1900, gsm1900);
        List<Band> bandsS9 = List.of(cdma1900, gsm1900, lte66);

        Technology gsm = createTechnology("GSM");
        Technology cdma = createTechnology("CDMA");
        Technology lte = createTechnology("LTE");

        List<Technology> technologies = List.of(gsm, cdma);
        List<Technology> technologiesS9 = List.of(gsm, cdma, lte);

        SpecificPhone samsungGalaxyS9 = createSpecificPhone(
                "Samsung",
                "Galaxy S9",
                technologiesS9,
                bandsS9,
                "R125");

        SpecificPhone samsungGalaxyS8 = createSpecificPhone(
                "Samsung",
                "Galaxy S8",
                technologies,
                bands,
                "R126");

        SpecificPhone samsungGalaxyS8_2 = createSpecificPhone(
                "Samsung",
                "Galaxy S8",
                technologies,
                bands,
                "R127");

        SpecificPhone motorolaNexus = createSpecificPhone(
                "Motorola",
                "Nexus 6",
                technologies,
                bands,
                "R128");

        SpecificPhone oneplus9 = createSpecificPhone(
                "Oneplus",
                "9",
                technologies,
                bands,
                "R129");

        SpecificPhone iphone13 = createSpecificPhone(
                "Apple",
                "Iphone 13",
                technologies,
                bands,
                "R130");

        SpecificPhone iphone12 = createSpecificPhone(
                "Apple",
                "Iphone 12",
                technologies,
                bands,
                "R131");

        SpecificPhone iphone11 = createSpecificPhone(
                "Apple",
                "Iphone 11",
                technologies,
                bands,
                "R132");

        SpecificPhone iphoneX = createSpecificPhone(
                "Apple",
                "Iphone X",
                technologies,
                bands,
                "R133");

        SpecificPhone nokia3310 = createSpecificPhone(
                "Nokia",
                "3310",
                technologies,
                bands,
                "R134");

        return List.of(samsungGalaxyS9, samsungGalaxyS8, samsungGalaxyS8_2, motorolaNexus, oneplus9, iphone13,
                iphone12, iphone11, iphoneX, nokia3310);
    }

    private SpecificPhone createSpecificPhone(String mark,
                                              String model,
                                              List<Technology> technologies,
                                              List<Band> bands,
                                              String inventoryNumber) {

        PhoneMark phoneMark = getPhoneMark(mark).orElseGet(() -> createPhoneMark(mark));

        PhoneModel phoneModel = getPhoneModel(model).orElseGet(() -> createPhoneModel(model, phoneMark));

        Phone phone = createPhone(phoneModel, technologies, bands);

        return createSpecificPhone(phone, inventoryNumber);
    }

    private Optional<PhoneModel> getPhoneModel(String model) {
        ResponseEntity<PhoneModel[]> response =
                testRestTemplate.getForEntity("/v1/phoneModels", PhoneModel[].class);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

        PhoneModel[] phoneModels = response.getBody();

        return Arrays.stream(Objects.requireNonNull(phoneModels))
                .filter(phoneModel -> phoneModel.getName().equals(model))
                .findFirst();
    }

    private SpecificPhoneBook createSpecificPhoneBook(SpecificPhone specificPhone, User user, HttpStatus expectedCode) {
        SpecificPhoneBookIn specificPhoneBookIn = createSpecificPhoneBookIn(specificPhone, user);

        ResponseEntity<SpecificPhoneBook> response = testRestTemplate
                        .postForEntity("/v1/specificPhones:book",
                                specificPhoneBookIn, SpecificPhoneBook.class);

        Assertions.assertEquals(expectedCode, response.getStatusCode());

        SpecificPhoneBook specificPhoneBook = response.getBody();

        if (expectedCode.equals(HttpStatus.CREATED)) {
            assertThat(specificPhoneBook.getId()).isNotNull();
            assertThat(specificPhoneBook.getSpecificPhoneId()).isEqualTo(specificPhone.getId());
            assertThat(specificPhoneBook.getCreatedAt()).isNotNull();
            assertThat(specificPhoneBook.getCreatedAt()).isBefore(OffsetDateTime.now(UTC));
            assertThat(specificPhoneBook.getUser().getId()).isEqualTo(user.getId());
        } else {
            assertThat(specificPhoneBook.getId()).isNull();
        }

        return specificPhoneBook;
    }

    private SpecificPhoneBook specificPhoneReturn(SpecificPhone specificPhone, User user, HttpStatus httpStatus) {
        SpecificPhoneBookIn specificPhoneBookIn = createSpecificPhoneBookIn(specificPhone, user);

        ResponseEntity<SpecificPhoneBook> response = testRestTemplate
                .postForEntity("/v1/specificPhones:return",
                        specificPhoneBookIn, SpecificPhoneBook.class);

        Assertions.assertEquals(httpStatus, response.getStatusCode());

        SpecificPhoneBook specificPhoneBook = response.getBody();

        if (httpStatus.equals(HttpStatus.OK)) {
            assertThat(specificPhoneBook.getId()).isNotNull();
            assertThat(specificPhoneBook.getSpecificPhoneId()).isEqualTo(specificPhone.getId());
            assertThat(specificPhoneBook.getCreatedAt()).isNotNull();
            assertThat(specificPhoneBook.getCreatedAt()).isBefore(OffsetDateTime.now(UTC));
            assertThat(specificPhoneBook.getReturnedAt()).isNotNull();
            assertThat(specificPhoneBook.getReturnedAt()).isBefore(OffsetDateTime.now(UTC));
            assertThat(specificPhoneBook.getUser().getId()).isEqualTo(user.getId());
        } else {
            assertThat(specificPhoneBook.getId()).isNull();
        }

        return specificPhoneBook;
    }

    private Band createBand(String name, String subName, String channel) {
        BandIn bandIn = new BandIn();
        bandIn.name(name);
        bandIn.subName(subName);
        bandIn.channel(channel);

        Band band = createDTO(bandIn, Band.class);

        assertThat(band.getId()).isNotNull();
        assertThat(band.getName()).isEqualTo(name);
        assertThat(band.getSubName()).isEqualTo(subName);
        assertThat(band.getChannel()).isEqualTo(channel);

        return band;
    }

    private SpecificPhoneBookIn createSpecificPhoneBookIn(SpecificPhone specificPhone, User user) {
        SpecificPhoneBookIn specificPhoneBookIn = new SpecificPhoneBookIn();
        specificPhoneBookIn.setUserId(user.getId());
        specificPhoneBookIn.setSpecificPhoneId(specificPhone.getId());
        return specificPhoneBookIn;
    }

    private SpecificPhone createSpecificPhone(Phone phone, String inventoryNumber) {
        SpecificPhoneIn specificPhoneIn = new SpecificPhoneIn();
        specificPhoneIn.setPhoneId(phone.getId());
        specificPhoneIn.setInventoryNumber(inventoryNumber);

        return createDTO(specificPhoneIn, SpecificPhone.class);
    }

    private <E> void cleanup(List<E> order) {
        for (E dto : order) {
            deleteDTO(dto);
        }
    }

    private Role createRole(String name) {
        RoleIn roleIn = new RoleIn();
        roleIn.name(name);

        ResponseEntity<Role> response =
                testRestTemplate.postForEntity("/v1/roles", roleIn, Role.class);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());

        Role role = response.getBody();

        assertThat(role.getId()).isNotNull();
        assertThat(role.getName()).isEqualTo(name);

        return role;
    }

    private User createUser(String firstName, String middleName, String lastName, Role role, Integer phone, String email) {
        UserIn userIn = new UserIn();
        userIn.firstName(firstName);
        userIn.lastName(lastName);
        userIn.middleName(middleName);
        userIn.roleId(role.getId());
        userIn.phone(phone.toString());
        userIn.email(email);

        ResponseEntity<User> response =
                testRestTemplate.postForEntity("/v1/users", userIn, User.class);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());

        User user = response.getBody();

        assertThat(user.getId()).isNotNull();
        assertThat(user.getFirstName()).isEqualTo(firstName);
        assertThat(user.getMiddleName()).isEqualTo(middleName);
        assertThat(user.getLastName()).isEqualTo(lastName);
        assertThat(user.getRole()).isEqualTo(role.getName());
        assertThat(user.getPhone()).isEqualTo(phone.toString());
        assertThat(user.getEmail()).isEqualTo(email);
        assertThat(user.getCreatedAt()).isBefore(OffsetDateTime.now(UTC));

        return user;
    }

    private Phone createPhone(PhoneModel phoneModel, List<Technology> technologies, List<Band> bands) {
        PhoneIn phoneIn = new PhoneIn();
        phoneIn.setModelId(phoneModel.getId());
        phoneIn.setTechnologyIds(technologies.stream().map(Technology::getId).toList());
        phoneIn.setBandIds(bands.stream().map(Band::getId).toList());

        ResponseEntity<Phone> response =
                testRestTemplate.postForEntity("/v1/phones", phoneIn, Phone.class);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());

        Phone phone = response.getBody();

        assertThat(phone.getId()).isNotNull();
        assertThat(phone.getTechnologies()).isEqualTo(technologies);
        assertThat(phone.getBands()).isEqualTo(bands);

        return phone;
    }

    private PhoneMark createPhoneMark(String mark) {
        PhoneMarkIn phoneMarkIn = new PhoneMarkIn();
        phoneMarkIn.setName(mark);

        ResponseEntity<PhoneMark> response =
                testRestTemplate.postForEntity("/v1/phoneMarks", phoneMarkIn, PhoneMark.class);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());

        PhoneMark phoneMark = response.getBody();

        assertThat(phoneMark.getId()).isNotNull();
        assertThat(phoneMark.getName()).isEqualTo(mark);

        return phoneMark;
    }

    private Optional<PhoneMark> getPhoneMark(String mark) {
        ResponseEntity<PhoneMark[]> response =
                testRestTemplate.getForEntity("/v1/phoneMarks", PhoneMark[].class);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

        PhoneMark[] phoneMarks = response.getBody();

        return Arrays.stream(Objects.requireNonNull(phoneMarks))
                .filter(phoneMark -> phoneMark.getName().equals(mark))
                .findFirst();
    }

    private PhoneModel createPhoneModel(String modelName, PhoneMark phoneMark) {
        PhoneModelIn phoneModelIn = new PhoneModelIn();
        phoneModelIn.setName(modelName);
        phoneModelIn.setPhoneMarkId(phoneMark.getId());
        ResponseEntity<PhoneModel> response =
                testRestTemplate.postForEntity("/v1/phoneModels", phoneModelIn, PhoneModel.class);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());

        PhoneModel phoneModel = response.getBody();

        assertThat(phoneModel.getId()).isNotNull();
        assertThat(phoneModel.getName()).isEqualTo(modelName);
        assertThat(phoneModel.getPhoneMarkId()).isEqualTo(phoneMark.getId());

        return phoneModel;
    }

}
