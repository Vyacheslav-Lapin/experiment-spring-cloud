package ru.vlapin.experiments.experimentspringcloud.model.jsonplaceholder;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@Builder(toBuilder = true)
public class Geo {

  @JsonProperty("lat")
  Double latitude;

  @JsonProperty("lng")
  Double longitude;
}
