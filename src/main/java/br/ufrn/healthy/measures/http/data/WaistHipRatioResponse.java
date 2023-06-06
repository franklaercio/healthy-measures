package br.ufrn.healthy.measures.http.data;

import br.ufrn.healthy.measures.domain.WaistHipRatioLevel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WaistHipRatioResponse {

  @Schema(description = "Level can be Low Risk or High Risk", example = "LOW_RISK")
  @JsonProperty("level")
  private WaistHipRatioLevel waistHipRatioLevel;

  public WaistHipRatioResponse(WaistHipRatioLevel waistHipRatioLevel) {
    this.waistHipRatioLevel = waistHipRatioLevel;
  }

  public WaistHipRatioLevel getWaistHipRatioLevel() {
    return waistHipRatioLevel;
  }

  public void setWaistHipRatioLevel(WaistHipRatioLevel waistHipRatioLevel) {
    this.waistHipRatioLevel = waistHipRatioLevel;
  }
}
