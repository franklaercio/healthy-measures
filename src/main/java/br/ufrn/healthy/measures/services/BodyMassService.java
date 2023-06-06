package br.ufrn.healthy.measures.services;

import br.ufrn.healthy.measures.domain.Gender;
import br.ufrn.healthy.measures.exceptions.BadRequestException;
import br.ufrn.healthy.measures.services.validators.BodyValidator;
import org.springframework.stereotype.Service;

@Service
public class BodyMassService {

  public double calculateFatRate(Gender gender, double weight, double height) {
    if (!BodyValidator.validateGender(gender) || !BodyValidator.validateWeight(weight)
        || !BodyValidator.validateHeight(height)) {
      throw new BadRequestException("Invalid parameters, verify the values and try again.");
    }

    return weight - calculateLeanMass(gender, weight, height);
  }

  public double calculateLeanMass(Gender gender, double weight, double height) {
    if (!BodyValidator.validateGender(gender) || !BodyValidator.validateWeight(weight)
        || !BodyValidator.validateHeight(height)) {
      throw new BadRequestException("Invalid parameters, verify the values and try again.");
    }

    if (gender.equals(Gender.MALE)) {
      return (0.32810 * weight) + (0.33929 * height) - 29.5336;
    } else {
      return (0.29569 * weight) + (0.41813 * height) - 43.2933;
    }
  }

}
