package dev.castanhocorreia.societates.view;

import dev.castanhocorreia.societates.database.Memory;
import dev.castanhocorreia.societates.model.Company;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/list-companies")
public class ListCompanies extends HttpServlet {
  private static List<Company> list = Memory.getCompanies();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/list-companies.jsp");
    request.setAttribute("companiesList", list);
    requestDispatcher.forward(request, response);
  }

}
