package br.ufrn.healthy.measures.services;

import br.ufrn.healthy.measures.domain.Gender;
import br.ufrn.healthy.measures.exceptions.BadRequestException;
import br.ufrn.healthy.measures.services.validators.BodyValidator;
import org.springframework.stereotype.Service;

@Service
public class BasalMetabolicRateService {

  public double calculateBasalMetabolicRate(Gender gender, double weight, double height, int age) {
    if (!BodyValidator.validateGender(gender) || !BodyValidator.validateWeight(weight)
        || !BodyValidator.validateHeight(height) || !BodyValidator.validateAge(age)) {
      throw new BadRequestException("Invalid parameters, verify the values and try again.");
    }

    if (gender.equals(Gender.MALE)) {
      return 66.5 + (13.75 * weight) + (5.003 * height) - (6.755 * age);
    } else {
      return 655.1 + (9.563 * weight) + (1.850 * height) - (4.676 * age);
    }
  }
}
