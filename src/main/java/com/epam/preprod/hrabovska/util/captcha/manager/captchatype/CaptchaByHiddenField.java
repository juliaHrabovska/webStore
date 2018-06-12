package com.epam.preprod.hrabovska.util.captcha.manager.captchatype;

import com.epam.preprod.hrabovska.util.captcha.manager.CaptchaManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CaptchaByHiddenField implements CaptchaManager {

    public void setKey(HttpServletRequest request, HttpServletResponse response, String key) {
        request.setAttribute("captchaKey", key);
    }

    public String getKey(HttpServletRequest request, HttpServletResponse response) {
        return request.getParameter("captchaKey");
    }
}
