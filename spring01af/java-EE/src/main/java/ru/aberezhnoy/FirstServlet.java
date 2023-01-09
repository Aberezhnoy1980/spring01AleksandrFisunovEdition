package ru.aberezhnoy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FirstServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(FirstServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().printf("<html><body>");
        for (int i = 0; i < 5; i++) {
            resp.getWriter().printf("<h1>It's works!</h1>");
        }
        resp.getWriter().printf("</body></html>");
    }

    @Override
    public void init() throws ServletException {
        logger.debug("Init");
    }
}
