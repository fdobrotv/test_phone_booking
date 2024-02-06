package com.fdobrotv.testphonebooking.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fdobrotv.testphonebooking.dto.User;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * SpecificPhoneState
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-06T14:22:41.492007544+03:00[Europe/Moscow]")
public class SpecificPhoneState {

  private Boolean isAvailable;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime lastBookTime;

  private User lastHolder;

  public SpecificPhoneState() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SpecificPhoneState(Boolean isAvailable, OffsetDateTime lastBookTime, User lastHolder) {
    this.isAvailable = isAvailable;
    this.lastBookTime = lastBookTime;
    this.lastHolder = lastHolder;
  }

  public SpecificPhoneState isAvailable(Boolean isAvailable) {
    this.isAvailable = isAvailable;
    return this;
  }

  /**
   * Get isAvailable
   * @return isAvailable
  */
  @NotNull 
  @Schema(name = "isAvailable", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("isAvailable")
  public Boolean getIsAvailable() {
    return isAvailable;
  }

  public void setIsAvailable(Boolean isAvailable) {
    this.isAvailable = isAvailable;
  }

  public SpecificPhoneState lastBookTime(OffsetDateTime lastBookTime) {
    this.lastBookTime = lastBookTime;
    return this;
  }

  /**
   * Get lastBookTime
   * @return lastBookTime
  */
  @NotNull @Valid 
  @Schema(name = "lastBookTime", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("lastBookTime")
  public OffsetDateTime getLastBookTime() {
    return lastBookTime;
  }

  public void setLastBookTime(OffsetDateTime lastBookTime) {
    this.lastBookTime = lastBookTime;
  }

  public SpecificPhoneState lastHolder(User lastHolder) {
    this.lastHolder = lastHolder;
    return this;
  }

  /**
   * Get lastHolder
   * @return lastHolder
  */
  @NotNull @Valid 
  @Schema(name = "lastHolder", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("lastHolder")
  public User getLastHolder() {
    return lastHolder;
  }

  public void setLastHolder(User lastHolder) {
    this.lastHolder = lastHolder;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpecificPhoneState specificPhoneState = (SpecificPhoneState) o;
    return Objects.equals(this.isAvailable, specificPhoneState.isAvailable) &&
        Objects.equals(this.lastBookTime, specificPhoneState.lastBookTime) &&
        Objects.equals(this.lastHolder, specificPhoneState.lastHolder);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isAvailable, lastBookTime, lastHolder);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpecificPhoneState {\n");
    sb.append("    isAvailable: ").append(toIndentedString(isAvailable)).append("\n");
    sb.append("    lastBookTime: ").append(toIndentedString(lastBookTime)).append("\n");
    sb.append("    lastHolder: ").append(toIndentedString(lastHolder)).append("\n");
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

