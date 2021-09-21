package dev.castanhocorreia.societates.model;

public class Company {
  private long id;
  private String name;

  public Company(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public long getId() {
    return this.id;
  }
}
