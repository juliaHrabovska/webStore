package com.epam.preprod.hrabovska.dao;

import com.epam.preprod.hrabovska.model.entity.Brand;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


/**
 * BrandDAO interface
 */
public interface BrandDAO {

    /**
     * Get all brands
     *
     * @param connection - database connection
     * @return - brands from database
     * @throws SQLException - if no connection to database or another exceptions with database
     */
    List<Brand> getAllBrands(Connection connection) throws SQLException;
}
