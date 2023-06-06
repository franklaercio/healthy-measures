package br.ufrn.healthy.measures.http.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BasalMetabolicRateResponse {

  @JsonProperty("calories")
  @Schema(description = "Calories calculate in cal", example = "2000")
  private double calories;

  public BasalMetabolicRateResponse(double calories) {
    this.calories = calories;
  }

  public double getCalories() {
    return calories;
  }

  public void setCalories(double calories) {
    this.calories = calories;
  }
}
