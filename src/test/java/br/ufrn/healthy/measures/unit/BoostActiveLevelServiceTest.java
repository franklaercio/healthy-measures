package br.ufrn.healthy.measures.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.ufrn.healthy.measures.domain.ActiveLevel;
import br.ufrn.healthy.measures.domain.Gender;
import br.ufrn.healthy.measures.exceptions.BadRequestException;
import br.ufrn.healthy.measures.services.BasalMetabolicRateService;
import br.ufrn.healthy.measures.services.BoostActiveLevelService;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DisplayName("Boost Active Level Service")
@ContextConfiguration(classes = {BoostActiveLevelService.class})
@ExtendWith(SpringExtension.class)
public class BoostActiveLevelServiceTest {

  @Autowired
  private BoostActiveLevelService boostActiveLevelService;

  @MockBean
  private BasalMetabolicRateService basalMetabolicRateService;

  private static Stream<Arguments> dataActiveLevelAndBmr() {
    return Stream.of(
        Arguments.of(ActiveLevel.SEDENTARY, 2, 2.4),
        Arguments.of(ActiveLevel.LIGHTLY_ACTIVE, 2, 2.75),
        Arguments.of(ActiveLevel.MODERATELY_ACTIVE, 2, 3.1),
        Arguments.of(ActiveLevel.VERY_ACTIVE, 2, 3.45),
        Arguments.of(ActiveLevel.EXTRA_ACTIVE, 2, 3.8)
    );
  }

  @Test
  @DisplayName("Should calculate calories based on metabolism")
  void shouldCalculateCaloriesBasedOnMetabolism() {
    when(basalMetabolicRateService.calculateBasalMetabolicRate(any(), anyDouble(), anyDouble(),
        anyInt())).thenReturn(5000.67);

    assertEquals(6000.804, this.boostActiveLevelService
        .calculateBoostActiveLevel(ActiveLevel.SEDENTARY, Gender.MALE, 96, 1.80, 20));

    verify(basalMetabolicRateService, times(1))
        .calculateBasalMetabolicRate(any(), anyDouble(), anyDouble(), anyInt());
  }

  @DisplayName("Should calculate calories by active level")
  @ParameterizedTest
  @MethodSource("dataActiveLevelAndBmr")
  void shouldCalculateCaloriesByActiveLevel(ActiveLevel activeLevel, double bmr, double expected) {
    assertEquals(expected,
        this.boostActiveLevelService.calculateCaloriesByActiveLevelAndBmr(activeLevel, bmr));
  }

  @Test
  @DisplayName("Should throw bad request exception when active level is null")
  void shouldThrowBadRequestExceptionWhenActiveLevelIsNull() {
    assertThrows(BadRequestException.class, () -> this.boostActiveLevelService
        .calculateBoostActiveLevel(null, Gender.MALE, 96, 1.80, 20));
  }

  @Test
  @DisplayName("Should throw bad request exception when gender is null")
  void shouldThrowBadRequestExceptionWhenGenderIsNull() {
    assertThrows(BadRequestException.class, () -> this.boostActiveLevelService
        .calculateBoostActiveLevel(ActiveLevel.LIGHTLY_ACTIVE, null, 96, 1.80, 20));
  }

  @Test
  @DisplayName("Should throw bad request exception when weight is null")
  void shouldThrowBadRequestExceptionWhenWeightIsInvalid() {
    assertThrows(BadRequestException.class, () -> this.boostActiveLevelService
        .calculateBoostActiveLevel(ActiveLevel.MODERATELY_ACTIVE, Gender.MALE, -96, 1.80, 20));
  }

  @Test
  @DisplayName("Should throw bad request exception when height is invalid")
  void shouldThrowBadRequestExceptionWhenHeightIsInvalid() {
    assertThrows(BadRequestException.class, () -> this.boostActiveLevelService
        .calculateBoostActiveLevel(ActiveLevel.VERY_ACTIVE, Gender.MALE, 96, -1.80, 20));
  }

  @Test
  @DisplayName("Should throw bad request exception when age is invalid")
  void shouldThrowBadRequestExceptionWhenAgeIsInvalid() {
    assertThrows(BadRequestException.class, () -> this.boostActiveLevelService
        .calculateBoostActiveLevel(ActiveLevel.EXTRA_ACTIVE, Gender.MALE, 96, 1.80, -20));
  }
}
