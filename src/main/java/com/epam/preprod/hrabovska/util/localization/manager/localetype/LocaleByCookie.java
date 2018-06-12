package com.epam.preprod.hrabovska.util.localization.manager.localetype;

import com.epam.preprod.hrabovska.util.localization.manager.LocaleManager;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class LocaleByCookie implements LocaleManager {

    @Override
    public String getLocale(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("locale")) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        Integer magAge = (Integer) request.getServletContext().getAttribute("cookieMaxAge");
        Cookie cookie = new Cookie("locale", locale.getLanguage());
        cookie.setPath("/");
        cookie.setMaxAge(magAge);
        response.addCookie(cookie);
    }

}
