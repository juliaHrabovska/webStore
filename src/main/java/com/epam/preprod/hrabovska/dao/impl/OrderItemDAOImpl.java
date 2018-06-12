package com.epam.preprod.hrabovska.dao.impl;

import com.epam.preprod.hrabovska.dao.OrderItemDAO;
import com.epam.preprod.hrabovska.model.entity.OrderItem;

import java.sql.*;

/**
 * OrderItemDAOImpl implements OrderItemDAO
 */
public class OrderItemDAOImpl implements OrderItemDAO {

    private final String CREATE_ORDER_ITEM = "INSERT INTO `order_item` (`product_id`, `quantity`, `price`, `order_id`) VALUES (?, ?, ?, ?)";

    @Override
    public boolean createOrderItem(OrderItem item, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(CREATE_ORDER_ITEM, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setLong(1, item.getProductId());
        preparedStatement.setInt(2, item.getQuantity());
        preparedStatement.setBigDecimal(3, item.getPrice());
        preparedStatement.setLong(4, item.getOrderId());

        if (preparedStatement.executeUpdate() > 0) {
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                item.setId(resultSet.getLong(1));
                resultSet.close();
                return true;
            }
            resultSet.close();
        }
        return false;
    }
}
