package com.epam.preprod.hrabovska.util.captcha.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Captcha's data
 */
public interface CaptchaManager {

    String getKey(HttpServletRequest request, HttpServletResponse response);

    void setKey(HttpServletRequest request, HttpServletResponse response, String key);
}
