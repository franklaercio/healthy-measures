package br.ufrn.healthy.measures.services.validators;

import br.ufrn.healthy.measures.domain.Gender;
import br.ufrn.healthy.measures.exceptions.BadRequestException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
public class MeasuresValidatorTest {

    private static Stream<Arguments> provideValidBasalMetabolicRate() {
        return Stream.of(
                Arguments.of(Gender.MALE, 90, 1.75, 20),
                Arguments.of(Gender.FEMALE, 60, 1.65, 22)
        );
    }

    private static Stream<Arguments> provideInvalidBasalMetabolicRate() {
        return Stream.of(
                Arguments.of(null, 90, 1.75, 20),
                Arguments.of(Gender.MALE, -1.5, 1.65, 22),
                Arguments.of(Gender.MALE, 60, -1.5, 22),
                Arguments.of(Gender.MALE, 60, 1.65, -1),
                Arguments.of(Gender.MALE, -1.5, -1.5, -1),
                Arguments.of(null, -1.5, -1.5, -1)
        );
    }

    private static Stream<Arguments> provideValidBodyMassIndex() {
        return Stream.of(
                Arguments.of(Gender.MALE, 90, 1.75, 20),
                Arguments.of(Gender.FEMALE, 60, 1.65, 22)
        );
    }

    private static Stream<Arguments> provideInvalidBodyMassIndex() {
        return Stream.of(
                Arguments.of(null, 90, 1.75, 20),
                Arguments.of(Gender.MALE, -1.5, 1.65, 22),
                Arguments.of(Gender.MALE, 60, -1.5, 22),
                Arguments.of(Gender.MALE, 60, 1.65, -1),
                Arguments.of(Gender.MALE, -1.5, -1.5, -1),
                Arguments.of(null, -1.5, -1.5, -1)
        );
    }

    private static Stream<Arguments> provideValidBoostActiveLevel() {
        return Stream.of(
                Arguments.of(Gender.MALE, 90, 1.75, 20),
                Arguments.of(Gender.FEMALE, 60, 1.65, 22)
        );
    }

    private static Stream<Arguments> provideInvalidBoostActiveLevel() {
        return Stream.of(
                Arguments.of(null, 90, 1.75, 20),
                Arguments.of(Gender.MALE, -1.5, 1.65, 22),
                Arguments.of(Gender.MALE, 60, -1.5, 22),
                Arguments.of(Gender.MALE, 60, 1.65, -1),
                Arguments.of(Gender.MALE, -1.5, -1.5, -1),
                Arguments.of(null, -1.5, -1.5, -1)
        );
    }

    private static Stream<Arguments> provideValidFatRate() {
        return Stream.of(
                Arguments.of(Gender.MALE, 90, 1.75, 20),
                Arguments.of(Gender.FEMALE, 60, 1.65, 22)
        );
    }

    private static Stream<Arguments> provideInvalidFatRate() {
        return Stream.of(
                Arguments.of(null, 90, 1.75, 20),
                Arguments.of(Gender.MALE, -1.5, 1.65, 22),
                Arguments.of(Gender.MALE, 60, -1.5, 22),
                Arguments.of(Gender.MALE, 60, 1.65, -1),
                Arguments.of(Gender.MALE, -1.5, -1.5, -1),
                Arguments.of(null, -1.5, -1.5, -1)
        );
    }

    private static Stream<Arguments> provideValidLeanMass() {
        return Stream.of(
                Arguments.of(Gender.MALE, 90, 1.75, 20),
                Arguments.of(Gender.FEMALE, 60, 1.65, 22)
        );
    }

    private static Stream<Arguments> provideInvalidLeanMass() {
        return Stream.of(
                Arguments.of(null, 90, 1.75, 20),
                Arguments.of(Gender.MALE, -1.5, 1.65, 22),
                Arguments.of(Gender.MALE, 60, -1.5, 22),
                Arguments.of(Gender.MALE, 60, 1.65, -1),
                Arguments.of(Gender.MALE, -1.5, -1.5, -1),
                Arguments.of(null, -1.5, -1.5, -1)
        );
    }

    private static Stream<Arguments> provideValidWaistHipRatio() {
        return Stream.of(
                Arguments.of(Gender.MALE, 90, 1.75, 20),
                Arguments.of(Gender.FEMALE, 60, 1.65, 22)
        );
    }

    private static Stream<Arguments> provideInvalidBasalMetabolicRate() {
        return Stream.of(
                Arguments.of(null, 90, 1.75, 20),
                Arguments.of(Gender.MALE, -1.5, 1.65, 22),
                Arguments.of(Gender.MALE, 60, -1.5, 22),
                Arguments.of(Gender.MALE, 60, 1.65, -1),
                Arguments.of(Gender.MALE, -1.5, -1.5, -1),
                Arguments.of(null, -1.5, -1.5, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideValidBasalMetabolicRate")
    void shouldValidateBasalMetabolicRate(Gender gender, double weight, double height, int age) {
        assertDoesNotThrow(() -> MeasureValidator.validateBasalMetabolicRate(gender, weight, height, age));
    }

    @ParameterizedTest
    @MethodSource("provideInvalidBasalMetabolicRate")
    void shouldInvalidateBasalMetabolicRate(Gender gender, double weight, double height, int age) {
        assertThrows(BadRequestException.class,
                () -> MeasureValidator.validateBasalMetabolicRate(gender, weight, height, age));
    }

    @ParameterizedTest
    @MethodSource("provideValidBodyMassIndex")
    void shouldValidateBodyMassIndex(Gender gender, double weight, double height, int age) {
        assertDoesNotThrow(() -> MeasureValidator.validateBasalMetabolicRate(gender, weight, height, age));
    }

    @ParameterizedTest
    @MethodSource("provideInvalidBodyMassIndex")
    void shouldInvalidateBodyMassIndex(Gender gender, double weight, double height, int age) {
        assertThrows(BadRequestException.class,
                () -> MeasureValidator.validateBasalMetabolicRate(gender, weight, height, age));
    }

    @ParameterizedTest
    @MethodSource("provideValidBoostActiveLevel")
    void shouldValidateBoostActiveLevel(Gender gender, double weight, double height, int age) {
        assertDoesNotThrow(() -> MeasureValidator.validateBasalMetabolicRate(gender, weight, height, age));
    }

    @ParameterizedTest
    @MethodSource("provideInvalidBoostActiveLevel")
    void shouldInvalidateBoostActiveLevel(Gender gender, double weight, double height, int age) {
        assertThrows(BadRequestException.class,
                () -> MeasureValidator.validateBasalMetabolicRate(gender, weight, height, age));
    }

    @ParameterizedTest
    @MethodSource("provideValidBasalMetabolicRate")
    void shouldValidateFatRate(Gender gender, double weight, double height, int age) {
        assertDoesNotThrow(() -> MeasureValidator.validateBasalMetabolicRate(gender, weight, height, age));
    }

    @ParameterizedTest
    @MethodSource("provideInvalidFatRate")
    void shouldInvalidateFatRate(Gender gender, double weight, double height, int age) {
        assertThrows(BadRequestException.class,
                () -> MeasureValidator.validateBasalMetabolicRate(gender, weight, height, age));
    }

    @ParameterizedTest
    @MethodSource("provideValidLeanMass")
    void shouldValidateLeanMass(Gender gender, double weight, double height, int age) {
        assertDoesNotThrow(() -> MeasureValidator.validateBasalMetabolicRate(gender, weight, height, age));
    }

    @ParameterizedTest
    @MethodSource("provideInvalidLeanMass")
    void shouldInvalidateLeanMass(Gender gender, double weight, double height, int age) {
        assertThrows(BadRequestException.class,
                () -> MeasureValidator.validateBasalMetabolicRate(gender, weight, height, age));
    }

    @ParameterizedTest
    @MethodSource("provideValidWaistHipRatio")
    void shouldValidateWaistHipRatio(Gender gender, double weight, double height, int age) {
        assertDoesNotThrow(() -> MeasureValidator.validateBasalMetabolicRate(gender, weight, height, age));
    }

    @ParameterizedTest
    @MethodSource("provideInvalidWaistHipRatio")
    void shouldInvalidateWaistHipRatio(Gender gender, double weight, double height, int age) {
        assertThrows(BadRequestException.class,
                () -> MeasureValidator.validateBasalMetabolicRate(gender, weight, height, age));
    }
}
