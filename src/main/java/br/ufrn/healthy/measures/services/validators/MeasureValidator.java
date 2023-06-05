package br.ufrn.healthy.measures.services.validators;

import br.ufrn.healthy.measures.domain.ActiveLevel;
import br.ufrn.healthy.measures.domain.Gender;
import br.ufrn.healthy.measures.exceptions.BadRequestException;

public class MeasureValidator {

  private MeasureValidator() {
    // private class cannot be instantiated
  }

  public static void validateBasalMetabolicRate(Gender gender, double weight, double height,
      int age) {
    validateGender(gender);
    validateWeight(weight);
    validateHeight(height);
    validateAge(age);
  }

  public static void validateBodyMassIndex(double weight, double height) {
    validateWeight(weight);
    validateHeight(height);
  }

  public static void validateBoostActiveLevel(ActiveLevel activeLevel, Gender gender,
      double weight, double height, int age) {
    validateActiveLevel(activeLevel);
    validateGender(gender);
    validateWeight(weight);
    validateHeight(height);
    validateAge(age);
  }

  public static void validateFatRate(Gender gender, double weight, double height) {
    validateGender(gender);
    validateWeight(weight);
    validateHeight(height);
  }

  public static void validateLeanMass(Gender gender, double weight, double height) {
    validateGender(gender);
    validateWeight(weight);
    validateHeight(height);
  }

  public static void validateWaistHipRatio(Gender gender, double waist, double hip) {
    validateGender(gender);
    validateWaist(waist);
    validateHip(hip);
  }

  private static void validateGender(Gender gender) {
    if(gender == null || !Gender.contains(gender)) {
      throw new BadRequestException("Gender is invalid, verify the value informed.");
    }
  }

  private static void validateActiveLevel(ActiveLevel activeLevel) {
    if(activeLevel == null || !ActiveLevel.contains(activeLevel)) {
      throw new BadRequestException("Active level is invalid, verify the value informed.");
    }
  }

  private static void validateHeight(Double height) {
    if(height == null || height <= 0) {
      throw new BadRequestException("Height is invalid, verify the value informed.");
    }
  }

  private static void validateWeight(Double weight) {
    if(weight == null || weight <= 0) {
      throw new BadRequestException("Weight is invalid, verify the value informed.");
    }
  }

  private static void validateAge(Integer age) {
    if(age == null || age <= 0) {
      throw new BadRequestException("Age is invalid, verify the value informed.");
    }
  }

  private static void validateWaist(Double waist) {
    if(waist == null || waist <= 0) {
      throw new BadRequestException("Waist is invalid, verify the value informed.");
    }
  }

  private static void validateHip(Double hip) {
    if(hip == null || hip <= 0) {
      throw new BadRequestException("Hip is invalid, verify the value informed.");
    }
  }
}
