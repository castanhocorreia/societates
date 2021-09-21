package dev.castanhocorreia.societates.model;

import java.util.Date;

public class Company {
  private static long count;
  private long id;
  private Date registrationDate;
  private String name;
  private Date foundedIn = new Date();

  public Company(String name, Date foundedIn) {
    Company.count++;
    this.id = Company.count;
    this.registrationDate = new Date((System.currentTimeMillis()));
    this.name = name;
    this.foundedIn = foundedIn;
  }

  public long getId() {
    return this.id;
  }

  public Date getRegistrationDate() {
    return this.registrationDate;
  }

  public String getName() {
    return this.name;
  }

  public Date getFoundedIn() {
    return this.foundedIn;
  }
}
