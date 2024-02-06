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
 * SpecificPhoneReturnIn
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-06T14:22:41.492007544+03:00[Europe/Moscow]")
public class SpecificPhoneReturnIn {

  private UUID specificPhoneId;

  public SpecificPhoneReturnIn() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SpecificPhoneReturnIn(UUID specificPhoneId) {
    this.specificPhoneId = specificPhoneId;
  }

  public SpecificPhoneReturnIn specificPhoneId(UUID specificPhoneId) {
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
    SpecificPhoneReturnIn specificPhoneReturnIn = (SpecificPhoneReturnIn) o;
    return Objects.equals(this.specificPhoneId, specificPhoneReturnIn.specificPhoneId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(specificPhoneId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpecificPhoneReturnIn {\n");
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

