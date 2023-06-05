package br.ufrn.healthy.measures.http.data.response;

import br.ufrn.healthy.measures.domain.WaistHipRatioLevel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WaistHipRatioResponse {

  @Schema(description = "Level", example = "NORMAL")
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
