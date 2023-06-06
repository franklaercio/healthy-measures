package br.ufrn.healthy.measures.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import br.ufrn.healthy.measures.domain.Gender;
import br.ufrn.healthy.measures.domain.WaistHipRatioLevel;
import br.ufrn.healthy.measures.exceptions.BadRequestException;
import br.ufrn.healthy.measures.exceptions.NotFoundException;
import br.ufrn.healthy.measures.services.WaistHipRatioService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DisplayName("Waist Hip Ratio Service")
@ContextConfiguration(classes = {WaistHipRatioService.class})
@ExtendWith(SpringExtension.class)
public class WaistHipRatioServiceTest {

  @Autowired
  private WaistHipRatioService waistHipRatioService;

  @Test
  @DisplayName("Should calculate waist hip ratio when gender is male and waist is 80 and hip is 100")
  void shouldCalculateWaistHipRatioWhenGenderIsMale() {
    assertEquals(WaistHipRatioLevel.LOW_RISK,
        this.waistHipRatioService.calculateWaistHipRatio(Gender.MALE, 80, 100));
  }

  @Test
  @DisplayName("Should calculate waist hip ratio when gender is female and waist is 80 and hip is 100")
  void shouldCalculateWaistHipRatioWhenGenderIsFemale() {
    assertEquals(WaistHipRatioLevel.HIGH_RISK,
        this.waistHipRatioService.calculateWaistHipRatio(Gender.FEMALE, 80, 80));
  }

  @Test
  @DisplayName("Should throws waist hip ratio when gender is null")
  void shouldThrowsWaistHipRatioWhenGenderIsNull() {
    assertThrows(NotFoundException.class, () ->
        this.waistHipRatioService.calculateRiskLevelByGender(null, 80, 80));
  }

  @Test
  @DisplayName("Should throw bad request when gender is invalid")
  void shouldThrowBadRequestWhenGenderIsInvalid() {
    assertThrows(BadRequestException.class, () ->
        this.waistHipRatioService.calculateWaistHipRatio(null, 80, 100));
  }

  @Test
  @DisplayName("Should throw bad request when waist is invalid")
  void shouldThrowBadRequestWhenWaistIsInvalid() {
    assertThrows(BadRequestException.class, () ->
        this.waistHipRatioService.calculateWaistHipRatio(Gender.FEMALE, -80, 100));
  }

  @Test
  @DisplayName("Should throw bad request when hip is invalid")
  void shouldThrowBadRequestWhenHipIsInvalid() {
    assertThrows(BadRequestException.class, () ->
        this.waistHipRatioService.calculateWaistHipRatio(Gender.FEMALE, 80, -100));
  }

}
