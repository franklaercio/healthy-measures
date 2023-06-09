package br.ufrn.healthy.measures.http.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActiveLevelResponse {

  @Schema(description = "Calories calculated based on metabolism", example = "5000")
  private double calories;

  public ActiveLevelResponse(double calories) {
    this.calories = calories;
  }

  public double getCalories() {
    return calories;
  }

  public void setCalories(double calories) {
    this.calories = calories;
  }
}
