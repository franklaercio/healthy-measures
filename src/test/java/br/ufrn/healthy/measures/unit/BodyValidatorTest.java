package br.ufrn.healthy.measures.unit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import br.ufrn.healthy.measures.domain.ActiveLevel;
import br.ufrn.healthy.measures.domain.Gender;
import br.ufrn.healthy.measures.services.validators.BodyValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class BodyValidatorTest {

  @DisplayName("Should return true when gender is valid")
  @ParameterizedTest
  @EnumSource(value = Gender.class)
  void shouldReturnTrueWhenGenderIsValid(Gender gender) {
    assertTrue(BodyValidator.validateGender(gender));
  }

  @DisplayName("Should return false when gender is null")
  @Test
  void shouldReturnFalseWhenGenderIsNull() {
    assertFalse(BodyValidator.validateGender(null));
  }

  @DisplayName("Should return true when active level is valid")
  @ParameterizedTest
  @EnumSource(value = ActiveLevel.class)
  void shouldReturnTrueWhenActiveLevelIsValid(ActiveLevel activeLevel) {
    assertTrue(BodyValidator.validateActiveLevel(activeLevel));
  }

  @DisplayName("Should return false when active level is null")
  @Test
  void shouldReturnFalseWhenActiveLevelIsNull() {
    assertFalse(BodyValidator.validateActiveLevel(null));
  }

  @DisplayName("Should return true when height is valid")
  @ParameterizedTest
  @ValueSource(doubles = {0.0, 1.0, 1.5, 2.0, 3.9})
  void shouldReturnTrueWhenHeightIsValid(double height) {
    assertTrue(BodyValidator.validateHeight(height));
  }

  @DisplayName("Should return false when height is invalid")
  @ParameterizedTest
  @ValueSource(doubles = {-1.0, -0.1, -0.0001, 4.0, 4.1, 5.0, -(Double.MIN_VALUE), Double.MAX_VALUE})
  void shouldReturnFalseWhenHeightIsInvalid(double height) {
    assertFalse(BodyValidator.validateHeight(height));
  }

  @DisplayName("Should return true when weight is valid")
  @ParameterizedTest
  @ValueSource(doubles = {0.0, 1.0, 1.5, 2.0, 3.9, Double.MAX_VALUE})
  void shouldReturnTrueWhenWeightIsValid(double weight) {
    assertTrue(BodyValidator.validateWeight(weight));
  }

  @DisplayName("Should return false when weight is invalid")
  @ParameterizedTest
  @ValueSource(doubles = {-1.0, -0.1, -0.0001, -(Double.MIN_VALUE)})
  void shouldReturnFalseWhenWeightIsInvalid(double weight) {
    assertFalse(BodyValidator.validateWeight(weight));
  }

  @DisplayName("Should return true when age is valid")
  @ParameterizedTest
  @ValueSource(ints = {0, 1, 100, 1000, Integer.MAX_VALUE})
  void shouldReturnTrueWhenAgeIsValid(int age) {
    assertTrue(BodyValidator.validateAge(age));
  }

  @DisplayName("Should return false when age is invalid")
  @ParameterizedTest
  @ValueSource(ints = {-1, -100, -1000, Integer.MIN_VALUE})
  void shouldReturnFalseWhenAgeIsInvalid(int age) {
    assertFalse(BodyValidator.validateAge(age));
  }

  @DisplayName("Should return true when waist is valid")
  @ParameterizedTest
  @ValueSource(doubles = {0.0, 1.0, 1.5, 2.0, 3.9, Double.MAX_VALUE})
  void shouldReturnTrueWhenWaistIsValid(double waist) {
    assertTrue(BodyValidator.validateWaist(waist));
  }

  @DisplayName("Should return false when waist is invalid")
  @ParameterizedTest
  @ValueSource(doubles = {-1.0, -0.1, -0.0001, -(Double.MIN_VALUE)})
  void shouldReturnFalseWhenWaistIsInvalid(double waist) {
    assertFalse(BodyValidator.validateWaist(waist));
  }

  @DisplayName("Should return true when hip is valid")
  @ParameterizedTest
  @ValueSource(doubles = {0.0, 1.0, 1.5, 2.0, 3.9, Double.MAX_VALUE})
  void shouldReturnTrueWhenHipIsValid(double hip) {
    assertTrue(BodyValidator.validateHip(hip));
  }

  @DisplayName("Should return false when hip is invalid")
  @ParameterizedTest
  @ValueSource(doubles = {-1.0, -0.1, -0.0001, -(Double.MIN_VALUE)})
  void shouldReturnFalseWhenHipIsInvalid(double hip) {
    assertFalse(BodyValidator.validateHip(hip));
  }
}
