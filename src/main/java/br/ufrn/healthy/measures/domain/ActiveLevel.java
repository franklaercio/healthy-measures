package br.ufrn.healthy.measures.domain;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public enum ActiveLevel {
  SEDENTARY, LIGHTLY_ACTIVE, MODERATELY_ACTIVE, VERY_ACTIVE, EXTRA_ACTIVE;

  public static boolean contains(ActiveLevel value) {
    for (ActiveLevel activeLevel : ActiveLevel.values()) {
      if (activeLevel.equals(value)) {
        return true;
      }
    }
    return false;
  }
}
