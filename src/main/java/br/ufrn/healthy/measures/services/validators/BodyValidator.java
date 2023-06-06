package br.ufrn.healthy.measures.services.validators;

import br.ufrn.healthy.measures.domain.ActiveLevel;
import br.ufrn.healthy.measures.domain.Gender;

public class BodyValidator {

  private BodyValidator() {
    // private class cannot be instantiated
  }

  public static boolean validateGender(Gender gender) {
    return Gender.exists(gender);
  }

  public static boolean validateActiveLevel(ActiveLevel activeLevel) {
    return ActiveLevel.exist(activeLevel);
  }

  public static boolean validateHeight(double height) {
    return height >= 0 && height < 4;
  }

  public static boolean validateWeight(double weight) {
    return weight >= 0;
  }

  public static boolean validateAge(int age) {
    return age >= 0;
  }

  public static boolean validateWaist(double waist) {
    return waist >= 0;
  }

  public static boolean validateHip(double hip) {
    return hip >= 0;
  }
}
