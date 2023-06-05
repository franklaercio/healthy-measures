package br.ufrn.healthy.measures.http;

import br.ufrn.healthy.measures.http.data.request.ActiveLevelRequest;
import br.ufrn.healthy.measures.http.data.request.BasalMetabolicRateRequest;
import br.ufrn.healthy.measures.http.data.request.BodyMassIndexRequest;
import br.ufrn.healthy.measures.http.data.request.FatRateRequest;
import br.ufrn.healthy.measures.http.data.request.LeanMassRequest;
import br.ufrn.healthy.measures.http.data.request.WaistHipRatioRequest;
import br.ufrn.healthy.measures.http.data.response.ActiveLevelResponse;
import br.ufrn.healthy.measures.http.data.response.BasalMetabolicRateResponse;
import br.ufrn.healthy.measures.http.data.response.BodyMassIndexResponse;
import br.ufrn.healthy.measures.http.data.response.FatRateResponse;
import br.ufrn.healthy.measures.http.data.response.LeanMassResponse;
import br.ufrn.healthy.measures.http.data.response.WaistHipRatioResponse;
import io.swagger.v3.oas.annotations.Operation;
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
  ResponseEntity<BodyMassIndexResponse> getBodyMassIndex(BodyMassIndexRequest bodyMassIndexRequest);

  @Operation(summary = "Calculate basal metabolic rate")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successfully calculate basal metabolic rate"),
      @ApiResponse(responseCode = "400", description = "Missing or invalid parameter"),
      @ApiResponse(responseCode = "404", description = "Not found account"),
      @ApiResponse(responseCode = "500", description = "Internal server error")}
  )
  ResponseEntity<BasalMetabolicRateResponse> getBasalMetabolicRate(
      BasalMetabolicRateRequest basalMetabolicRateRequest);

  @Operation(summary = "Calculate waist hip ratio")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successfully calculate waist hip ratio"),
      @ApiResponse(responseCode = "400", description = "Missing or invalid parameter"),
      @ApiResponse(responseCode = "404", description = "Not found account"),
      @ApiResponse(responseCode = "500", description = "Internal server error")}
  )
  ResponseEntity<WaistHipRatioResponse> getWaistHipRatio(WaistHipRatioRequest waistHipRatioRequest);

  @Operation(summary = "Calculate fat rate")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successfully calculate fat rate"),
      @ApiResponse(responseCode = "400", description = "Missing or invalid parameter"),
      @ApiResponse(responseCode = "404", description = "Not found account"),
      @ApiResponse(responseCode = "500", description = "Internal server error")}
  )
  ResponseEntity<FatRateResponse> getFatRate(FatRateRequest fatRateRequest);

  @Operation(summary = "Calculate lean mass")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successfully calculate lean mass"),
      @ApiResponse(responseCode = "400", description = "Missing or invalid parameter"),
      @ApiResponse(responseCode = "404", description = "Not found account"),
      @ApiResponse(responseCode = "500", description = "Internal server error")}
  )
  ResponseEntity<LeanMassResponse> getLeanMass(LeanMassRequest leanMassRequest);

  @Operation(summary = "Calculate active level")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successfully calculate active level"),
      @ApiResponse(responseCode = "400", description = "Missing or invalid parameter"),
      @ApiResponse(responseCode = "404", description = "Not found account"),
      @ApiResponse(responseCode = "500", description = "Internal server error")}
  )
  ResponseEntity<ActiveLevelResponse> getActiveLevel(ActiveLevelRequest activeLevelRequest);

}
