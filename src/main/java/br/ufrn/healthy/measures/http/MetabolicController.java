package br.ufrn.healthy.measures.http;

import br.ufrn.healthy.measures.domain.ActiveLevel;
import br.ufrn.healthy.measures.domain.Gender;
import br.ufrn.healthy.measures.http.data.ActiveLevelResponse;
import br.ufrn.healthy.measures.http.data.BasalMetabolicRateResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Metabolic")
public interface MetabolicController {

  @Operation(summary = "Calculate basal metabolic rate")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successfully calculate basal metabolic rate"),
      @ApiResponse(responseCode = "400", description = "Missing or invalid parameter", content = @Content),
      @ApiResponse(responseCode = "404", description = "Not found account", content = @Content),
      @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)}
  )
  ResponseEntity<BasalMetabolicRateResponse> getBasalMetabolicRate(
      @Parameter(name = "gender") Gender gender,
      @Parameter(name = "weight", description = "Weight in kilograms", required = true) Double weight,
      @Parameter(name = "height", description = "Height in meters", required = true) Double height,
      @Parameter(name = "age", description = "Age in years", required = true) Integer age);

  @Operation(summary = "Calculate active level")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successfully calculate active level"),
      @ApiResponse(responseCode = "400", description = "Missing or invalid parameter", content = @Content),
      @ApiResponse(responseCode = "404", description = "Not found account", content = @Content),
      @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)}
  )
  ResponseEntity<ActiveLevelResponse> getActiveLevel(
      @Parameter(name = "active_level") ActiveLevel activeLevel,
      @Parameter(name = "gender") Gender gender,
      @Parameter(name = "weight", description = "Weight in kilograms", required = true) Double weight,
      @Parameter(name = "height", description = "Height in meters", required = true) Double height,
      @Parameter(name = "age", description = "Age in years", required = true) Integer age);
}
