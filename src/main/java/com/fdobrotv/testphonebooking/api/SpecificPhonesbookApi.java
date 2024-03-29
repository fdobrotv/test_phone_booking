/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.2.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.fdobrotv.testphonebooking.api;

import com.fdobrotv.testphonebooking.dto.Error;
import com.fdobrotv.testphonebooking.dto.SpecificPhoneBook;
import com.fdobrotv.testphonebooking.dto.SpecificPhoneBookIn;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-06T14:22:41.492007544+03:00[Europe/Moscow]")
@Validated
@Tag(name = "specificPhones", description = "the specificPhones API")
public interface SpecificPhonesbookApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /specificPhones:book : Book a \&quot;specific phone\&quot; by id
     *
     * @param specificPhoneBookIn  (optional)
     * @return Expected response to a valid request (status code 201)
     *         or unexpected error (status code 200)
     */
    @Operation(
        operationId = "bookSpecificPhoneById",
        summary = "Book a \"specific phone\" by id",
        tags = { "specificPhones" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Expected response to a valid request", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = SpecificPhoneBook.class))
            }),
            @ApiResponse(responseCode = "default", description = "unexpected error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/specificPhones:book",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<SpecificPhoneBook> bookSpecificPhoneById(
        @Parameter(name = "SpecificPhoneBookIn", description = "") @Valid @RequestBody(required = false) SpecificPhoneBookIn specificPhoneBookIn
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"returnedAt\" : \"2000-01-23T04:56:07.000+00:00\", \"specificPhoneId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"user\" : { \"firstName\" : \"Василий\", \"lastName\" : \"Пупкин\", \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\", \"role\" : \"Tester\", \"phone\" : \"79993336677\", \"middleName\" : \"Веселович\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"email\" : \"vasiliy@pupkin.ru\" } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
