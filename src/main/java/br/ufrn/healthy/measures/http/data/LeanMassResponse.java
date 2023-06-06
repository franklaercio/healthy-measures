package br.ufrn.healthy.measures.http.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeanMassResponse {

  @Schema(description = "Lean mass in kilograms", example = "70.0")
  @JsonProperty("lean_mass")
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
