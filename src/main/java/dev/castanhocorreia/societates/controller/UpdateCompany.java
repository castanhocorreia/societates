package dev.castanhocorreia.societates.controller;

import dev.castanhocorreia.societates.database.JVMMemory;
import dev.castanhocorreia.societates.model.Company;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateCompany {
  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String updateMethod = request.getMethod();
    if (updateMethod.equals("GET")) {
      String idParameter = request.getParameter("id");
      Long parsedIdParameter = Long.parseLong(idParameter);
      Company companyToBeUpdated = JVMMemory.getCompany(parsedIdParameter);
      RequestDispatcher requestDispatcher = request.getRequestDispatcher("/update-company.jsp");
      request.setAttribute("companyToBeUpdated", companyToBeUpdated);
      requestDispatcher.forward(request, response);
    } else if (updateMethod.equals("POST")) {
      String idParameter = request.getParameter("id");
      Long parsedIdParameter = Long.parseLong(idParameter);
      String newCompanyName = request.getParameter("newCompanyName");
      String newCompanyFoundingDateParameter = request.getParameter("newCompanyFoundingDate");
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
      Date newCompanyFoundingDate;
      try {
        newCompanyFoundingDate = simpleDateFormat.parse(newCompanyFoundingDateParameter);
      } catch (ParseException newFoundingDateIsInvalid) {
        throw new ServletException(newFoundingDateIsInvalid);
      }
      JVMMemory.updateCompanyById(parsedIdParameter, newCompanyName, newCompanyFoundingDate);
      response.sendRedirect("read-companies");
    }
  }
}
