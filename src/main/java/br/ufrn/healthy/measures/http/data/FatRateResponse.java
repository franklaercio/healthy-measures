package br.ufrn.healthy.measures.http.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FatRateResponse {

  @Schema(description = "Fat rate in kilograms", example = "10.2")
  @JsonProperty("fat_rate")
  private double fatRate;

  public FatRateResponse(double fatRate) {
    this.fatRate = fatRate;
  }

  public double getFatRate() {
    return fatRate;
  }

  public void setFatRate(double fatRate) {
    this.fatRate = fatRate;
  }
}
