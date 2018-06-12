package com.epam.preprod.hrabovska.service.impl;

import com.epam.preprod.hrabovska.dao.UserDAO;
import com.epam.preprod.hrabovska.model.entity.User;
import com.epam.preprod.hrabovska.service.UserService;
import com.epam.preprod.hrabovska.service.transaction.TransactionManager;

import java.util.Objects;

/**
 * UserServiceImpl implements UserService
 */
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;
    private TransactionManager transactionManager;

    public UserServiceImpl(UserDAO userDAO, TransactionManager transactionManager) {
        this.userDAO = userDAO;
        this.transactionManager = transactionManager;
    }

    @Override
    public boolean insertUser(User user) {
        return transactionManager.<Boolean>execute(connection -> {
            boolean res;
            if (userDAO.getUserByEmail(user.getEmail(), connection) != null) {
                return false;
            }
            res = userDAO.insertUser(user, connection);
            return res;
        });
    }

    @Override
    public User login(final String email, final String password) {
        return transactionManager.execute(connection -> {
            User user = userDAO.getUserByEmail(email, connection);

            if (user == null) {
                return null;
            }
            if (!Objects.equals(user.getPassword(), password)) {
                return null;
            }

            return user;
        });
    }
}
