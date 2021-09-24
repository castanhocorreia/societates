package dev.castanhocorreia.societates.controller;

import dev.castanhocorreia.societates.database.JVMMemory;
import dev.castanhocorreia.societates.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthenticateUser {
  public User execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
    String login = request.getParameter("login");
    String password = request.getParameter("password");
    if (login == null || password == null) {
      throw new ServletException("The login or password is null.");
    }
    User user = JVMMemory.authenticateUser(login, password);
    return user;
  }
}
