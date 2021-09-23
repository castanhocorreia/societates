package dev.castanhocorreia.societates.database;

import dev.castanhocorreia.societates.model.Company;
import dev.castanhocorreia.societates.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class JVMMemory {
  private static List<Company> companiesList = new ArrayList<>();
  private static List<User> usersList = new ArrayList<>();

  static {
    User admin = new User("admin", "admin");
    usersList.add(admin);
  }

  public static void add(User user) {
    JVMMemory.usersList.add(user);
  }

  public static void add(Company company) {
    JVMMemory.companiesList.add(company);
  }

  public static void remove(long id) {
    Iterator<Company> iterator = JVMMemory.companiesList.iterator();
    while (iterator.hasNext()) {
      if (iterator.next().getId() == id) {
        iterator.remove();
      }
    }
  }

  public static User authenticateUser(String login, String password) {
    for (User user : usersList) {
      if (user.authenticate(login, password)) {
        return user;
      }
    }
    return null;
  }

  public static void updateCompanyById(long id, String name, Date foundedIn) {
    for (Company company : JVMMemory.companiesList) {
      if (company.getId() == id) {
        company.setName(name);
        company.setFoundedIn(foundedIn);
      }
    }
  }

  public static Company getCompany(long id) {
    for (Company company : JVMMemory.companiesList) {
      if (company.getId() == id) {
        return company;
      }
    }
    throw new NoSuchElementException("The company does not exist.");
  }

  public static List<Company> getCompanies() {
    return JVMMemory.companiesList;
  }
}
