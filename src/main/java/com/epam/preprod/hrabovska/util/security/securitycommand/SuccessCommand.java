package com.epam.preprod.hrabovska.util.security.securitycommand;

import com.epam.preprod.hrabovska.util.security.SecurityCommand;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SuccessCommand implements SecurityCommand {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        chain.doFilter(request, response);
    }
}
