package com.epam.preprod.hrabovska.dao.impl;

import com.epam.preprod.hrabovska.dao.ProductDAO;
import com.epam.preprod.hrabovska.model.bean.FilterBean;
import com.epam.preprod.hrabovska.model.entity.Product;
import com.epam.preprod.hrabovska.util.builder.SQLRequestBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.epam.preprod.hrabovska.dao.DBField.*;

/**
 * ProductDAOImpl implements ProductDAO
 */
public class ProductDAOImpl implements ProductDAO {

    @Override
    public List<Product> getFilteredProductList(FilterBean filter, Connection connection) throws SQLException {
        SQLRequestBuilder builder = new SQLRequestBuilder(
                "id, name, price, category_id, brand_id, image_path", "products");
        fillBuilderFromFilter(builder, filter);
        fillOrderAndLimitFromFilter(builder, filter);
        PreparedStatement preparedStatement = connection.prepareStatement(builder.toString());
        fillStatementFromFilter(preparedStatement, builder.getParameters());
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Product> products = new ArrayList<>();
        while (resultSet.next()) {
            products.add(dispatchProduct(resultSet));
        }

        resultSet.close();
        return products;
    }

    @Override
    public int getCountOfProducts(FilterBean filter, Connection connection) throws SQLException {
        int total = 0;
        SQLRequestBuilder builder = new SQLRequestBuilder("count(*) as total", "products");
        fillBuilderFromFilter(builder, filter);
        PreparedStatement preparedStatement = connection.prepareStatement(builder.toString());
        fillStatementFromFilter(preparedStatement, builder.getParameters());

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            total = resultSet.getInt(PRODUCT_TOTAL);
        }
        resultSet.close();
        return total;

    }

    @Override
    public Product getProductById(String id, Connection connection) throws SQLException {
        SQLRequestBuilder builder = new SQLRequestBuilder("*", "products");
        builder.addEquals(ID, id);
        PreparedStatement preparedStatement = connection.prepareStatement(builder.toString());
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Product product = null;
        if (resultSet.next()) {
            product = dispatchProduct(resultSet);
        }
        resultSet.close();
        return product;
    }

    private void fillBuilderFromFilter(SQLRequestBuilder builder, FilterBean filterBean) {
        builder.addLike(NAME, filterBean.getName());
        builder.addIn(CATEGORY_ID, filterBean.getCategory());
        builder.addIn(BRAND_ID, filterBean.getBrands());
        builder.addOver(PRICE, filterBean.getPriceFrom());
        builder.addLess(PRICE, filterBean.getPriceTo());
    }

    private void fillOrderAndLimitFromFilter(SQLRequestBuilder builder, FilterBean filterBean) {
        builder.addOrder(filterBean.getSort(), filterBean.getSortType());
        builder.addLimit(filterBean.getPage(), filterBean.getLimit());
    }

    private void fillStatementFromFilter(PreparedStatement preparedStatement, List<Object> parameters) throws SQLException {
        int index = 1;
        for (Object param : parameters) {
            preparedStatement.setObject(index, param);
            index++;
        }
    }

    private Product dispatchProduct(ResultSet resultSet) throws SQLException {
        Product product = new Product();

        product.setId(resultSet.getLong(ID));
        product.setName(resultSet.getString(NAME));
        product.setPrice(resultSet.getDouble(PRICE));
        product.setCategoryId(resultSet.getLong(CATEGORY_ID));
        product.setBrand(resultSet.getLong(BRAND_ID));
        product.setImage(resultSet.getString(IMAGE_PATH));

        return product;
    }
}
