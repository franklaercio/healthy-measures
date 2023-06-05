package br.ufrn.healthy.measures.http;

import br.ufrn.healthy.measures.domain.ActiveLevel;
import br.ufrn.healthy.measures.domain.Gender;
import br.ufrn.healthy.measures.http.data.response.ActiveLevelResponse;
import br.ufrn.healthy.measures.http.data.response.BasalMetabolicRateResponse;
import br.ufrn.healthy.measures.http.data.response.BodyMassIndexResponse;
import br.ufrn.healthy.measures.http.data.response.FatRateResponse;
import br.ufrn.healthy.measures.http.data.response.LeanMassResponse;
import br.ufrn.healthy.measures.http.data.response.WaistHipRatioResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Body")
public interface BodyController {

    @Operation(summary = "Calculate body mass index")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully calculate body mass index"),
            @ApiResponse(responseCode = "400", description = "Missing or invalid parameter"),
            @ApiResponse(responseCode = "404", description = "Not found account"),
            @ApiResponse(responseCode = "500", description = "Internal server error")}
    )
    ResponseEntity<BodyMassIndexResponse> getBodyMassIndex(
            @Parameter(name = "weight", description = "Weight in kilograms", required = true) double weight,
            @Parameter(name = "height", description = "Height in meters", required = true) double height);

    @Operation(summary = "Calculate basal metabolic rate")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully calculate basal metabolic rate"),
            @ApiResponse(responseCode = "400", description = "Missing or invalid parameter"),
            @ApiResponse(responseCode = "404", description = "Not found account"),
            @ApiResponse(responseCode = "500", description = "Internal server error")}
    )
    ResponseEntity<BasalMetabolicRateResponse> getBasalMetabolicRate(
            @Parameter(name = "gender") Gender gender, @Parameter(name = "weight", description = "Weight in kilograms", required = true) double weight,
            @Parameter(name = "height") double height, @Parameter(name = "age") int age);

    @Operation(summary = "Calculate waist hip ratio")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully calculate waist hip ratio"),
            @ApiResponse(responseCode = "400", description = "Missing or invalid parameter"),
            @ApiResponse(responseCode = "404", description = "Not found account"),
            @ApiResponse(responseCode = "500", description = "Internal server error")}
    )
    ResponseEntity<WaistHipRatioResponse> getWaistHipRatio(@Parameter(name = "gender") Gender gender,
                                                           @Parameter(name = "waist") double waist, @Parameter(name = "hip") double hip);

    @Operation(summary = "Calculate fat rate")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully calculate fat rate"),
            @ApiResponse(responseCode = "400", description = "Missing or invalid parameter"),
            @ApiResponse(responseCode = "404", description = "Not found account"),
            @ApiResponse(responseCode = "500", description = "Internal server error")}
    )
    ResponseEntity<FatRateResponse> getFatRate(@Parameter(name = "gender") Gender gender,
                                               @Parameter(name = "weight", description = "Weight in kilograms", required = true) double weight, @Parameter(name = "height") double height);

    @Operation(summary = "Calculate lean mass")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully calculate lean mass"),
            @ApiResponse(responseCode = "400", description = "Missing or invalid parameter"),
            @ApiResponse(responseCode = "404", description = "Not found account"),
            @ApiResponse(responseCode = "500", description = "Internal server error")}
    )
    ResponseEntity<LeanMassResponse> getLeanMass(@Parameter(name = "gender") Gender gender, @Parameter(name = "weight", description = "Weight in kilograms", required = true) double weight, @Parameter(name = "height") double height);

    @Operation(summary = "Calculate active level")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully calculate active level"),
            @ApiResponse(responseCode = "400", description = "Missing or invalid parameter"),
            @ApiResponse(responseCode = "404", description = "Not found account"),
            @ApiResponse(responseCode = "500", description = "Internal server error")}
    )
    ResponseEntity<ActiveLevelResponse> getActiveLevel(
            @Parameter(name = "active_level") ActiveLevel activeLevel,
            @Parameter(name = "gender") Gender gender, @Parameter(name = "weight", description = "Weight in kilograms", required = true) double weight,
            @Parameter(name = "height") double height, @Parameter(name = "age") int age);

}
