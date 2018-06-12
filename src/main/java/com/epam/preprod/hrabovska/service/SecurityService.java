package com.epam.preprod.hrabovska.service;

import com.epam.preprod.hrabovska.model.entity.User;

public interface SecurityService {

    String checkAccess(String url, User user);

}
