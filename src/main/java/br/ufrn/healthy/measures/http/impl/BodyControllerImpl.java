package br.ufrn.healthy.measures.http.impl;

import br.ufrn.healthy.measures.domain.ActiveLevel;
import br.ufrn.healthy.measures.domain.Gender;
import br.ufrn.healthy.measures.domain.HealthyType;
import br.ufrn.healthy.measures.domain.WaistHipRatioLevel;
import br.ufrn.healthy.measures.http.BodyController;
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
  public ResponseEntity<BodyMassIndexResponse> getBodyMassIndex(double weight, double height) {
    HealthyType healthyType = this.measuresService.calculateBodyMassIndex(weight, height);
    return ResponseEntity.ok(new BodyMassIndexResponse(healthyType));
  }

  @Override
  @GetMapping("/basal-metabolic-rate")
  public ResponseEntity<BasalMetabolicRateResponse> getBasalMetabolicRate(Gender gender,
      double weight, double height, int age) {
    double calories = this.measuresService.calculateBasalMetabolicRate(gender, weight, height, age);
    return ResponseEntity.ok(new BasalMetabolicRateResponse(calories));
  }

  @Override
  @GetMapping("/waist-hip-ratio")
  public ResponseEntity<WaistHipRatioResponse> getWaistHipRatio(Gender gender, double waist,
      double hip) {
    WaistHipRatioLevel waistHipRatioLevel =
        this.measuresService.calculateWaistHipRatio(gender, waist, hip);
    return ResponseEntity.ok(new WaistHipRatioResponse(waistHipRatioLevel));
  }

  @Override
  @GetMapping("/fat-rate")
  public ResponseEntity<FatRateResponse> getFatRate(Gender gender, double weight, double height) {
    double fatRate = this.measuresService.calculateFatRate(gender, weight, height);
    return ResponseEntity.ok(new FatRateResponse(fatRate));
  }

  @Override
  @GetMapping("/lean-mass")
  public ResponseEntity<LeanMassResponse> getLeanMass(Gender gender, double weight, double height) {
    double leanMass = this.measuresService.calculateLeanMass(gender, weight, height);
    return ResponseEntity.ok(new LeanMassResponse(leanMass));
  }

  @Override
  @GetMapping("/active-level")
  public ResponseEntity<ActiveLevelResponse> getActiveLevel(ActiveLevel activeLevel, Gender gender,
      double weight, double height, int age) {
    double calories = this.measuresService.calculateBoostActiveLevel(activeLevel, gender, weight,
        height, age);
    return ResponseEntity.ok(new ActiveLevelResponse(calories));
  }
}
