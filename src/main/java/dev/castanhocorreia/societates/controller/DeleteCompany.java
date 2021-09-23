package dev.castanhocorreia.societates.controller;

import java.io.IOException;

import dev.castanhocorreia.societates.database.JVMMemory;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteCompany {
  public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
    long id = Long.parseLong(request.getParameter("id"));
    JVMMemory.remove(id);
    response.sendRedirect("read-companies");
  }
}
