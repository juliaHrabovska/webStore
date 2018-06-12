package com.epam.preprod.hrabovska.web.filter;

import com.epam.preprod.hrabovska.model.entity.User;
import com.epam.preprod.hrabovska.service.SecurityService;
import com.epam.preprod.hrabovska.service.impl.SecurityServiceImpl;
import com.epam.preprod.hrabovska.util.security.SecurityCommand;
import com.epam.preprod.hrabovska.util.security.SecurityCommandContainer;
import com.epam.preprod.hrabovska.util.xml.DOMParser;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SecurityFilter implements Filter {

    private static final Logger LOG = Logger.getLogger(SecurityFilter.class);

    private static final String SEPARATOR = File.separator;

    private SecurityService authorizationService;
    private SecurityCommandContainer actionContainer;

    public void init(FilterConfig fConfig) throws ServletException {
        Map<String, List<String>> rules = loadRules(fConfig);
        authorizationService = new SecurityServiceImpl(rules);
        actionContainer = new SecurityCommandContainer();
        LOG.trace("Security filter start");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        String actionName = authorizationService.checkAccess(req.getRequestURI(), user);
        SecurityCommand command = actionContainer.getCommand(actionName);
        command.execute(req, res, chain);
    }

    private Map<String, List<String>> loadRules(FilterConfig fConfig) {
        Map<String, List<String>> rules = Collections.emptyMap();
        String appPath = fConfig.getServletContext().getRealPath("");
        String xmlPath = fConfig.getInitParameter("XMLPath");
        String xmlFileName = fConfig.getInitParameter("XMLFileName");
        DOMParser parser = new DOMParser(appPath + xmlPath + SEPARATOR + xmlFileName);
        System.out.println(appPath + xmlPath + SEPARATOR + xmlFileName);
        try {
            parser.parse(true);
            rules = parser.getRules();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            LOG.error("Can not parse XML file", e);
        }
        return rules;
    }

    public void destroy() {
    }
}
