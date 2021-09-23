package dev.castanhocorreia.societates.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class ServletController extends HttpServlet {
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String uniformResourceIdentifier = request.getRequestURI();
    switch (uniformResourceIdentifier) {
      case "/societates/create-company":
        this.createCompanyAction(request, response);
        break;
      case "/societates/read-companies":
        this.readCompaniesAction(request, response);
        break;
      case "/societates/update-company":
        this.updateCompanyAction(request, response);
        break;
      case "/societates/delete-company":
        this.deleteCompanyAction(request, response);
        break;
      default:
        response.sendRedirect("create-company.jsp");
    }
  }

  public void createCompanyAction(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    CreateCompany createCompany = new CreateCompany();
    createCompany.execute(request, response);
    response.sendRedirect("read-companies");
  }

  public void readCompaniesAction(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    ReadCompanies readCompanies = new ReadCompanies();
    readCompanies.execute(request, response);
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/read-companies.jsp");
    requestDispatcher.forward(request, response);
  }

  public void updateCompanyAction(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    UpdateCompany updateCompany = new UpdateCompany();
    String updateMethod = request.getMethod();
    if (updateMethod.equals("GET")) {
      updateCompany.doGet(request, response);
      RequestDispatcher requestDispatcher = request.getRequestDispatcher("/update-company.jsp");
      requestDispatcher.forward(request, response);
    } else if (updateMethod.equals("POST")) {
      updateCompany.doPost(request, response);
      response.sendRedirect("read-companies");
    }
  }

  public void deleteCompanyAction(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    DeleteCompany deleteCompany = new DeleteCompany();
    deleteCompany.execute(request, response);
    response.sendRedirect("read-companies");
  }
}
