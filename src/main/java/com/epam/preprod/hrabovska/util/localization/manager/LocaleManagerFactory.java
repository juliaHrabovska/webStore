package com.epam.preprod.hrabovska.util.localization.manager;

import com.epam.preprod.hrabovska.util.localization.manager.localetype.LocaleByCookie;
import com.epam.preprod.hrabovska.util.localization.manager.localetype.LocaleBySession;

import java.util.HashMap;
import java.util.Map;

public class LocaleManagerFactory {
    private Map<String, LocaleManager> managers;

    public LocaleManagerFactory() {
        managers = new HashMap<>();
        managers.put("session", new LocaleBySession());
        managers.put("cookie", new LocaleByCookie());
    }

    public LocaleManager getLocaleManager(String param) {
        return managers.get(param);
    }

}
