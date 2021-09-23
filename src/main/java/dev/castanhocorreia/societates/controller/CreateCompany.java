package dev.castanhocorreia.societates.controller;

import dev.castanhocorreia.societates.database.JVMMemory;
import dev.castanhocorreia.societates.model.Company;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateCompany {
  public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    String newCompanyName = request.getParameter("newCompanyName");
    Date newCompanyFoundedDate;
    try {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
      newCompanyFoundedDate = simpleDateFormat.parse(request.getParameter("newCompanyFoundedDate"));
    } catch (ParseException parseException) {
      throw new ServletException(parseException);
    }
    Company newCompany = new Company(newCompanyName, newCompanyFoundedDate);
    JVMMemory.add(newCompany);
    response.sendRedirect("read-companies");
  }
}
