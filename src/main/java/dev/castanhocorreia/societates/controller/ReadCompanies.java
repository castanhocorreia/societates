package dev.castanhocorreia.societates.controller;

import dev.castanhocorreia.societates.database.JVMMemory;
import dev.castanhocorreia.societates.model.Company;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

public class ReadCompanies {
  private static List<Company> companiesList = JVMMemory.getCompanies();

  public void execute(HttpServletRequest request, HttpServletResponse response) {
    request.setAttribute("companiesList", companiesList);
  }
}
