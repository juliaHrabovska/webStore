package com.epam.preprod.hrabovska.util.security.securitycommand;

import com.epam.preprod.hrabovska.util.security.SecurityCommand;
import com.epam.preprod.hrabovska.web.Path;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ErrorCommand implements SecurityCommand{

        @Override
        public void execute(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
                    throws IOException {
            String forward = Path.ERROR_PAGE;
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(forward);
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException ignored) {
            }
        }

}
