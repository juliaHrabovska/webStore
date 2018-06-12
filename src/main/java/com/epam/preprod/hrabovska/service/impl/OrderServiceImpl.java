package com.epam.preprod.hrabovska.service.impl;

import com.epam.preprod.hrabovska.dao.OrderDAO;
import com.epam.preprod.hrabovska.dao.OrderItemDAO;
import com.epam.preprod.hrabovska.model.entity.Order;
import com.epam.preprod.hrabovska.model.entity.OrderItem;
import com.epam.preprod.hrabovska.service.OrderService;
import com.epam.preprod.hrabovska.service.transaction.TransactionManager;

/**
 * OrderServiceImpl implements OrderService
 */
public class OrderServiceImpl implements OrderService {
    private TransactionManager transactionManager;
    private OrderDAO orderDAO;
    private OrderItemDAO orderItemDAO;

    public OrderServiceImpl(TransactionManager transactionManager, OrderDAO orderDAO, OrderItemDAO orderItemDAO) {
        this.transactionManager = transactionManager;
        this.orderDAO = orderDAO;
        this.orderItemDAO = orderItemDAO;
    }

    public boolean createOrder(final Order order) {
        return transactionManager.<Boolean> execute(connection -> {
            boolean res = false;

            if (orderDAO.createOrder(order, connection)) {
                for (OrderItem item : order.getItems()) {
                    item.setOrderId(order.getId());
                    if (!orderItemDAO.createOrderItem(item, connection)) {
                        return false;
                    }
                }
                res = true;
            }
            return res;
        });
    }

}
