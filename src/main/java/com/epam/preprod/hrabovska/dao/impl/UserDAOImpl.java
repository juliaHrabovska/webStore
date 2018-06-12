package com.epam.preprod.hrabovska.dao.impl;

import com.epam.preprod.hrabovska.dao.DBField;
import com.epam.preprod.hrabovska.dao.UserDAO;
import com.epam.preprod.hrabovska.exception.DBException;
import com.epam.preprod.hrabovska.model.entity.User;

import java.sql.*;
import java.text.ParseException;

/**
 * UserDAO implements UserDAO
 */
public class UserDAOImpl implements UserDAO {

    private final String INSERT_USER = "INSERT INTO `users` (first_name, second_name, email, password, desired_list, image_path, role_id) VALUES (?, ?, ?, ?, ?, ?, ?);";
    private final String GET_USER_BY_EMAIL = "SELECT * FROM `users` where email=?;";

    @Override
    public boolean insertUser(User user, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, user.getFirstName());
        preparedStatement.setString(2, user.getSecondName());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getPassword());
        preparedStatement.setBoolean(5, user.getDesiredList());
        preparedStatement.setString(6, user.getImagePath());
        preparedStatement.setLong(7, user.getRoleId());

        if (preparedStatement.executeUpdate() > 0) {
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getLong(1));
                resultSet.close();
                return true;
            }
            resultSet.close();
        }
        return false;
    }

    @Override
    public User getUserByEmail(String email, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_EMAIL, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, email);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            User user;
            try {
                user = dispatchUser(rs);
            } catch (ParseException e) {
                throw new DBException();
            }
            rs.close();
            return user;
        }
        return null;
    }

    private User dispatchUser(ResultSet resultSet) throws SQLException, ParseException {
        User user = new User();

        user.setId(resultSet.getLong(DBField.ID));
        user.setFirstName(resultSet.getString(DBField.FIRST_NAME));
        user.setSecondName(resultSet.getString(DBField.SECOND_NAME));
        user.setEmail(resultSet.getString(DBField.EMAIL));
        user.setPassword(resultSet.getString(DBField.PASSWORD));
        user.setImagePath(resultSet.getString(DBField.IMAGE_PATH));

        return user;
    }
}
