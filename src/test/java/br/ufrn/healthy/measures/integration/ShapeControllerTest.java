package br.ufrn.healthy.measures.integration;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import br.ufrn.healthy.measures.Application;
import br.ufrn.healthy.measures.domain.HealthyType;
import br.ufrn.healthy.measures.exceptions.InternalServerErrorException;
import br.ufrn.healthy.measures.services.BodyMassIndexService;
import br.ufrn.healthy.measures.services.BodyMassService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@DisplayName("Shape Controller")
@ContextConfiguration(classes = {Application.class})
@WebAppConfiguration
class ShapeControllerTest {

  @Autowired
  private WebApplicationContext webApplicationContext;

  @MockBean
  private BodyMassIndexService bodyMassIndexService;

  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
  }

  @Test
  @DisplayName("Must calculate bmi with status 200")
  void mustCalculateBmiWithStatus200() throws Exception {
    when(bodyMassIndexService.calculateBodyMassIndex(anyDouble(), anyDouble()))
        .thenReturn(HealthyType.OVERWEIGHT);

    this.mockMvc.perform(MockMvcRequestBuilders.get("/shape/bmi")
            .param("weight", "80")
            .param("height", "1.75")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpectAll(content().contentType(MediaType.APPLICATION_JSON),
            jsonPath("$.healthy_type").value("OVERWEIGHT"));
  }

  @Test
  @DisplayName("Must calculate waist hip ratio with status 200")
  void mustCalculateWaistHipRatioWithStatus200() throws Exception {
    this.mockMvc.perform(MockMvcRequestBuilders.get("/shape/waist-hip-ratio")
            .param("gender", "MALE")
            .param("waist", "80")
            .param("hip", "100.00")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpectAll(content().contentType(MediaType.APPLICATION_JSON),
            jsonPath("$.level").value("LOW_RISK"));
  }

  @Test
  @DisplayName("Must calculate fat rate with status 200")
  void mustCalculateFatRateWithStatus200() throws Exception {
    this.mockMvc.perform(MockMvcRequestBuilders.get("/shape/fat-rate")
            .param("gender", "MALE")
            .param("weight", "80")
            .param("height", "1.75")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpectAll(content().contentType(MediaType.APPLICATION_JSON),
            jsonPath("$.fat_rate").value(82.6918425));
  }

  @Test
  @DisplayName("Must calculate lean mass with status 200")
  void mustCalculateLeanMassWithStatus200() throws Exception {
    this.mockMvc.perform(MockMvcRequestBuilders.get("/shape/lean-mass")
            .param("gender", "MALE")
            .param("weight", "80")
            .param("height", "1.75")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpectAll(content().contentType(MediaType.APPLICATION_JSON),
            jsonPath("$.lean_mass").value(-2.6918425));
  }

  @Test
  @DisplayName("Must return 404 when not exists path")
  void mustReturnStatus404WhenNotExistsPath() throws Exception {
    this.mockMvc.perform(MockMvcRequestBuilders.get("/shape/not-exists")
            .param("gender", "MALE")
            .param("weight", "80")
            .param("height", "1.75")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().is4xxClientError());
  }

  @Test
  @DisplayName("Must return 500 when cannot calculate")
  void mustReturnStatus500WhenCannotCalculate() throws Exception {
    when(bodyMassIndexService.calculateBodyMassIndex(anyDouble(), anyDouble()))
        .thenThrow(new InternalServerErrorException("Failed to calculate lean mass"));

    this.mockMvc.perform(MockMvcRequestBuilders.get("/shape/bmi")
            .param("weight", "80")
            .param("height", "1.75")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().is5xxServerError());
  }
}
