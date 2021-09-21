package dev.castanhocorreia.societates.controller;

import dev.castanhocorreia.societates.database.Memory;
import dev.castanhocorreia.societates.model.Company;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/register-company")
public class RegisterCompany extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String name = request.getParameter("name");
    Date foundedIn;
    try {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
      foundedIn = simpleDateFormat.parse(request.getParameter("foundedIn"));
    } catch (ParseException parseException) {
      throw new ServletException(parseException);
    }
    Company company = new Company(name, foundedIn);
    Memory.add(company);
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/company-registered.jsp");
    request.setAttribute("name", company.getName());
    requestDispatcher.forward(request, response);
  }
}
