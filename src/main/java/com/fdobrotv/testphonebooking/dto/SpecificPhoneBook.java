package com.fdobrotv.testphonebooking.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fdobrotv.testphonebooking.dto.User;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * SpecificPhoneBook
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-06T14:22:41.492007544+03:00[Europe/Moscow]")
public class SpecificPhoneBook {

  private UUID id;

  private UUID specificPhoneId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime createdAt;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime returnedAt;

  private User user;

  public SpecificPhoneBook() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SpecificPhoneBook(UUID id, UUID specificPhoneId, OffsetDateTime createdAt, OffsetDateTime returnedAt, User user) {
    this.id = id;
    this.specificPhoneId = specificPhoneId;
    this.createdAt = createdAt;
    this.returnedAt = returnedAt;
    this.user = user;
  }

  public SpecificPhoneBook id(UUID id) {
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

  public SpecificPhoneBook specificPhoneId(UUID specificPhoneId) {
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

  public SpecificPhoneBook createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Get createdAt
   * @return createdAt
  */
  @NotNull @Valid 
  @Schema(name = "createdAt", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("createdAt")
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public SpecificPhoneBook returnedAt(OffsetDateTime returnedAt) {
    this.returnedAt = returnedAt;
    return this;
  }

  /**
   * Get returnedAt
   * @return returnedAt
  */
  @NotNull @Valid 
  @Schema(name = "returnedAt", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("returnedAt")
  public OffsetDateTime getReturnedAt() {
    return returnedAt;
  }

  public void setReturnedAt(OffsetDateTime returnedAt) {
    this.returnedAt = returnedAt;
  }

  public SpecificPhoneBook user(User user) {
    this.user = user;
    return this;
  }

  /**
   * Get user
   * @return user
  */
  @NotNull @Valid 
  @Schema(name = "user", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("user")
  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpecificPhoneBook specificPhoneBook = (SpecificPhoneBook) o;
    return Objects.equals(this.id, specificPhoneBook.id) &&
        Objects.equals(this.specificPhoneId, specificPhoneBook.specificPhoneId) &&
        Objects.equals(this.createdAt, specificPhoneBook.createdAt) &&
        Objects.equals(this.returnedAt, specificPhoneBook.returnedAt) &&
        Objects.equals(this.user, specificPhoneBook.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, specificPhoneId, createdAt, returnedAt, user);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpecificPhoneBook {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    specificPhoneId: ").append(toIndentedString(specificPhoneId)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    returnedAt: ").append(toIndentedString(returnedAt)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
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

