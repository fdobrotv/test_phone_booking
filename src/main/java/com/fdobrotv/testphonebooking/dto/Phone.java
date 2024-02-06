package com.fdobrotv.testphonebooking.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fdobrotv.testphonebooking.dto.Band;
import com.fdobrotv.testphonebooking.dto.Technology;
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
 * Phone
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-06T14:22:41.492007544+03:00[Europe/Moscow]")
public class Phone {

  private UUID id;

  private String model;

  @Valid
  private List<@Valid Technology> technologies = new ArrayList<>();

  @Valid
  private List<@Valid Band> bands = new ArrayList<>();

  public Phone() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Phone(UUID id, String model, List<@Valid Technology> technologies, List<@Valid Band> bands) {
    this.id = id;
    this.model = model;
    this.technologies = technologies;
    this.bands = bands;
  }

  public Phone id(UUID id) {
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

  public Phone model(String model) {
    this.model = model;
    return this;
  }

  /**
   * Get model
   * @return model
  */
  @NotNull 
  @Schema(name = "model", example = "Galaxy S9", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("model")
  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Phone technologies(List<@Valid Technology> technologies) {
    this.technologies = technologies;
    return this;
  }

  public Phone addTechnologiesItem(Technology technologiesItem) {
    if (this.technologies == null) {
      this.technologies = new ArrayList<>();
    }
    this.technologies.add(technologiesItem);
    return this;
  }

  /**
   * Get technologies
   * @return technologies
  */
  @NotNull @Valid @Size(max = 100) 
  @Schema(name = "technologies", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("technologies")
  public List<@Valid Technology> getTechnologies() {
    return technologies;
  }

  public void setTechnologies(List<@Valid Technology> technologies) {
    this.technologies = technologies;
  }

  public Phone bands(List<@Valid Band> bands) {
    this.bands = bands;
    return this;
  }

  public Phone addBandsItem(Band bandsItem) {
    if (this.bands == null) {
      this.bands = new ArrayList<>();
    }
    this.bands.add(bandsItem);
    return this;
  }

  /**
   * Get bands
   * @return bands
  */
  @NotNull @Valid @Size(max = 100) 
  @Schema(name = "bands", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("bands")
  public List<@Valid Band> getBands() {
    return bands;
  }

  public void setBands(List<@Valid Band> bands) {
    this.bands = bands;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Phone phone = (Phone) o;
    return Objects.equals(this.id, phone.id) &&
        Objects.equals(this.model, phone.model) &&
        Objects.equals(this.technologies, phone.technologies) &&
        Objects.equals(this.bands, phone.bands);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, model, technologies, bands);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Phone {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
    sb.append("    technologies: ").append(toIndentedString(technologies)).append("\n");
    sb.append("    bands: ").append(toIndentedString(bands)).append("\n");
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

