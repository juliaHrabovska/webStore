package com.epam.preprod.hrabovska.dao.impl;

import com.epam.preprod.hrabovska.dao.OrderDAO;
import com.epam.preprod.hrabovska.model.entity.Order;
import com.epam.preprod.hrabovska.util.db.DBUtil;

import java.sql.*;

/**
 * OrderDAOImpl implements OrderDAO
 */
public class OrderDAOImpl implements OrderDAO {

    private final String CREATE_NEW_ORDER = "INSERT INTO `orders` (`date`, `user_id`, `address`, `payment_method`) VALUES (?, ?, ?, ?)";

    @Override
    public boolean createOrder(Order order, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(CREATE_NEW_ORDER, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, DBUtil.dateToString(order.getDate()));
        preparedStatement.setLong(2, order.getUserId());
        preparedStatement.setString(3, order.getAddress());
        preparedStatement.setString(4, order.getPaymentMethod());

        if (preparedStatement.executeUpdate() > 0) {
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                order.setId(resultSet.getLong(1));
                resultSet.close();
                return true;
            }
            resultSet.close();
        }
        return false;
    }
}
