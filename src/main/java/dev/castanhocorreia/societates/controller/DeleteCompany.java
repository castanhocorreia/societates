package dev.castanhocorreia.societates.controller;

import dev.castanhocorreia.societates.database.JVMMemory;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteCompany {
  public void execute(HttpServletRequest request, HttpServletResponse response) {
    long id = Long.parseLong(request.getParameter("id"));
    JVMMemory.remove(id);
  }
}
