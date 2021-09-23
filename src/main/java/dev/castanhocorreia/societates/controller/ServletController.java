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
  HttpServletRequest request;
  HttpServletResponse response;

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    this.request = request;
    this.response = response;
    String uniformResourceIdentifier = this.request.getRequestURI();
    System.out.println(uniformResourceIdentifier);
    switch (uniformResourceIdentifier) {
      case "/societates/authenticate-user":
        this.authenticateUser();
        break;
      case "/societates/create-company":
        this.createCompanyAction();
        break;
      case "/societates/read-companies":
        this.readCompaniesAction();
        break;
      case "/societates/update-company":
        this.updateCompanyAction();
        break;
      case "/societates/delete-company":
        this.deleteCompanyAction();
        break;
      default:
        this.redirect("forward:authenticate-user.jsp");
    }
  }

  public void redirect(String redirectPattern) throws IOException, ServletException {
    String redirectMode = redirectPattern.split(":")[0];
    String redirectUrl = redirectPattern.split(":")[1];
    if (redirectMode.equals("redirect")) {
      this.response.sendRedirect(redirectUrl);
    } else {
      RequestDispatcher requestDispatcher = this.request.getRequestDispatcher("WEB-INF/view/" + redirectUrl);
      requestDispatcher.forward(this.request, this.response);
    }
  }

  public void authenticateUser() throws ServletException, IOException {
    AuthenticateUser authenticateUser = new AuthenticateUser();
    Boolean authenticatedUser = authenticateUser.execute(this.request, this.response);
    if (authenticatedUser) {
      this.redirect("forward:read-companies.jsp");
    } else {
      this.redirect("forward:authenticate-user.jsp");
    }
  }

  public void createCompanyAction() throws IOException, ServletException {
    String updateMethod = this.request.getMethod();
    if (updateMethod.equals("GET")) {
      this.redirect("forward:create-company.jsp");
    } else {
      CreateCompany createCompany = new CreateCompany();
      createCompany.execute(this.request, this.response);
      this.redirect("redirect:read-companies");
    }
  }

  public void readCompaniesAction() throws IOException, ServletException {
    ReadCompanies readCompanies = new ReadCompanies();
    readCompanies.execute(this.request, this.response);
    this.redirect("forward:read-companies.jsp");
  }

  public void updateCompanyAction() throws IOException, ServletException {
    UpdateCompany updateCompany = new UpdateCompany();
    String updateMethod = this.request.getMethod();
    if (updateMethod.equals("GET")) {
      updateCompany.doGet(this.request, this.response);
      this.redirect("forward:update-company.jsp");
    } else {
      updateCompany.doPost(this.request, this.response);
      this.redirect("redirect:read-companies");
    }
  }

  public void deleteCompanyAction() throws IOException, ServletException {
    DeleteCompany deleteCompany = new DeleteCompany();
    deleteCompany.execute(this.request, this.response);
    this.redirect("redirect:read-companies");
  }
}
