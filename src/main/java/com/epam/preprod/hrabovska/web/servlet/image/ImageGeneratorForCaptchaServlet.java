package com.epam.preprod.hrabovska.web.servlet.image;

import com.epam.preprod.hrabovska.util.captcha.CaptchaUtil;
import com.epam.preprod.hrabovska.util.captcha.manager.CaptchaManager;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Generate image for captcha
 */
@WebServlet(name = "ImageGeneratorForCaptchaServlet", urlPatterns = "/captcha")
public class ImageGeneratorForCaptchaServlet extends HttpServlet {

    private CaptchaUtil captchaUtil;
    private CaptchaManager captchaManager;

    public void init(ServletConfig servletConfig) throws ServletException {
        ServletContext context = servletConfig.getServletContext();

        captchaUtil = (CaptchaUtil) context.getAttribute("captchaUtil");
        captchaManager = (CaptchaManager) context.getAttribute("captchaManager");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("errors");
        session.removeAttribute("registerForm");

        CaptchaUtil.CaptchaCreator userCaptcha = captchaUtil.getCaptcha(captchaManager.getKey(request, response));
        response.setContentType("image/jpeg");
        if (userCaptcha != null) {
            userCaptcha.createCaptchaImage(response.getOutputStream());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
