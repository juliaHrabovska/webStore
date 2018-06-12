package com.epam.preprod.hrabovska.dao;

import com.epam.preprod.hrabovska.model.bean.FilterBean;
import com.epam.preprod.hrabovska.model.entity.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * ProductDAO interface
 */
public interface ProductDAO {

    /**
     * Get filtered products
     *
     * @param filter - filter
     * @param connection - connection to database
     * @return - Product objects
     * @throws SQLException - if no connection to database or another exceptions with database
     */
    List<Product> getFilteredProductList(FilterBean filter, Connection connection) throws SQLException;

    /**
     * Get count of products
     *
     * @param filter - filter
     * @param connection - connection to database
     * @return - count of products
     * @throws SQLException - if no connection to database or another exceptions with database
     */
    int getCountOfProducts(FilterBean filter, Connection connection) throws SQLException;


    Product getProductById(String id, Connection connection) throws SQLException;
}
