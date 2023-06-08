package br.ufrn.healthy.measures.services;

import br.ufrn.healthy.measures.domain.Gender;
import br.ufrn.healthy.measures.domain.WaistHipRatioLevel;
import br.ufrn.healthy.measures.exceptions.BadRequestException;
import br.ufrn.healthy.measures.exceptions.NotFoundException;
import br.ufrn.healthy.measures.services.validators.BodyValidator;
import org.springframework.stereotype.Service;

@Service
public class WaistHipRatioService {

  private static final double RISK_LEVEL_MALE = 0.9;
  private static final double RISK_LEVEL_FEMALE = 0.85;

  public WaistHipRatioLevel calculateWaistHipRatio(Gender gender, double waist, double hip) {
    if (!BodyValidator.validateGender(gender) || !BodyValidator.validateWaist(waist)
        || !BodyValidator.validateHip(hip)) {
      throw new BadRequestException("Invalid parameters, verify the values and try again.");
    }

    return calculateRiskLevelByGender(gender, waist, hip);
  }

  public WaistHipRatioLevel calculateRiskLevelByGender(Gender gender, double waist, double hip) {
    if (Gender.exists(gender) && gender.equals(Gender.MALE)) {
      return calculateRiskLevel(waist, hip, RISK_LEVEL_MALE);
    } else if (Gender.exists(gender) && gender.equals(Gender.FEMALE)) {
      return calculateRiskLevel(waist, hip, RISK_LEVEL_FEMALE);
    } else {
      throw new NotFoundException("Cannot evaluate the risk level.");
    }
  }

  private WaistHipRatioLevel calculateRiskLevel(double waist, double hip, double riskLevel) {
    return waist / hip <= riskLevel ? WaistHipRatioLevel.LOW_RISK : WaistHipRatioLevel.HIGH_RISK;
  }
}
