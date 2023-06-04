package br.ufrn.healthy.measures.useif

import br.ufrn.healthy.measures.entities.ActiveLevel;
import br.ufrn.healthy.measures.entities.Gender;
import br.ufrn.healthy.measures.entities.HealthyType;
import br.ufrn.healthy.measures.entities.WaistHipRatioLevel;
import br.ufrn.healthy.measures.http.exceptions.BadRequestException;
import org.springframework.stereotype.Service;

@Service
public class BodyUseCase {

  public HealthyType calculateBodyMassIndex(double weight, double height) {
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

  public double calculateBasalMetabolicRate(Gender gender, double weight, double height, int age) {
    switch (gender) {
      case MALE:
        return 66.5 + (13.75 * weight) + (5.003 * height) - (6.755 * age);
      case FEMALE:
        return 655.1 + (9.563 * weight) + (1.850 * height) - (4.676 * age);
      default:
        throw new BadRequestException("Verify your data and try again.");
    }
  }

  public WaistHipRatioLevel calculateWaistHipRatio(Gender gender, double waist, double hip) {
    double waistHipRatio = waist / hip;

    switch (gender) {
      case MALE:
        if (waistHipRatio < 0.9) {
          return WaistHipRatioLevel.LOW_RISK;
        } else {
          return WaistHipRatioLevel.HIGH_RISK;
        }
      case FEMALE:
        if (waistHipRatio < 0.85) {
          return WaistHipRatioLevel.LOW_RISK;
        } else {
          return WaistHipRatioLevel.HIGH_RISK;
        }
      default:
        throw new BadRequestException("Verify your data and try again.");
    }
  }

  public void calculateFatRate(Gender gender, double weight, double height,
      int age, double waist, double hip) {

  }

  public void calculateLeanMass(double weight) {

  }

  public void calculateActiveLevel(ActiveLevel activeLevel) {

  }

}
