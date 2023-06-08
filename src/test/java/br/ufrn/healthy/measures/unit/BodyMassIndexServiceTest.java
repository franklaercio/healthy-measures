package br.ufrn.healthy.measures.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import br.ufrn.healthy.measures.domain.ActiveLevel;
import br.ufrn.healthy.measures.domain.HealthyType;
import br.ufrn.healthy.measures.exceptions.BadRequestException;
import br.ufrn.healthy.measures.services.BodyMassIndexService;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DisplayName("Body Mass Index Service")
@ContextConfiguration(classes = {BodyMassIndexService.class})
@ExtendWith(SpringExtension.class)
public class BodyMassIndexServiceTest {

  @Autowired
  private BodyMassIndexService bodyMassIndexService;

  private static Stream<Arguments> dataBodyMassIndex() {
    return Stream.of(
        Arguments.of(50.0, 1.80, HealthyType.VERY_UNDERWEIGHT),
        Arguments.of(51.84, 1.80, HealthyType.UNDERWEIGHT),
        Arguments.of(55.0, 1.80, HealthyType.UNDERWEIGHT),
        Arguments.of(41.625, 1.50, HealthyType.NORMAL),
        Arguments.of(75.0, 1.80, HealthyType.NORMAL),
        Arguments.of(81.0, 1.80, HealthyType.OVERWEIGHT),
        Arguments.of(90.0, 1.80, HealthyType.OVERWEIGHT),
        Arguments.of(97.2, 1.80, HealthyType.OBESE_CLASS_I),
        Arguments.of(100, 1.80, HealthyType.OBESE_CLASS_I),
        Arguments.of(78.75, 1.50, HealthyType.OBESE_CLASS_II),
        Arguments.of(120, 1.80, HealthyType.OBESE_CLASS_II),
        Arguments.of(150, 1.80, HealthyType.OBESE_CLASS_III)
    );
  }

  @ParameterizedTest
  @MethodSource("dataBodyMassIndex")
  @DisplayName("Should calculate body mass index")
  public void shouldCalculateBodyMassIndexCaseOverweight(double weight, double height,
      HealthyType expected) {
    assertEquals(expected,
        this.bodyMassIndexService.calculateBodyMassIndex(weight, height));
  }

  @Test
  @DisplayName("Should throws bad request when weight is invalid")
  public void shouldThrowsBadRequestWhenWeightIsInvalid() {
    assertThrows(BadRequestException.class, () -> this.bodyMassIndexService
        .calculateBodyMassIndex(-96.0, 1.80));
  }

  @Test
  @DisplayName("Should throws bad request when height is invalid")
  public void shouldThrowsBadRequestWhenHeightIsInvalid() {
    assertThrows(BadRequestException.class, () -> this.bodyMassIndexService
        .calculateBodyMassIndex(96.0, -1.80));
  }
}
