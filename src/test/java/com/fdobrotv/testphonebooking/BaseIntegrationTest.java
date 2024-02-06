package com.fdobrotv.testphonebooking;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;

@Log
@Rollback
@ExtendWith(SpringExtension.class)
@Transactional(propagation = Propagation.NESTED)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseIntegrationTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    <IN, OUT> OUT createDTO(IN inDTO, Class<OUT> outClazz) {

        String simpleName = outClazz.getSimpleName();
        String lowerCaseName = lowerCaseFirstLetter(simpleName);
        String url = "/v1/" + lowerCaseName + "s";

        ResponseEntity<OUT> response =
                testRestTemplate.postForEntity(url, inDTO, outClazz);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());

        return response.getBody();
    }

    void deleteDTO(Object dto) {
        Field field;
        Object idValue;
        try {
            field = dto.getClass().getDeclaredField("id");
            field.setAccessible(true);
            idValue = field.get(dto);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            log.info("Should use DTO with id!");
            throw new RuntimeException(e);
        }

        String simpleName = dto.getClass().getSimpleName();
        String lowerCaseName = lowerCaseFirstLetter(simpleName);
        String url = "/v1/" + lowerCaseName + "s/";
        String fullURL = url + idValue;
        ResponseEntity<Void> exchange =
                testRestTemplate.exchange(
                        fullURL,
                        HttpMethod.DELETE,
                        null,
                        Void.class);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, exchange.getStatusCode());

        ResponseEntity<Void> response =
                testRestTemplate.getForEntity(url, Void.class);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    static String lowerCaseFirstLetter(String simpleName) {
        if (simpleName.isBlank())
            return simpleName;
        char[] chars = simpleName.toCharArray();
        chars[0] += 32;
        return new String(chars);
    }
}
