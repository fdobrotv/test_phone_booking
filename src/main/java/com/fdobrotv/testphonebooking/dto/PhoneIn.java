package com.fdobrotv.testphonebooking.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * PhoneIn
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-06T14:22:41.492007544+03:00[Europe/Moscow]")
public class PhoneIn {

  private UUID modelId;

  @Valid
  private List<UUID> technologyIds = new ArrayList<>();

  @Valid
  private List<UUID> bandIds = new ArrayList<>();

  public PhoneIn() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PhoneIn(UUID modelId, List<UUID> technologyIds, List<UUID> bandIds) {
    this.modelId = modelId;
    this.technologyIds = technologyIds;
    this.bandIds = bandIds;
  }

  public PhoneIn modelId(UUID modelId) {
    this.modelId = modelId;
    return this;
  }

  /**
   * Get modelId
   * @return modelId
  */
  @NotNull @Valid 
  @Schema(name = "modelId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("modelId")
  public UUID getModelId() {
    return modelId;
  }

  public void setModelId(UUID modelId) {
    this.modelId = modelId;
  }

  public PhoneIn technologyIds(List<UUID> technologyIds) {
    this.technologyIds = technologyIds;
    return this;
  }

  public PhoneIn addTechnologyIdsItem(UUID technologyIdsItem) {
    if (this.technologyIds == null) {
      this.technologyIds = new ArrayList<>();
    }
    this.technologyIds.add(technologyIdsItem);
    return this;
  }

  /**
   * Get technologyIds
   * @return technologyIds
  */
  @NotNull @Valid @Size(max = 100) 
  @Schema(name = "technologyIds", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("technologyIds")
  public List<UUID> getTechnologyIds() {
    return technologyIds;
  }

  public void setTechnologyIds(List<UUID> technologyIds) {
    this.technologyIds = technologyIds;
  }

  public PhoneIn bandIds(List<UUID> bandIds) {
    this.bandIds = bandIds;
    return this;
  }

  public PhoneIn addBandIdsItem(UUID bandIdsItem) {
    if (this.bandIds == null) {
      this.bandIds = new ArrayList<>();
    }
    this.bandIds.add(bandIdsItem);
    return this;
  }

  /**
   * Get bandIds
   * @return bandIds
  */
  @NotNull @Valid @Size(max = 100) 
  @Schema(name = "bandIds", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("bandIds")
  public List<UUID> getBandIds() {
    return bandIds;
  }

  public void setBandIds(List<UUID> bandIds) {
    this.bandIds = bandIds;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PhoneIn phoneIn = (PhoneIn) o;
    return Objects.equals(this.modelId, phoneIn.modelId) &&
        Objects.equals(this.technologyIds, phoneIn.technologyIds) &&
        Objects.equals(this.bandIds, phoneIn.bandIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(modelId, technologyIds, bandIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PhoneIn {\n");
    sb.append("    modelId: ").append(toIndentedString(modelId)).append("\n");
    sb.append("    technologyIds: ").append(toIndentedString(technologyIds)).append("\n");
    sb.append("    bandIds: ").append(toIndentedString(bandIds)).append("\n");
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

