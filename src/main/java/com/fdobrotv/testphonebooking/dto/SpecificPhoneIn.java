package com.fdobrotv.testphonebooking.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * SpecificPhoneIn
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-06T14:22:41.492007544+03:00[Europe/Moscow]")
public class SpecificPhoneIn {

  private UUID id;

  private UUID phoneId;

  private String inventoryNumber;

  public SpecificPhoneIn() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SpecificPhoneIn(UUID id, UUID phoneId, String inventoryNumber) {
    this.id = id;
    this.phoneId = phoneId;
    this.inventoryNumber = inventoryNumber;
  }

  public SpecificPhoneIn id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @NotNull @Valid 
  @Schema(name = "id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public SpecificPhoneIn phoneId(UUID phoneId) {
    this.phoneId = phoneId;
    return this;
  }

  /**
   * Get phoneId
   * @return phoneId
  */
  @NotNull @Valid 
  @Schema(name = "phoneId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("phoneId")
  public UUID getPhoneId() {
    return phoneId;
  }

  public void setPhoneId(UUID phoneId) {
    this.phoneId = phoneId;
  }

  public SpecificPhoneIn inventoryNumber(String inventoryNumber) {
    this.inventoryNumber = inventoryNumber;
    return this;
  }

  /**
   * Get inventoryNumber
   * @return inventoryNumber
  */
  @NotNull 
  @Schema(name = "inventoryNumber", example = "R125", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("inventoryNumber")
  public String getInventoryNumber() {
    return inventoryNumber;
  }

  public void setInventoryNumber(String inventoryNumber) {
    this.inventoryNumber = inventoryNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpecificPhoneIn specificPhoneIn = (SpecificPhoneIn) o;
    return Objects.equals(this.id, specificPhoneIn.id) &&
        Objects.equals(this.phoneId, specificPhoneIn.phoneId) &&
        Objects.equals(this.inventoryNumber, specificPhoneIn.inventoryNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, phoneId, inventoryNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpecificPhoneIn {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    phoneId: ").append(toIndentedString(phoneId)).append("\n");
    sb.append("    inventoryNumber: ").append(toIndentedString(inventoryNumber)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

