package br.ufrn.healthy.measures.http.data;

import br.ufrn.healthy.measures.domain.HealthyType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BodyMassIndexResponse {

  @JsonProperty("healthy_type")
  @Schema(description = "Healthy type calculate by weight and height", example = "NORMAL")
  private HealthyType healthyType;

  public BodyMassIndexResponse(HealthyType healthyType) {
    this.healthyType = healthyType;
  }

  public HealthyType getHealthyType() {
    return healthyType;
  }

  public void setHealthyType(HealthyType healthyType) {
    this.healthyType = healthyType;
  }
}
