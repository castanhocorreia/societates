package dev.castanhocorreia.societates.controller;

import dev.castanhocorreia.societates.model.Company;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import java.io.IOException;

@WebServlet(urlPatterns = "/register-company")
public class RegisterCompany extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String companyName = request.getParameter("companyName");
    Company company = new Company(companyName);
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/company-registered.jsp");
    request.setAttribute("companyName", company.getName());
    requestDispatcher.forward(request, response);
  }
}
