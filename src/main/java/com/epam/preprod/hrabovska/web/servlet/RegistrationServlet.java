package com.epam.preprod.hrabovska.web.servlet;

import com.epam.preprod.hrabovska.model.bean.RegistrationFormBean;
import com.epam.preprod.hrabovska.model.entity.User;
import com.epam.preprod.hrabovska.service.UserService;
import com.epam.preprod.hrabovska.util.captcha.CaptchaUtil;
import com.epam.preprod.hrabovska.util.captcha.manager.CaptchaManager;
import com.epam.preprod.hrabovska.util.handler.ImageHandler;
import com.epam.preprod.hrabovska.util.validator.RegistrationFieldValidator;
import com.epam.preprod.hrabovska.web.Path;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

import static com.epam.preprod.hrabovska.model.constant.RegistrationFormBeanConstants.*;
import static com.epam.preprod.hrabovska.util.validator.Message.ACCOUNT_EXISTS;
import static com.epam.preprod.hrabovska.util.validator.Message.WRONG_CAPTCHA;
import static com.epam.preprod.hrabovska.web.Path.PERSONAL_AREA_PAGE;
import static com.epam.preprod.hrabovska.web.Path.REGISTER_SERVLET;

/**
 * Registration action
 */
@WebServlet(name = "RegistrationServlet", urlPatterns = "/registration")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
public class RegistrationServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(RegistrationServlet.class);

    private CaptchaUtil captchaUtil;
    private CaptchaManager captchaManager;
    private ImageHandler imageHandler;

    private UserService userService;

    @Override
    public void init(ServletConfig servletConfig) {
        LOG.trace("Registration servlet start");
        ServletContext context = servletConfig.getServletContext();

        captchaUtil = (CaptchaUtil) context.getAttribute("captchaUtil");
        userService = (UserService) context.getAttribute("userService");
        captchaManager = (CaptchaManager) context.getAttribute("captchaManager");

        String uploadPath = (String) context.getAttribute("ImagePath");
        imageHandler = new ImageHandler(uploadPath);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String captchaKey = captchaUtil.generateCaptcha();
        LOG.info("New captcha key: " + captchaKey);
        captchaManager.setKey(request, response, captchaKey);

        String forward = Path.REGISTRATION_PAGE;
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(forward);
        LOG.trace("Forward to : " + forward);
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LOG.trace("Registration servlet start");

        HttpSession session = request.getSession();
        removeOldDataFromSession(session);

        RegistrationFormBean form = getRegistrationFormFromRequest(request);
        LOG.trace("Form bean: " + form.toString());
        Map<String, String> errors = validateForm(form);

        if (!validateCapthca(captchaManager.getKey(request, response), form.getCaptcha())) {
            errors.put("captcha", WRONG_CAPTCHA);
        }

        form.setImagePath(imageHandler.loadImage(request, form.getEmail()));

        if (errors.isEmpty()) {
            User user = beanToEntity(form);
            user.setRoleId(0);
            if (userService.insertUser(user)) {
                LOG.trace("Form fields are valid. Forward to: " + PERSONAL_AREA_PAGE);
                createUserSession(user, session);
                response.sendRedirect(PERSONAL_AREA_PAGE);
                return;
            } else {
                errors.put("email", ACCOUNT_EXISTS);
            }
        }

        imageHandler.removeImage(form.getImagePath());
        setErrorsToSession(errors, form, session);
        LOG.trace("Redirect to: " + REGISTER_SERVLET);
        response.sendRedirect(REGISTER_SERVLET);
    }

    private void removeOldDataFromSession(HttpSession session) {
        session.removeAttribute("errors");
        session.removeAttribute("registerForm");
    }

    private RegistrationFormBean getRegistrationFormFromRequest(HttpServletRequest request) {
        RegistrationFormBean form = new RegistrationFormBean();
        form.setFirstName(request.getParameter(FIRST_NAME));
        form.setSecondName(request.getParameter(SECOND_NAME));
        form.setEmail(request.getParameter(EMAIL));
        form.setPassword(request.getParameter(PASSWORD));
        form.setConfirmPassword(request.getParameter(CONFIRM_PASSWORD));
        form.setDesiredList(request.getParameter(DESIRED_LIST) != null);
        form.setCaptcha(request.getParameter(CAPTCHA));
        return form;
    }

    private Map<String, String> validateForm(RegistrationFormBean form) {
        return new RegistrationFieldValidator(form).validate();
    }

    private User beanToEntity(RegistrationFormBean form) {
        User user = new User();

        user.setFirstName(form.getFirstName());
        user.setSecondName(form.getSecondName());
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());
        user.setDesiredList(form.getDesiredList());
        user.setImagePath(form.getImagePath());

        return user;
    }

    private boolean validateCapthca(String key, String captchaValue) {
        if (key.isEmpty() || captchaValue.isEmpty()) {
            return false;
        }

        CaptchaUtil.CaptchaCreator captchaCreator = captchaUtil.getCaptcha(key);
        if (captchaCreator != null) {
            String expected = String.valueOf(captchaCreator.getValue());
            if (expected.compareTo(captchaValue) != 0 && captchaCreator.isAlive()) {
                captchaCreator.invalidateCaptcha();
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    private void createUserSession(User user, HttpSession session) {
        session.setAttribute("user", user);
        LOG.trace("Create user session for : " + user);

    }

    private void setErrorsToSession(Map<String, String> errors, RegistrationFormBean form, HttpSession session) {
        session.setAttribute("errors", errors);
        session.setAttribute("registerForm", form);

        LOG.trace("Form fields are not valid. Errors: " + errors);
    }

}
