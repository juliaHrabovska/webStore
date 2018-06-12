package com.epam.preprod.hrabovska.service.impl;

import com.epam.preprod.hrabovska.model.entity.User;
import com.epam.preprod.hrabovska.service.SecurityService;

import java.util.List;
import java.util.Map;

import static com.epam.preprod.hrabovska.util.security.SecurityCommandContainer.*;

public class SecurityServiceImpl implements SecurityService {

    private Map<String, List<String>> rules;

    public SecurityServiceImpl(Map<String, List<String>> rules) {
        this.rules = rules;
    }

    @Override
    public String checkAccess(String url, User user) {
        if (rules.containsKey(url)) {
            if (user == null) {
                return REDIRECT;
            }
            List<String> roles = rules.get(url);
            String userRole = String.valueOf(user.getRoleId());
            if (!roles.contains(userRole)) {
                return ERROR;
            }
        }
        return OK;
    }
}
