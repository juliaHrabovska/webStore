package com.epam.preprod.hrabovska.dao;

import com.epam.preprod.hrabovska.model.entity.OrderItem;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * OrderItemDAO interface
 */
public interface OrderItemDAO {

    boolean createOrderItem(OrderItem item, Connection connection) throws SQLException;
}
