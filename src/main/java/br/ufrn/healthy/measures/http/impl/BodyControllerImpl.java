package br.ufrn.healthy.measures.http.impl;

import br.ufrn.healthy.measures.domain.HealthyType;
import br.ufrn.healthy.measures.domain.WaistHipRatioLevel;
import br.ufrn.healthy.measures.http.BodyController;
import br.ufrn.healthy.measures.http.data.request.ActiveLevelRequest;
import br.ufrn.healthy.measures.http.data.request.BasalMetabolicRateRequest;
import br.ufrn.healthy.measures.http.data.request.BodyMassIndexRequest;
import br.ufrn.healthy.measures.http.data.request.FatRateRequest;
import br.ufrn.healthy.measures.http.data.request.LeanMassRequest;
import br.ufrn.healthy.measures.http.data.request.WaistHipRatioRequest;
import br.ufrn.healthy.measures.http.data.response.ActiveLevelResponse;
import br.ufrn.healthy.measures.http.data.response.BasalMetabolicRateResponse;
import br.ufrn.healthy.measures.http.data.response.BodyMassIndexResponse;
import br.ufrn.healthy.measures.http.data.response.FatRateResponse;
import br.ufrn.healthy.measures.http.data.response.LeanMassResponse;
import br.ufrn.healthy.measures.http.data.response.WaistHipRatioResponse;
import br.ufrn.healthy.measures.services.MeasuresService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/body")
public class BodyControllerImpl implements BodyController {

  private final MeasuresService measuresService;

  public BodyControllerImpl(MeasuresService measuresService) {
    this.measuresService = measuresService;
  }

  @Override
  @GetMapping("/body-mass-index")
  public ResponseEntity<BodyMassIndexResponse> getBodyMassIndex(
      BodyMassIndexRequest bodyMassIndexRequest) {
    HealthyType healthyType = this.measuresService.calculateBodyMassIndex(
        bodyMassIndexRequest.getWeight(),
        bodyMassIndexRequest.getHeight());
    return ResponseEntity.ok(new BodyMassIndexResponse(healthyType));
  }

  @Override
  @GetMapping("basal-metabolic-rate")
  public ResponseEntity<BasalMetabolicRateResponse> getBasalMetabolicRate(
      BasalMetabolicRateRequest basalMetabolicRateRequest) {
    double calories = this.measuresService.calculateBasalMetabolicRate(
        basalMetabolicRateRequest.getGender(),
        basalMetabolicRateRequest.getWeight(), basalMetabolicRateRequest.getHeight(),
        basalMetabolicRateRequest.getAge());
    return ResponseEntity.ok(new BasalMetabolicRateResponse(calories));
  }

  @Override
  @GetMapping("waist-hip-ratio")
  public ResponseEntity<WaistHipRatioResponse> getWaistHipRatio(
      WaistHipRatioRequest waistHipRatioRequest) {
    WaistHipRatioLevel waistHipRatioLevel = this.measuresService.calculateWaistHipRatio(
        waistHipRatioRequest.getGender(),
        waistHipRatioRequest.getWaist(), waistHipRatioRequest.getHip());
    return ResponseEntity.ok(new WaistHipRatioResponse(waistHipRatioLevel));
  }

  @Override
  @GetMapping("fat-rate")
  public ResponseEntity<FatRateResponse> getFatRate(FatRateRequest fatRateRequest) {
    double fatRate = this.measuresService.calculateFatRate(fatRateRequest.getGender(),
        fatRateRequest.getWeight(), fatRateRequest.getHeight());
    return ResponseEntity.ok(new FatRateResponse(fatRate));
  }

  @Override
  @GetMapping("lean-mass")
  public ResponseEntity<LeanMassResponse> getLeanMass(LeanMassRequest leanMassRequest) {
    double leanMass = this.measuresService.calculateLeanMass(leanMassRequest.getGender(),
        leanMassRequest.getWeight(), leanMassRequest.getHeight());
    return ResponseEntity.ok(new LeanMassResponse(leanMass));
  }

  @Override
  @GetMapping("active-level")
  public ResponseEntity<ActiveLevelResponse> getActiveLevel(ActiveLevelRequest activeLevelRequest) {
    double calories = this.measuresService.calculateBoostActiveLevel(
        activeLevelRequest.getActiveLevel(),
        activeLevelRequest.getGender(), activeLevelRequest.getWeight(),
        activeLevelRequest.getHeight(), activeLevelRequest.getAge());
    return ResponseEntity.ok(new ActiveLevelResponse(calories));
  }
}
