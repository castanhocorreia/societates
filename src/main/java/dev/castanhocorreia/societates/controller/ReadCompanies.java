package dev.castanhocorreia.societates.controller;

import dev.castanhocorreia.societates.database.JVMMemory;
import dev.castanhocorreia.societates.model.Company;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.util.List;

public class ReadCompanies {
  private static List<Company> companiesList = JVMMemory.getCompanies();

  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/read-companies.jsp");
    request.setAttribute("companiesList", companiesList);
    requestDispatcher.forward(request, response);
  }
}
