package dev.castanhocorreia.societates.controller;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = "/*")
public class MonitorFilter implements Filter {
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    long timeBeforeRequest = System.currentTimeMillis();
    String requestAction = "";
    if (request instanceof HttpServletRequest) {
      requestAction = ((HttpServletRequest) request).getRequestURI();
    }
    chain.doFilter(request, response);
    long timeAfterRequest = System.currentTimeMillis();
    System.out.println(requestAction + (timeAfterRequest - timeBeforeRequest));
  }
}
