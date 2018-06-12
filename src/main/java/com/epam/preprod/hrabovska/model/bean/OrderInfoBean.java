package com.epam.preprod.hrabovska.model.bean;

import com.epam.preprod.hrabovska.model.entity.OrderItem;

import java.util.List;

public class OrderInfoBean {

    private List<OrderItem> items;
    private String address;
    private String paymentMethod;

    public OrderInfoBean(List<OrderItem> items, String address, String paymentMethod) {
        this.items = items;
        this.address = address;
        this.paymentMethod = paymentMethod;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public String getAddress() {
        return address;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}
