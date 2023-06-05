package br.ufrn.healthy.measures.http.data.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeanMassResponse {

  @Schema(description = "Lean mass", example = "70.0")
  private double leanMass;

  public LeanMassResponse(double leanMass) {
    this.leanMass = leanMass;
  }

  public double getLeanMass() {
    return leanMass;
  }

  public void setLeanMass(double leanMass) {
    this.leanMass = leanMass;
  }
}
