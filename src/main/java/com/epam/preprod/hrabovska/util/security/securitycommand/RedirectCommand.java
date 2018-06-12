package com.epam.preprod.hrabovska.util.security.securitycommand;

import com.epam.preprod.hrabovska.util.security.SecurityCommand;
import com.epam.preprod.hrabovska.web.Path;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectCommand implements SecurityCommand {

        @Override
        public void execute(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
                    throws IOException {
            response.sendRedirect(Path.LOGIN_SERVLET);
        }
}
