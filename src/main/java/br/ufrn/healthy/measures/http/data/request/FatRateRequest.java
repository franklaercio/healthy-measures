package br.ufrn.healthy.measures.http.data.request;

import br.ufrn.healthy.measures.domain.Gender;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FatRateRequest {

  @Schema(example = "MALE")
  @JsonProperty("gender")
  private Gender gender;

  @Schema(example = "20.0")
  @JsonProperty("weight")
  private double weight;

  @Schema(example = "1.50")
  @JsonProperty("height")
  private double height;

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

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
