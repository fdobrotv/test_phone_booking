/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.2.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.fdobrotv.testphonebooking.api;

import com.fdobrotv.testphonebooking.dto.Band;
import com.fdobrotv.testphonebooking.dto.BandIn;
import com.fdobrotv.testphonebooking.dto.Error;
import java.util.UUID;
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
@Tag(name = "bands", description = "the bands API")
public interface BandsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /bands : Create a band
     *
     * @param bandIn  (optional)
     * @return Ok (status code 201)
     *         or unexpected error (status code 200)
     */
    @Operation(
        operationId = "createBand",
        summary = "Create a band",
        tags = { "bands" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Ok", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Band.class))
            }),
            @ApiResponse(responseCode = "default", description = "unexpected error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/bands",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Band> createBand(
        @Parameter(name = "BandIn", description = "") @Valid @RequestBody(required = false) BandIn bandIn
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"subName\" : \"CDMA\", \"name\" : \"2G\", \"channel\" : \"1900\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /bands/{id} : Delete specific band by id
     *
     * @param id The id of the resource to delete (required)
     * @return Resource deleted successfully (status code 204)
     *         or unexpected error (status code 200)
     */
    @Operation(
        operationId = "deleteBandById",
        summary = "Delete specific band by id",
        tags = { "bands" },
        responses = {
            @ApiResponse(responseCode = "204", description = "Resource deleted successfully"),
            @ApiResponse(responseCode = "default", description = "unexpected error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/bands/{id}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<Void> deleteBandById(
        @Parameter(name = "id", description = "The id of the resource to delete", required = true, in = ParameterIn.PATH) @PathVariable("id") UUID id
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /bands/{id} : Info for a specific bands
     *
     * @param id The id of the resource to retrieve (required)
     * @return Expected response to a valid request (status code 200)
     *         or unexpected error (status code 200)
     */
    @Operation(
        operationId = "getBandById",
        summary = "Info for a specific bands",
        tags = { "bands" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Expected response to a valid request", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Band.class))
            }),
            @ApiResponse(responseCode = "default", description = "unexpected error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/bands/{id}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<Band> getBandById(
        @Parameter(name = "id", description = "The id of the resource to retrieve", required = true, in = ParameterIn.PATH) @PathVariable("id") UUID id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"subName\" : \"CDMA\", \"name\" : \"2G\", \"channel\" : \"1900\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /bands : List all bands
     *
     * @param limit How many items to return at one time (max 100) (optional)
     * @return A paged array of bands (status code 200)
     *         or unexpected error (status code 200)
     */
    @Operation(
        operationId = "listBands",
        summary = "List all bands",
        tags = { "bands" },
        responses = {
            @ApiResponse(responseCode = "200", description = "A paged array of bands", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Band.class)))
            }),
            @ApiResponse(responseCode = "default", description = "unexpected error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/bands",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<Band>> listBands(
        @Max(100) @Parameter(name = "limit", description = "How many items to return at one time (max 100)", in = ParameterIn.QUERY) @Valid @RequestParam(value = "limit", required = false) Integer limit
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"subName\" : \"CDMA\", \"name\" : \"2G\", \"channel\" : \"1900\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }, { \"subName\" : \"CDMA\", \"name\" : \"2G\", \"channel\" : \"1900\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }, { \"subName\" : \"CDMA\", \"name\" : \"2G\", \"channel\" : \"1900\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }, { \"subName\" : \"CDMA\", \"name\" : \"2G\", \"channel\" : \"1900\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }, { \"subName\" : \"CDMA\", \"name\" : \"2G\", \"channel\" : \"1900\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
