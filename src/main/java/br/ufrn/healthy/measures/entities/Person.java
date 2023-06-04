package br.ufrn.healthy.measures.entities;

public class Person {

  private int age;

  private Gender gender;

  private Measures measures;

  private ActiveLevel activeLevel;

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Measures getMeasures() {
    return measures;
  }

  public void setMeasures(Measures measures) {
    this.measures = measures;
  }

  public ActiveLevel getActiveLevel() {
    return activeLevel;
  }

  public void setActiveLevel(ActiveLevel activeLevel) {
    this.activeLevel = activeLevel;
  }
}
