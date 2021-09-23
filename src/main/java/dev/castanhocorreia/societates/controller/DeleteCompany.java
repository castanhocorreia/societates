package dev.castanhocorreia.societates.controller;

import java.io.IOException;

import dev.castanhocorreia.societates.database.Memory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/delete-company")
public class DeleteCompany extends HttpServlet {
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    long id = Long.parseLong(request.getParameter("id"));
    Memory.remove(id);
    response.sendRedirect("list-companies");
  }
}
