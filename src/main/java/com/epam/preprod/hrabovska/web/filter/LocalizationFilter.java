package com.epam.preprod.hrabovska.web.filter;

import com.epam.preprod.hrabovska.util.localization.manager.LocaleManager;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class LocalizationFilter implements Filter {

    public static final Locale DEFAULT_LOCALE = new Locale("en", "US");
    private static final Logger LOG = Logger.getLogger(LocalizationFilter.class);

    private Map<String, Locale> locales;
    private Map<String, String> localesForTag;
    private LocaleManager localeManager;

    public void init(FilterConfig filterConfig) throws ServletException {
        List<Locale> availableLocales = Arrays.asList(Locale.getAvailableLocales());
        localeManager = (LocaleManager) filterConfig.getServletContext().getAttribute("localeManager");
        locales = new HashMap<>();
        localesForTag = new HashMap<>();

        Enumeration<String> iterator = filterConfig.getInitParameterNames();
        while (iterator.hasMoreElements()) {
            String paramName = iterator.nextElement();
            String paramValue = filterConfig.getInitParameter(paramName);
            Locale locale = new Locale(paramValue);
            if (availableLocales.contains(locale)) {
                locales.put(paramValue, locale);
                localesForTag.put(paramValue, paramName);
            }
        }
        LOG.info("Available locales: " + locales.toString());
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequestWrapper wrapper = getWrapper(req, res);

        req.setAttribute("localization", localesForTag);
        req.getSession().setAttribute("javax.servlet.jsp.jstl.fmt.locale.session", wrapper.getLocale());

        rewriteLocale(req, res);
        chain.doFilter(wrapper, response);
    }

    private HttpServletRequestWrapper getWrapper(HttpServletRequest request, HttpServletResponse response) {
        return new HttpServletRequestWrapper(request) {

            @Override
            public Locale getLocale() {
                if (request.getParameter("lang") != null) {
                    Locale locale = getLocaleFromAvailable(request.getParameter("lang"));
                    localeManager.setLocale(request, response, locale);
                    return locale;
                }
                String localeParam = localeManager.getLocale(request);
                Locale locale = getLocaleFromAvailable(localeParam);
                localeManager.setLocale(request, response, locale);
                return locale;
            }

            @Override
            public Enumeration<Locale> getLocales() {
                List<Locale> temp = new ArrayList<>();

                Enumeration<Locale> iterator = request.getLocales();
                while (iterator.hasMoreElements()) {
                    Locale locale = iterator.nextElement();
                    if (locales.containsValue(locale)) {
                        temp.add(locale);
                    }
                }
                return Collections.enumeration(temp);
            }

            private Locale getLocaleFromAvailable(String language) {
                if (locales.containsKey(language)) {
                    return locales.get(language);
                }
                Enumeration<Locale> iterator = request.getLocales();
                while (iterator.hasMoreElements()) {
                    Locale locale = iterator.nextElement();
                    if (locales.containsKey(locale.getLanguage())) {
                        return locale;
                    }
                }
                return DEFAULT_LOCALE;
            }

        };
    }

    private void rewriteLocale(HttpServletRequest request, HttpServletResponse response) {
        if (localeManager.getLocale(request) != null) {
            localeManager.setLocale(request, response, new Locale(localeManager.getLocale(request)));
        }
    }

    public void destroy() {
    }
}
