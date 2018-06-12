package com.epam.preprod.hrabovska.service;

import com.epam.preprod.hrabovska.model.entity.User;
import com.epam.preprod.hrabovska.exception.DBException;

/**
 * User service to work with users
 */
public interface UserService {
    /**
     * Insert new user in db
     *
     * @param user - user to inserting
     * @return
     */
    boolean insertUser(User user) throws DBException;

    User login(String email, String password);
}
