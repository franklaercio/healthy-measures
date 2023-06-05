package br.ufrn.healthy.measures.services;

import br.ufrn.healthy.measures.domain.ActiveLevel;
import br.ufrn.healthy.measures.domain.Gender;
import br.ufrn.healthy.measures.domain.HealthyType;
import br.ufrn.healthy.measures.domain.WaistHipRatioLevel;
import br.ufrn.healthy.measures.services.validators.MeasureValidator;
import org.springframework.stereotype.Service;

@Service
public class MeasuresService {

  public double calculateBasalMetabolicRate(Gender gender, double weight, double height,
      int age) {
    MeasureValidator.validateBasalMetabolicRate(gender, weight, height, age);
    return switch (gender) {
      case MALE -> 66.5 + (13.75 * weight) + (5.003 * height) - (6.755 * age);
      case FEMALE -> 655.1 + (9.563 * weight) + (1.850 * height) - (4.676 * age);
    };
  }

  public HealthyType calculateBodyMassIndex(double weight, double height) {
    MeasureValidator.validateBodyMassIndex(weight, height);
    double bodyMassIndex = weight / (height * height);

    if (bodyMassIndex < 16) {
      return HealthyType.VERY_UNDERWEIGHT;
    } else if (bodyMassIndex < 18.5) {
      return HealthyType.UNDERWEIGHT;
    } else if (bodyMassIndex >= 18.5 && bodyMassIndex < 25) {
      return HealthyType.NORMAL;
    } else if (bodyMassIndex >= 25 && bodyMassIndex < 30) {
      return HealthyType.OVERWEIGHT;
    } else if (bodyMassIndex >= 30 && bodyMassIndex < 35) {
      return HealthyType.OBESE_CLASS_I;
    } else if (bodyMassIndex >= 35 && bodyMassIndex < 40) {
      return HealthyType.OBESE_CLASS_II;
    } else {
      return HealthyType.OBESE_CLASS_III;
    }
  }

  public double calculateBoostActiveLevel(ActiveLevel activeLevel, Gender gender,
      double weight, double height, int age) {
    MeasureValidator.validateBoostActiveLevel(activeLevel, gender, weight, height, age);
    return switch (activeLevel) {
      case SEDENTARY -> calculateBasalMetabolicRate(gender, weight, height, age) * 1.2;
      case LIGHTLY_ACTIVE -> calculateBasalMetabolicRate(gender, weight, height, age) * 1.375;
      case MODERATELY_ACTIVE -> calculateBasalMetabolicRate(gender, weight, height, age) * 1.55;
      case VERY_ACTIVE -> calculateBasalMetabolicRate(gender, weight, height, age) * 1.725;
      case EXTRA_ACTIVE -> calculateBasalMetabolicRate(gender, weight, height, age) * 1.9;
    };
  }

  public double calculateFatRate(Gender gender, double weight, double height) {
    MeasureValidator.validateFatRate(gender, weight, height);
    return weight - calculateLeanMass(gender, weight, height);
  }

  public double calculateLeanMass(Gender gender, double weight, double height) {
    MeasureValidator.validateLeanMass(gender, weight, height);
    return switch (gender) {
      case MALE -> (0.32810 * weight) + (0.33929 * height) - 29.5336;
      case FEMALE -> (0.29569 * weight) + (0.41813 * height) - 43.2933;
    };
  }

  public WaistHipRatioLevel calculateWaistHipRatio(Gender gender, double waist, double hip) {
    MeasureValidator.validateWaistHipRatio(gender, waist, hip);
    return switch (gender) {
      case MALE -> calculateRiskLevel(waist, hip, 0.9);
      case FEMALE -> calculateRiskLevel(waist, hip, 0.85);
    };
  }

  private WaistHipRatioLevel calculateRiskLevel(double waist, double hip, double riskLevel) {
    double waistHipRatio = waist / hip;

    if (waistHipRatio < riskLevel) {
      return WaistHipRatioLevel.LOW_RISK;
    } else {
      return WaistHipRatioLevel.HIGH_RISK;
    }
  }
}
