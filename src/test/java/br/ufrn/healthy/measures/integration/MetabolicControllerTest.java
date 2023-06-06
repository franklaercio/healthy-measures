package br.ufrn.healthy.measures.integration;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import br.ufrn.healthy.measures.Application;
import br.ufrn.healthy.measures.http.MetabolicController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
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
@DisplayName("Metabolic Controller")
@ContextConfiguration(classes = {Application.class})
@WebAppConfiguration
public class MetabolicControllerTest {

  @Autowired
  private WebApplicationContext webApplicationContext;

  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
  }

  @Test
  @DisplayName("Must calculate bmr with status 200")
  void mustCalculateBmrWithStatus200() throws Exception {
    this.mockMvc.perform(MockMvcRequestBuilders.get("/metabolic/bmr")
            .param("gender", "MALE")
            .param("weight", "80")
            .param("height", "1.75")
            .param("age", "20")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpectAll(content().contentType(MediaType.APPLICATION_JSON),
            jsonPath("$.calories").value(1040.15525));
  }

  @Test
  @DisplayName("Must calculate boost active level with status 200")
  void mustCalculateBoostActiveLevelWithStatus200() throws Exception {
    this.mockMvc.perform(MockMvcRequestBuilders.get("/metabolic/active-level")
            .param("activeLevel", "SEDENTARY")
            .param("gender", "MALE")
            .param("weight", "80")
            .param("height", "1.75")
            .param("age", "20")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpectAll(content().contentType(MediaType.APPLICATION_JSON),
            jsonPath("$.calories").value(1248.1863));
  }
}
