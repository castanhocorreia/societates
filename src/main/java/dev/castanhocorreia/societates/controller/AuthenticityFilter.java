package dev.castanhocorreia.societates.controller;

import dev.castanhocorreia.societates.model.User;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;

public class AuthenticityFilter implements Filter {
  HttpServletRequest request;
  HttpServletResponse response;
  HttpSession session;

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
      throws IOException, ServletException {
    this.request = (HttpServletRequest) servletRequest;
    this.response = (HttpServletResponse) servletResponse;
    this.session = request.getSession();
    Object accreditedUser = session.getAttribute("accreditedUser");
    if (accreditedUser == null) {
      this.authenticateUserAction();
      return;
    } else {
      chain.doFilter(request, response);
    }
  }

  private void redirect(String redirectPattern) throws IOException, ServletException {
    RequestDispatcher requestDispatcher = this.request.getRequestDispatcher("/WEB-INF/view/" + redirectPattern);
    requestDispatcher.forward(this.request, this.response);
  }

  private void authenticateUserAction() throws ServletException, IOException {
    AuthenticateUser authenticateUser = new AuthenticateUser();
    try {
      User user = authenticateUser.execute(this.request, this.response);
      if (user != null) {
        this.session.setAttribute("accreditedUser", user);
        this.redirect("read-companies.jsp");
      } else {
        this.request.setAttribute("incorrectCredentials", true);
        this.redirect("authenticate-user.jsp");
      }
    } catch (ServletException exception) {
      this.redirect("authenticate-user.jsp");
    }
  }

}
