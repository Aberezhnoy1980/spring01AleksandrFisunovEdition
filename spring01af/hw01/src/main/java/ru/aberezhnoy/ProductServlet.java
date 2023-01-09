package ru.aberezhnoy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductServlet", urlPatterns = "/prod")
public class ProductServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(ProductServlet.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        String[] titles = {"Milk", "Bread", "Butter", "Meat", "Sugar"};
        int[] prices = {12,45,32,67,89};
        out.printf("<html><body>");
        for (int i = 0; i < 5; i++) {
            Product product = new Product(i + 1, titles[i], prices[i]);
            out.println("<html><body><h1>" + product + "</h1></body></html>");
        }
        out.printf("</body></html>");
        out.close();
    }
}
