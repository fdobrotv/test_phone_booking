package com.fdobrotv.testphonebooking.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * BandIn
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-06T14:22:41.492007544+03:00[Europe/Moscow]")
public class BandIn {

  private String name;

  private String subName;

  private String channel;

  public BandIn() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public BandIn(String name, String subName, String channel) {
    this.name = name;
    this.subName = subName;
    this.channel = channel;
  }

  public BandIn name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", example = "2G", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BandIn subName(String subName) {
    this.subName = subName;
    return this;
  }

  /**
   * Get subName
   * @return subName
  */
  @NotNull 
  @Schema(name = "subName", example = "CDMA", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("subName")
  public String getSubName() {
    return subName;
  }

  public void setSubName(String subName) {
    this.subName = subName;
  }

  public BandIn channel(String channel) {
    this.channel = channel;
    return this;
  }

  /**
   * Get channel
   * @return channel
  */
  @NotNull 
  @Schema(name = "channel", example = "1900", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("channel")
  public String getChannel() {
    return channel;
  }

  public void setChannel(String channel) {
    this.channel = channel;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BandIn bandIn = (BandIn) o;
    return Objects.equals(this.name, bandIn.name) &&
        Objects.equals(this.subName, bandIn.subName) &&
        Objects.equals(this.channel, bandIn.channel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, subName, channel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BandIn {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    subName: ").append(toIndentedString(subName)).append("\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
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

