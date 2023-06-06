package br.ufrn.healthy.measures.services;

import br.ufrn.healthy.measures.domain.ActiveLevel;
import br.ufrn.healthy.measures.domain.Gender;
import br.ufrn.healthy.measures.exceptions.BadRequestException;
import br.ufrn.healthy.measures.services.validators.BodyValidator;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class BoostActiveLevelService {

  private final BasalMetabolicRateService basalMetabolicRateService;

  public BoostActiveLevelService(BasalMetabolicRateService basalMetabolicRateService) {
    this.basalMetabolicRateService = basalMetabolicRateService;
  }

  public double calculateBoostActiveLevel(ActiveLevel activeLevel, Gender gender, double weight,
      double height, int age) {
    if (!BodyValidator.validateActiveLevel(activeLevel) || !BodyValidator.validateGender(gender)
        || !BodyValidator.validateWeight(weight) || !BodyValidator.validateHeight(height)
        || !BodyValidator.validateAge(age)) {
      throw new BadRequestException("Invalid parameters, verify the values and try again.");
    }

    double bmr = basalMetabolicRateService.calculateBasalMetabolicRate(gender, weight, height, age);

    return calculateCaloriesByActiveLevelAndBmr(activeLevel, bmr);
  }

  public double calculateCaloriesByActiveLevelAndBmr(ActiveLevel activeLevel, double bmr) {
    return switch (activeLevel) {
      case SEDENTARY -> bmr * 1.2;
      case LIGHTLY_ACTIVE -> bmr * 1.375;
      case MODERATELY_ACTIVE -> bmr * 1.55;
      case VERY_ACTIVE -> bmr * 1.725;
      case EXTRA_ACTIVE -> bmr * 1.9;
    };
  }
}
