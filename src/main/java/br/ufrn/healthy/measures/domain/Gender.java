package br.ufrn.healthy.measures.domain;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public enum Gender {
  MALE, FEMALE;

  public static boolean contains(Gender value) {
    for (Gender gender : Gender.values()) {
      if (gender.equals(value)) {
        return true;
      }
    }
    return false;
  }
}
