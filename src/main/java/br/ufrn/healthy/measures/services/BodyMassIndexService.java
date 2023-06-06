package br.ufrn.healthy.measures.services;

import br.ufrn.healthy.measures.domain.HealthyType;
import br.ufrn.healthy.measures.exceptions.BadRequestException;
import br.ufrn.healthy.measures.services.validators.BodyValidator;
import org.springframework.stereotype.Service;

@Service
public class BodyMassIndexService {

  public HealthyType calculateBodyMassIndex(double weight, double height) {
    if(!BodyValidator.validateWeight(weight) || !BodyValidator.validateHeight(height)) {
      throw new BadRequestException("Invalid parameters, verify the values and try again.");
    }

    double bodyMassIndex = weight / (height * height);

    return checkHealthyType(bodyMassIndex);
  }

  private HealthyType checkHealthyType(double bodyMassIndex) {
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
}
