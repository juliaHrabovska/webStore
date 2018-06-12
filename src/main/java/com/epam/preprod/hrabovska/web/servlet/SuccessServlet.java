package com.epam.preprod.hrabovska.web.servlet;

import com.epam.preprod.hrabovska.web.Path;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SuccessServlet", urlPatterns = "/successOrder")
public class SuccessServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(SuccessServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String createdOrderId = (String) session.getAttribute("createdOrderId");
        if (StringUtils.isBlank(createdOrderId)) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        session.removeAttribute("createdOrderId");
        request.setAttribute("info", createdOrderId);
        String forward = Path.SUCCESS_ORDER_PAGE;
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(forward);
        LOG.trace("Forward to : " + forward);
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
