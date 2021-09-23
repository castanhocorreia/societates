package dev.castanhocorreia.societates.model;

public class User {
  private static long count;
  private long id;
  private String login;
  private String password;

  public User(String login, String password) {
    User.count++;
    this.id = User.count;
    this.login = login;
    this.password = password;
  }

  public Boolean authenticate(String login, String password) {
    return (login.equals(this.login) && password.equals(this.password));
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
