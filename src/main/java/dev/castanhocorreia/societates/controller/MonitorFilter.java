package dev.castanhocorreia.societates.controller;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;

public class MonitorFilter implements Filter {
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;
    long timeBeforeRequest = System.currentTimeMillis();
    String requestAction = request.getRequestURI();
    chain.doFilter(request, response);
    long timeAfterRequest = System.currentTimeMillis();
    long executionTime = timeAfterRequest - timeBeforeRequest;
    System.out.println(String.format("%s -> [%d] ms", requestAction, executionTime));
  }
}
