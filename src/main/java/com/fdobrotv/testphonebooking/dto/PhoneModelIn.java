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
 * PhoneModelIn
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-06T14:22:41.492007544+03:00[Europe/Moscow]")
public class PhoneModelIn {

  private UUID phoneMarkId;

  private String name;

  public PhoneModelIn() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PhoneModelIn(UUID phoneMarkId, String name) {
    this.phoneMarkId = phoneMarkId;
    this.name = name;
  }

  public PhoneModelIn phoneMarkId(UUID phoneMarkId) {
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

  public PhoneModelIn name(String name) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PhoneModelIn phoneModelIn = (PhoneModelIn) o;
    return Objects.equals(this.phoneMarkId, phoneModelIn.phoneMarkId) &&
        Objects.equals(this.name, phoneModelIn.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(phoneMarkId, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PhoneModelIn {\n");
    sb.append("    phoneMarkId: ").append(toIndentedString(phoneMarkId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

