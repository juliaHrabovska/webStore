package com.epam.preprod.hrabovska.web.servlet;

import com.epam.preprod.hrabovska.service.ProductService;
import com.epam.preprod.hrabovska.util.cart.CartCommand;
import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(CartServlet.class);

    private ProductService productService;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        LOG.trace("Cart servlet start");
        ServletContext context = servletConfig.getServletContext();
        productService = (ProductService) context.getAttribute("productService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter("command");
        CartCommand commands = new CartCommand(productService);
        commands.getAction(command).doAction(request, response);
    }
}
