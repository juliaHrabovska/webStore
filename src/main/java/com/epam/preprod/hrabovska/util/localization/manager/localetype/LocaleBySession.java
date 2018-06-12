package com.epam.preprod.hrabovska.util.localization.manager.localetype;

import com.epam.preprod.hrabovska.util.localization.manager.LocaleManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;

public class LocaleBySession implements LocaleManager {

    @Override
    public String getLocale(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (String) session.getAttribute("locale");
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        HttpSession session = request.getSession();
        session.setAttribute("locale", locale.getLanguage());
    }

}
