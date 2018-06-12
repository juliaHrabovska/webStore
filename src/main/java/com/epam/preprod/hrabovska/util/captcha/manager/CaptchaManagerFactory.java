package com.epam.preprod.hrabovska.util.captcha.manager;

import com.epam.preprod.hrabovska.util.captcha.manager.captchatype.CaptchaByCookie;
import com.epam.preprod.hrabovska.util.captcha.manager.captchatype.CaptchaByHiddenField;
import com.epam.preprod.hrabovska.util.captcha.manager.captchatype.CaptchaBySession;

import java.util.HashMap;
import java.util.Map;

/**
 * Types of storage captcha's data
 */
public class CaptchaManagerFactory {

    private Map<String, CaptchaManager> managers;

    public CaptchaManagerFactory() {
        managers = new HashMap<>();
        managers.put("hidden", new CaptchaByHiddenField());
        managers.put("session", new CaptchaBySession());
        managers.put("cookie", new CaptchaByCookie());
    }

    public CaptchaManager getCaptchaManger(String param) {
        return managers.get(param);
    }
}
