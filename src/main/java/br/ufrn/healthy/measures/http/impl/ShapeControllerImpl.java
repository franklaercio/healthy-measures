package br.ufrn.healthy.measures.http.impl;

import br.ufrn.healthy.measures.domain.Gender;
import br.ufrn.healthy.measures.domain.HealthyType;
import br.ufrn.healthy.measures.domain.WaistHipRatioLevel;
import br.ufrn.healthy.measures.http.ShapeController;
import br.ufrn.healthy.measures.http.data.BodyMassIndexResponse;
import br.ufrn.healthy.measures.http.data.FatRateResponse;
import br.ufrn.healthy.measures.http.data.LeanMassResponse;
import br.ufrn.healthy.measures.http.data.WaistHipRatioResponse;
import br.ufrn.healthy.measures.services.BodyMassIndexService;
import br.ufrn.healthy.measures.services.BodyMassService;
import br.ufrn.healthy.measures.services.WaistHipRatioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shape")
public class ShapeControllerImpl implements ShapeController {

  private final BodyMassIndexService bodyMassIndexService;

  private final WaistHipRatioService waistHipRatioService;

  private final BodyMassService bodyMassService;

  public ShapeControllerImpl(BodyMassIndexService bodyMassIndexService,
      WaistHipRatioService waistHipRatioService, BodyMassService bodyMassService) {
    this.bodyMassIndexService = bodyMassIndexService;
    this.waistHipRatioService = waistHipRatioService;
    this.bodyMassService = bodyMassService;
  }

  @Override
  @GetMapping("/bmi")
  public ResponseEntity<BodyMassIndexResponse> getBodyMassIndex(Double weight, Double height) {
    HealthyType healthyType = this.bodyMassIndexService.calculateBodyMassIndex(weight, height);
    return ResponseEntity.ok(new BodyMassIndexResponse(healthyType));
  }

  @Override
  @GetMapping("/waist-hip-ratio")
  public ResponseEntity<WaistHipRatioResponse> getWaistHipRatio(Gender gender, Double waist,
      Double hip) {
    WaistHipRatioLevel waistHipRatioLevel =
        this.waistHipRatioService.calculateWaistHipRatio(gender, waist, hip);
    return ResponseEntity.ok(new WaistHipRatioResponse(waistHipRatioLevel));
  }

  @Override
  @GetMapping("/fat-rate")
  public ResponseEntity<FatRateResponse> getFatRate(Gender gender, Double weight, Double height) {
    double fatRate = this.bodyMassService.calculateFatRate(gender, weight, height);
    return ResponseEntity.ok(new FatRateResponse(fatRate));
  }

  @Override
  @GetMapping("/lean-mass")
  public ResponseEntity<LeanMassResponse> getLeanMass(Gender gender, Double weight, Double height) {
    double leanMass = this.bodyMassService.calculateLeanMass(gender, weight, height);
    return ResponseEntity.ok(new LeanMassResponse(leanMass));
  }
}
