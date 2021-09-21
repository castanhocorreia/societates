package dev.castanhocorreia.societates.database;

import dev.castanhocorreia.societates.model.Company;
import java.util.ArrayList;
import java.util.List;

public class Memory {
  private static List<Company> list = new ArrayList<>();

  public static void add(Company company) {
    Memory.list.add(company);
  }

  public static List<Company> getCompanies() {
    return Memory.list;
  }
}
