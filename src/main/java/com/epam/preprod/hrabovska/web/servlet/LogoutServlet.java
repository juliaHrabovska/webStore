package com.epam.preprod.hrabovska.web.servlet;

import com.epam.preprod.hrabovska.web.Path;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(LogoutServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LOG.trace("LogoutServlet starts");
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.invalidate();
        LOG.trace("Session is invalidated");
        LOG.trace("Redirect to " + Path.CATEGORY_SERVLET);
        response.sendRedirect(Path.CATEGORY_SERVLET);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
