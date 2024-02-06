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
 * PhoneModel
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-06T14:22:41.492007544+03:00[Europe/Moscow]")
public class PhoneModel {

  private UUID phoneMarkId;

  private String name;

  private UUID id;

  public PhoneModel() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PhoneModel(UUID phoneMarkId, String name, UUID id) {
    this.phoneMarkId = phoneMarkId;
    this.name = name;
    this.id = id;
  }

  public PhoneModel phoneMarkId(UUID phoneMarkId) {
    this.phoneMarkId = phoneMarkId;
    return this;
  }

  /**
   * Get phoneMarkId
   * @return phoneMarkId
  */
  @NotNull @Valid 
  @Schema(name = "phoneMarkId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("phoneMarkId")
  public UUID getPhoneMarkId() {
    return phoneMarkId;
  }

  public void setPhoneMarkId(UUID phoneMarkId) {
    this.phoneMarkId = phoneMarkId;
  }

  public PhoneModel name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", example = "Galaxy S9", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PhoneModel id(UUID id) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PhoneModel phoneModel = (PhoneModel) o;
    return Objects.equals(this.phoneMarkId, phoneModel.phoneMarkId) &&
        Objects.equals(this.name, phoneModel.name) &&
        Objects.equals(this.id, phoneModel.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(phoneMarkId, name, id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PhoneModel {\n");
    sb.append("    phoneMarkId: ").append(toIndentedString(phoneMarkId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

