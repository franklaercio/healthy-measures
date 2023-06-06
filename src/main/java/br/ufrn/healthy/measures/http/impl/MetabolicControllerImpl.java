package br.ufrn.healthy.measures.http.impl;

import br.ufrn.healthy.measures.domain.ActiveLevel;
import br.ufrn.healthy.measures.domain.Gender;
import br.ufrn.healthy.measures.http.MetabolicController;
import br.ufrn.healthy.measures.http.data.ActiveLevelResponse;
import br.ufrn.healthy.measures.http.data.BasalMetabolicRateResponse;
import br.ufrn.healthy.measures.services.BasalMetabolicRateService;
import br.ufrn.healthy.measures.services.BoostActiveLevelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metabolic")
public class MetabolicControllerImpl implements MetabolicController {

  private final BasalMetabolicRateService basalMetabolicRateService;

  private final BoostActiveLevelService boostActiveLevelService;

  public MetabolicControllerImpl(BasalMetabolicRateService basalMetabolicRateService,
      BoostActiveLevelService boostActiveLevelService) {
    this.basalMetabolicRateService = basalMetabolicRateService;
    this.boostActiveLevelService = boostActiveLevelService;
  }

  @Override
  @GetMapping("/bmr")
  public ResponseEntity<BasalMetabolicRateResponse> getBasalMetabolicRate(Gender gender,
      Double weight, Double height, Integer age) {
    double calories = this.basalMetabolicRateService.calculateBasalMetabolicRate(gender, weight,
        height, age);
    return ResponseEntity.ok(new BasalMetabolicRateResponse(calories));
  }

  @Override
  @GetMapping("/active-level")
  public ResponseEntity<ActiveLevelResponse> getActiveLevel(ActiveLevel activeLevel, Gender gender,
      Double weight, Double height, Integer age) {
    double calories = this.boostActiveLevelService.calculateBoostActiveLevel(activeLevel, gender,
        weight, height, age);
    return ResponseEntity.ok(new ActiveLevelResponse(calories));
  }
}
