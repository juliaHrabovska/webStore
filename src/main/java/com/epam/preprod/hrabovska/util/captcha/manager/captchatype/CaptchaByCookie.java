package com.epam.preprod.hrabovska.util.captcha.manager.captchatype;

import com.epam.preprod.hrabovska.util.captcha.manager.CaptchaManager;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CaptchaByCookie implements CaptchaManager {

    public void setKey(HttpServletRequest request, HttpServletResponse response, String key) {
        Cookie cookie = new Cookie("captchaKey", key);
        response.addCookie(cookie);
    }

    public String getKey(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().compareTo("captchaKey") == 0) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
