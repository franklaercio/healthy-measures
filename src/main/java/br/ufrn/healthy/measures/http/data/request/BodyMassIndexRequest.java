package br.ufrn.healthy.measures.http.data.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BodyMassIndexRequest {

  @Schema(description = "Weight in kilograms", example = "70.0", required = true)
  private double weight;

  @Schema(description = "Height in meters", example = "1.75", required = true)
  private double height;

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height;
  }
}
