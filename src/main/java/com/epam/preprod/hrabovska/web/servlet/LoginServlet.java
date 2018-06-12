package com.epam.preprod.hrabovska.web.servlet;

import com.epam.preprod.hrabovska.model.bean.LoginFormBean;
import com.epam.preprod.hrabovska.model.entity.User;
import com.epam.preprod.hrabovska.service.UserService;
import com.epam.preprod.hrabovska.util.validator.LoginFieldValidator;
import com.epam.preprod.hrabovska.web.Path;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

import static com.epam.preprod.hrabovska.model.constant.LoginFormBeanConstants.EMAIL;
import static com.epam.preprod.hrabovska.model.constant.LoginFormBeanConstants.PASSWORD;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(LoginServlet.class);

    private UserService userService;

    private final String WRONG_EMAIL_PASS = "wrong email or password";

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        ServletContext context = servletConfig.getServletContext();

        userService = (UserService) context.getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LOG.debug("LoginServlet starts");
        String forward = Path.LOGIN_PAGE;
        RequestDispatcher rd = request.getRequestDispatcher(forward);
        LOG.trace("Forward to : " + forward);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LOG.debug("LoginServlet starts");

        HttpSession session = request.getSession();
        session.removeAttribute("errors");

        LoginFormBean form = getLoginFormFromRequest(request);
        LOG.trace("Form bean: " + form.toString());
        Map<String, String> errors = validateForm(form);

        if (errors.isEmpty()) {
            User user = userService.login(form.getEmail(), form.getPassword());
            if (user != null) {
                user.setPassword(null);
                session.setAttribute("user", user);
                response.sendRedirect(Path.PERSONAL_AREA_PAGE);
                return;
            } else {
                errors.put("account", WRONG_EMAIL_PASS);
            }
        }
        setErrorsToSession(errors, session);
        response.sendRedirect(Path.LOGIN_SERVLET);
        LOG.trace("Redirect to : " + Path.LOGIN_SERVLET);
    }

    private LoginFormBean getLoginFormFromRequest(HttpServletRequest request) {
        LoginFormBean form = new LoginFormBean();
        form.setEmail(request.getParameter(EMAIL));
        form.setPassword(request.getParameter(PASSWORD));

        return form;
    }

    private Map<String, String> validateForm(LoginFormBean form) {
        return new LoginFieldValidator(form).validate();
    }

    private void setErrorsToSession(Map<String, String> errors, HttpSession session) {
        session.setAttribute("errors", errors);
        LOG.trace("Form fields are not valid. Errors: " + errors);
    }

}
