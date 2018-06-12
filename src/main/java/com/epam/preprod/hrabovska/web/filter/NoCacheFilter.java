package com.epam.preprod.hrabovska.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NoCacheFilter implements Filter {

    public void init(FilterConfig fConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) response;
        res.setHeader("Cache-Control", "private, max-age=0, no-cache");
        res.setHeader("Pragma", "no-cache");
        chain.doFilter(request, response);
    }

    public void destroy() {
    }

}
