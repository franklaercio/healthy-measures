package br.ufrn.healthy.measures.domain;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public enum HealthyType {
  VERY_UNDERWEIGHT,
  UNDERWEIGHT,
  NORMAL,
  OVERWEIGHT,
  OBESE_CLASS_I,
  OBESE_CLASS_II,
  OBESE_CLASS_III
}
