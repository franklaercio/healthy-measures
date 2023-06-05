package br.ufrn.healthy.measures.http.data.request;

import br.ufrn.healthy.measures.domain.Gender;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WaistHipRatioRequest {

  @Schema(example = "MALE")
  @JsonProperty("gender")
  private Gender gender;

  @Schema(example = "12.0")
  @JsonProperty("waist")
  private double waist;

  @Schema(example = "2.0")
  @JsonProperty("hip")
  private double hip;

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public double getWaist() {
    return waist;
  }

  public void setWaist(double waist) {
    this.waist = waist;
  }

  public double getHip() {
    return hip;
  }

  public void setHip(double hip) {
    this.hip = hip;
  }
}
