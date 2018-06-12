package com.epam.preprod.hrabovska.web.servlet;

import com.epam.preprod.hrabovska.web.Path;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ShowCartServlet", urlPatterns = "/showCart")
public class ShowCartServlet extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(ShowCartServlet.class);

    public void init(ServletConfig servletConfig) throws ServletException {
        LOG.trace("Checkout servlet start");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            LOG.trace("User is not logged in");
            LOG.trace("Redirect to : " + Path.LOGIN_PAGE);
            response.sendRedirect(Path.LOGIN_PAGE);
        } else {
            String forward = Path.CART_PAGE;
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(forward);
            LOG.trace("Forward to : " + forward);
            requestDispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
