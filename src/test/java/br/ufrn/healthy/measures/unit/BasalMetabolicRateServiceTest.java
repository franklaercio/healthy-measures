package br.ufrn.healthy.measures.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import br.ufrn.healthy.measures.domain.Gender;
import br.ufrn.healthy.measures.exceptions.BadRequestException;
import br.ufrn.healthy.measures.services.BasalMetabolicRateService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DisplayName("Basal Metabolic Rate Service")
@ContextConfiguration(classes = BasalMetabolicRateService.class)
@ExtendWith(SpringExtension.class)
class BasalMetabolicRateServiceTest {

  @Autowired
  private BasalMetabolicRateService basalMetabolicRateService;

  @Test
  @DisplayName("Should calculate the basal metabolic rate when gender is male")
  void shouldCalculateBasalMetabolicRateWhenGenderIsMale() {
    assertEquals(1219.8754, this.basalMetabolicRateService
        .calculateBasalMetabolicRate(Gender.MALE, 96.0, 1.80, 26));
  }

  @Test
  @DisplayName("Should calculate the basal metabolic rate when gender is female")
  void shouldCalculateBasalMetabolicRateWhenGenderIsFemale() {
    assertEquals(1454.902, this.basalMetabolicRateService
        .calculateBasalMetabolicRate(Gender.FEMALE, 96.0, 1.80, 26));
  }

  @Test
  @DisplayName("Should throws bad request when gender is null")
  void shouldThrowsBadRequestWhenGenderIsNull() {
    assertThrows(BadRequestException.class, () -> this.basalMetabolicRateService
        .calculateBasalMetabolicRate(null, 96.0, 1.80, 26));
  }

  @Test
  @DisplayName("Should throws bad request when weight is invalid")
  void shouldThrowsBadRequestWhenWeightIsInvalid() {
    assertThrows(BadRequestException.class, () -> this.basalMetabolicRateService
        .calculateBasalMetabolicRate(Gender.FEMALE, -96.0, 1.80, 26));
  }

  @Test
  @DisplayName("Should throws bad request when height is invalid")
  void shouldThrowsBadRequestWhenHeightIsInvalid() {
    assertThrows(BadRequestException.class, () -> this.basalMetabolicRateService
        .calculateBasalMetabolicRate(Gender.FEMALE, 96.0, -1.80, 26));
  }

  @Test
  @DisplayName("Should throws bad request when age is invalid")
  void shouldThrowsBadRequestWhenAgeIsInvalid() {
    assertThrows(BadRequestException.class, () -> this.basalMetabolicRateService
        .calculateBasalMetabolicRate(Gender.FEMALE, 96.0, 1.80, -1));
  }

}
