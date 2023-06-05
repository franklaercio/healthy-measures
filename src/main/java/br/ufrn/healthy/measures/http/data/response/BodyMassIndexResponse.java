package br.ufrn.healthy.measures.http.data.response;

import br.ufrn.healthy.measures.domain.HealthyType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BodyMassIndexResponse {

  @Schema(description = "Healthy type", example = "NORMAL")
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
