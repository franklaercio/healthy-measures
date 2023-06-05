package br.ufrn.healthy.measures.http.data.request;

import br.ufrn.healthy.measures.domain.ActiveLevel;
import br.ufrn.healthy.measures.domain.Gender;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActiveLevelRequest {

  @Schema(example = "SEDENTARY")
  @JsonProperty("active_level")
  private ActiveLevel activeLevel;

  @Schema(example = "MALE")
  @JsonProperty("gender")
  private Gender gender;

  @Schema(example = "70.80")
  @JsonProperty("weight")
  private double weight;

  @Schema(example = "1.80")
  @JsonProperty("height")
  private double height;

  @Schema(example = "20")
  @JsonProperty("age")
  private int age;

  public ActiveLevel getActiveLevel() {
    return activeLevel;
  }

  public void setActiveLevel(ActiveLevel activeLevel) {
    this.activeLevel = activeLevel;
  }

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
