package com.epam.preprod.hrabovska.dao;

import com.epam.preprod.hrabovska.model.entity.Order;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * OrderDAO interface
 */
public interface OrderDAO {
    boolean createOrder(Order order, Connection connection) throws SQLException;
}
