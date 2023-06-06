package br.ufrn.healthy.measures.http;

import br.ufrn.healthy.measures.domain.Gender;
import br.ufrn.healthy.measures.http.data.BodyMassIndexResponse;
import br.ufrn.healthy.measures.http.data.FatRateResponse;
import br.ufrn.healthy.measures.http.data.LeanMassResponse;
import br.ufrn.healthy.measures.http.data.WaistHipRatioResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Shape")
public interface ShapeController {

  @Operation(summary = "Calculate body mass index")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successfully calculate body mass index"),
      @ApiResponse(responseCode = "400", description = "Missing or invalid parameter", content = @Content),
      @ApiResponse(responseCode = "404", description = "Not found account", content = @Content),
      @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)}
  )
  ResponseEntity<BodyMassIndexResponse> getBodyMassIndex(
      @Parameter(name = "weight", description = "Weight in kilograms", required = true) Double weight,
      @Parameter(name = "height", description = "Height in meters", required = true) Double height);

  @Operation(summary = "Calculate waist hip ratio")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successfully calculate waist hip ratio"),
      @ApiResponse(responseCode = "400", description = "Missing or invalid parameter", content = @Content),
      @ApiResponse(responseCode = "404", description = "Not found account", content = @Content),
      @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)}
  )
  ResponseEntity<WaistHipRatioResponse> getWaistHipRatio(
      @Parameter(name = "gender") Gender gender,
      @Parameter(name = "waist", description = "Waist in centimeters", required = true) Double waist,
      @Parameter(name = "hip", description = "Hip in centimeters", required = true) Double hip);

  @Operation(summary = "Calculate fat rate")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successfully calculate fat rate"),
      @ApiResponse(responseCode = "400", description = "Missing or invalid parameter", content = @Content),
      @ApiResponse(responseCode = "404", description = "Not found account", content = @Content),
      @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)}
  )
  ResponseEntity<FatRateResponse> getFatRate(@Parameter(name = "gender") Gender gender,
      @Parameter(name = "weight", description = "Weight in kilograms", required = true) Double weight,
      @Parameter(name = "height", description = "Height in meters", required = true) Double height);

  @Operation(summary = "Calculate lean mass")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successfully calculate lean mass"),
      @ApiResponse(responseCode = "400", description = "Missing or invalid parameter", content = @Content),
      @ApiResponse(responseCode = "404", description = "Not found account", content = @Content),
      @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)}
  )
  ResponseEntity<LeanMassResponse> getLeanMass(@Parameter(name = "gender") Gender gender,
      @Parameter(name = "weight", description = "Weight in kilograms", required = true) Double weight,
      @Parameter(name = "height", description = "Height in meters", required = true) Double height);
}
