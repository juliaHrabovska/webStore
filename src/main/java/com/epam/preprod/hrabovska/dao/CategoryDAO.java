package com.epam.preprod.hrabovska.dao;

import com.epam.preprod.hrabovska.model.entity.Category;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * CategoryDAO interface
 */
public interface CategoryDAO {
    List<Category> getAllCategories(Connection connection) throws SQLException;
}
