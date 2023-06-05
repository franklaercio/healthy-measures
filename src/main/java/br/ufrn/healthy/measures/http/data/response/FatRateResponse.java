package br.ufrn.healthy.measures.http.data.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FatRateResponse {

  @Schema(description = "Fat rate", example = "0.2")
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
