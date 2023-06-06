package br.ufrn.healthy.measures.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import br.ufrn.healthy.measures.domain.Gender;
import br.ufrn.healthy.measures.exceptions.BadRequestException;
import br.ufrn.healthy.measures.services.BodyMassService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DisplayName("Body Mass Service")
@ContextConfiguration(classes = {BodyMassService.class})
@ExtendWith(SpringExtension.class)
public class BodyMassServiceTest {

  @Autowired
  private BodyMassService bodyMassService;

  @Test
  @DisplayName("Should calculate fat rate")
  void shouldCalculateFatRate() {
    assertEquals(83.380707, bodyMassService.calculateFatRate(Gender.MALE, 81, 1.70));
  }

  @Test
  @DisplayName("Should calculate lean mass")
  void shouldCalculateLeanMass() {
    assertEquals(-18.631589, bodyMassService.calculateLeanMass(Gender.FEMALE, 81, 1.70));
  }

  @Test
  @DisplayName("Should throws bad request when gender is null in fat rate")
  void shouldThrowsBadRequestWhenGenderIsNullInFatRate() {
    assertThrows(BadRequestException.class, () ->
        bodyMassService.calculateFatRate(null, 81, 1.70));
  }

  @Test
  @DisplayName("Should throws bad request when gender is null in lean mass")
  void shouldThrowsBadRequestWhenGenderIsNullInLeanMass() {
    assertThrows(BadRequestException.class, () ->
        bodyMassService.calculateLeanMass(null, 81, 1.70));
  }

  @Test
  @DisplayName("Should throws bad request when weight is invalid in fat rate")
  void shouldThrowsBadRequestWhenWeightIsInvalidInFatRate() {
    assertThrows(BadRequestException.class, () ->
        bodyMassService.calculateFatRate(Gender.MALE, -81, 1.70));
  }

  @Test
  @DisplayName("Should throws bad request when weight is invalid in lean mass")
  void shouldThrowsBadRequestWhenWeightIsInvalidInLeanMass() {
    assertThrows(BadRequestException.class, () ->
        bodyMassService.calculateLeanMass(Gender.MALE, -81, 1.70));
  }

  @Test
  @DisplayName("Should throws bad request when height is invalid in fat rate")
  void shouldThrowsBadRequestWhenHeightIsInvalidInFatRate() {
    assertThrows(BadRequestException.class, () ->
        bodyMassService.calculateFatRate(Gender.MALE, 81, -1.70));
  }

  @Test
  @DisplayName("Should throws bad request when height is invalid in lean mass")
  void shouldThrowsBadRequestWhenHeightIsInvalidInLeanMass() {
    assertThrows(BadRequestException.class, () ->
        bodyMassService.calculateLeanMass(Gender.MALE, 81, -1.70));
  }

}
