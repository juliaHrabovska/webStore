package com.epam.preprod.hrabovska.dao;

import com.epam.preprod.hrabovska.model.entity.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

/**
 * Interface DAO to work with a user
 */
public interface UserDAO {

    /**
     * Insert new user in storage
     *
     * @param user to insert
     * @param connection - connection to db
     * @return true - if user was inserted. false - otherwise
     */
    boolean insertUser(User user, Connection connection) throws SQLException;

    /**
     * Insert new user in storage
     *
     * @param email to check
     * @param connection - connection to db
     * @return User object
     */
    User getUserByEmail(String email, Connection connection) throws SQLException;
}
