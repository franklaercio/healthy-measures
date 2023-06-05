package br.ufrn.healthy.measures.http.data.request;

import br.ufrn.healthy.measures.domain.Gender;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BasalMetabolicRateRequest {

  @Schema(example = "MALE")
  @JsonProperty(value = "gender")
  private Gender gender;

  @Schema(example = "80.70")
  @JsonProperty(value = "weight")
  private double weight;

  @Schema(example = "1.80")
  @JsonProperty(value = "height")
  private double height;

  @Schema(example = "20")
  @JsonProperty(value = "age")
  private int age;

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

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
