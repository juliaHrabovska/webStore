package com.epam.preprod.hrabovska.dao.impl;

import com.epam.preprod.hrabovska.dao.CategoryDAO;
import com.epam.preprod.hrabovska.model.entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.epam.preprod.hrabovska.dao.DBField.ID;
import static com.epam.preprod.hrabovska.dao.DBField.NAME;

/**
 * CategoryDAOImpl implements CategoryDAO
 */
public class CategoryDAOImpl implements CategoryDAO {

    private final String GET_ALL_CATEGORIES = "SELECT * FROM `category`;";

    @Override
    public List<Category> getAllCategories(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CATEGORIES);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Category> list = new ArrayList<>();
        while (resultSet.next()) {
            Category category = new Category();
            category.setId(resultSet.getLong(ID));
            category.setName(resultSet.getString(NAME));
            list.add(category);
        }
        resultSet.close();
        return list;
    }
}
