package com.fdobrotv.testphonebooking.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fdobrotv.testphonebooking.dto.SpecificPhoneState;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * SpecificPhone
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-06T14:22:41.492007544+03:00[Europe/Moscow]")
public class SpecificPhone {

  private UUID id;

  private UUID phoneId;

  private String inventoryNumber;

  private SpecificPhoneState state;

  public SpecificPhone() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SpecificPhone(UUID id, UUID phoneId, String inventoryNumber, SpecificPhoneState state) {
    this.id = id;
    this.phoneId = phoneId;
    this.inventoryNumber = inventoryNumber;
    this.state = state;
  }

  public SpecificPhone id(UUID id) {
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

  public SpecificPhone phoneId(UUID phoneId) {
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

  public SpecificPhone inventoryNumber(String inventoryNumber) {
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

  public SpecificPhone state(SpecificPhoneState state) {
    this.state = state;
    return this;
  }

  /**
   * Get state
   * @return state
  */
  @NotNull @Valid 
  @Schema(name = "state", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("state")
  public SpecificPhoneState getState() {
    return state;
  }

  public void setState(SpecificPhoneState state) {
    this.state = state;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpecificPhone specificPhone = (SpecificPhone) o;
    return Objects.equals(this.id, specificPhone.id) &&
        Objects.equals(this.phoneId, specificPhone.phoneId) &&
        Objects.equals(this.inventoryNumber, specificPhone.inventoryNumber) &&
        Objects.equals(this.state, specificPhone.state);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, phoneId, inventoryNumber, state);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpecificPhone {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    phoneId: ").append(toIndentedString(phoneId)).append("\n");
    sb.append("    inventoryNumber: ").append(toIndentedString(inventoryNumber)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
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

