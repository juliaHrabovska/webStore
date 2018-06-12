package com.epam.preprod.hrabovska.dao.impl;

import com.epam.preprod.hrabovska.dao.BrandDAO;
import com.epam.preprod.hrabovska.model.entity.Brand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.epam.preprod.hrabovska.dao.DBField.ID;
import static com.epam.preprod.hrabovska.dao.DBField.NAME;

/**
 * BrandDAOImpl implements BrandDAO
 */
public class BrandDAOImpl implements BrandDAO {

    private final String GET_ALL_BRANDS = "SELECT * FROM `brand`;";

    @Override
    public List<Brand> getAllBrands(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_BRANDS);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Brand> list = new ArrayList<>();
        while (resultSet.next()) {
            Brand manufacturer = new Brand();
            manufacturer.setId(resultSet.getLong(ID));
            manufacturer.setName(resultSet.getString(NAME));
            list.add(manufacturer);
        }
        resultSet.close();
        return list;
    }
}
