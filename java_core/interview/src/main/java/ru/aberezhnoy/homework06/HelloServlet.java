package ru.aberezhnoy.homework06;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/*")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest red, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h2>Hello, World!!!</h2>");
    }
}
