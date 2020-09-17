package com.itp.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AboutUsServlet extends javax.servlet.http.HttpServlet {

 private String message;

  public void init() throws ServletException
  {

  }

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
      String pathInfo = request.getPathInfo();
      request.getRequestDispatcher("/WEB-INF/views/AboutUs.jsp" + pathInfo).forward(request, response);

  }
}
 