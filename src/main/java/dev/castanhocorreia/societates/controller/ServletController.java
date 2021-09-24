package dev.castanhocorreia.societates.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import java.io.IOException;

import dev.castanhocorreia.societates.model.User;

@WebServlet(urlPatterns = "/")
public class ServletController extends HttpServlet {
  HttpServletRequest request;
  HttpServletResponse response;
  HttpSession session;

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    this.request = request;
    this.response = response;
    this.session = this.request.getSession();
    String uniformResourceIdentifier = this.request.getRequestURI();
    System.out.println(uniformResourceIdentifier);
    HttpSession httpSession = request.getSession();
    Object accreditedUser = httpSession.getAttribute("accreditedUser");
    if (accreditedUser == null) {
      this.authenticateUserAction();
      return;
    }
    switch (uniformResourceIdentifier) {
      case "/societates/authenticate-user":
        if (accreditedUser == null) {
          this.authenticateUserAction();
        } else {
          this.readCompaniesAction();
        }
        break;
      case "/societates/logout-user":
        this.logoutUserAction();
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
        this.redirect("forward:read-companies.jsp");
    }
  }

  public void redirect(String redirectPattern) throws IOException, ServletException {
    String redirectMode = redirectPattern.split(":")[0];
    String redirectUrl = redirectPattern.split(":")[1];
    if (redirectMode.equals("redirect")) {
      this.response.sendRedirect(redirectUrl);
    } else {
      RequestDispatcher requestDispatcher = this.request.getRequestDispatcher("/WEB-INF/view/" + redirectUrl);
      requestDispatcher.forward(this.request, this.response);
    }
  }

  public void authenticateUserAction() throws ServletException, IOException {
    AuthenticateUser authenticateUser = new AuthenticateUser();
    try {
      User user = authenticateUser.execute(this.request, this.response);
      if (user != null) {
        this.session.setAttribute("accreditedUser", user);
        this.redirect("forward:read-companies.jsp");
      } else {
        this.request.setAttribute("incorrectCredentials", true);
        this.redirect("forward:authenticate-user.jsp");
      }
    } catch (ServletException exception) {
      this.redirect("forward:authenticate-user.jsp");
    }
  }

  public void logoutUserAction() throws IOException, ServletException {
    this.session.invalidate();
    this.redirect("forward:authenticate-user.jsp");
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
