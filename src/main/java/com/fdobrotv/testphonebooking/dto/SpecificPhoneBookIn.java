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
 * SpecificPhoneBookIn
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-06T14:22:41.492007544+03:00[Europe/Moscow]")
public class SpecificPhoneBookIn {

  private UUID userId;

  private UUID specificPhoneId;

  public SpecificPhoneBookIn() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SpecificPhoneBookIn(UUID userId, UUID specificPhoneId) {
    this.userId = userId;
    this.specificPhoneId = specificPhoneId;
  }

  public SpecificPhoneBookIn userId(UUID userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  */
  @NotNull @Valid 
  @Schema(name = "userId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("userId")
  public UUID getUserId() {
    return userId;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  public SpecificPhoneBookIn specificPhoneId(UUID specificPhoneId) {
    this.specificPhoneId = specificPhoneId;
    return this;
  }

  /**
   * Get specificPhoneId
   * @return specificPhoneId
  */
  @NotNull @Valid 
  @Schema(name = "specificPhoneId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("specificPhoneId")
  public UUID getSpecificPhoneId() {
    return specificPhoneId;
  }

  public void setSpecificPhoneId(UUID specificPhoneId) {
    this.specificPhoneId = specificPhoneId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpecificPhoneBookIn specificPhoneBookIn = (SpecificPhoneBookIn) o;
    return Objects.equals(this.userId, specificPhoneBookIn.userId) &&
        Objects.equals(this.specificPhoneId, specificPhoneBookIn.specificPhoneId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, specificPhoneId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpecificPhoneBookIn {\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    specificPhoneId: ").append(toIndentedString(specificPhoneId)).append("\n");
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

