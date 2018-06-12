package com.epam.preprod.hrabovska.util.captcha.manager.captchatype;

import com.epam.preprod.hrabovska.util.captcha.manager.CaptchaManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CaptchaBySession implements CaptchaManager {

    public void setKey(HttpServletRequest request, HttpServletResponse response, String key) {
        HttpSession session = request.getSession();
        session.setAttribute("captchaKey", key);
    }

    public String getKey(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        return (String) session.getAttribute("captchaKey");
    }
}
