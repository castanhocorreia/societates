package dev.castanhocorreia.societates.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/")
public class ServletController extends HttpServlet {
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String uniformResourceIdentifier = request.getRequestURI();
    System.out.println(uniformResourceIdentifier);
    if (uniformResourceIdentifier.equals("/societates/create-company")) {
      CreateCompany action = new CreateCompany();
      action.execute(request, response);
    } else if (uniformResourceIdentifier.equals("/societates/read-companies")) {
      ReadCompanies action = new ReadCompanies();
      action.execute(request, response);
    } else if (uniformResourceIdentifier.equals("/societates/update-company")) {
      UpdateCompany action = new UpdateCompany();
      action.execute(request, response);
    } else if (uniformResourceIdentifier.equals("/societates/delete-company")) {
      DeleteCompany action = new DeleteCompany();
      action.execute(request, response);
    } else {
      response.sendRedirect("create-company.jsp");
    }
  }
}
