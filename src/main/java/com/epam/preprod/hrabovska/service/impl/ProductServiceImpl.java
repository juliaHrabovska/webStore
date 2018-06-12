package com.epam.preprod.hrabovska.service.impl;

import com.epam.preprod.hrabovska.dao.BrandDAO;
import com.epam.preprod.hrabovska.dao.CategoryDAO;
import com.epam.preprod.hrabovska.dao.ProductDAO;
import com.epam.preprod.hrabovska.model.bean.FilterBean;
import com.epam.preprod.hrabovska.model.bean.ProductsPageBean;
import com.epam.preprod.hrabovska.model.entity.Product;
import com.epam.preprod.hrabovska.service.ProductService;
import com.epam.preprod.hrabovska.service.transaction.TransactionManager;

/**
 * ProductServiceImpl implements ProductService
 */
public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO;
    private CategoryDAO categoryDAO;
    private BrandDAO brandDAO;
    private TransactionManager transactionManager;

    public ProductServiceImpl(ProductDAO productDAO, CategoryDAO categoryDAO, BrandDAO brandDAO,
                              TransactionManager transactionManager) {
        this.productDAO = productDAO;
        this.brandDAO = brandDAO;
        this.categoryDAO = categoryDAO;
        this.transactionManager = transactionManager;
    }

    @Override
    public ProductsPageBean doFilter(FilterBean filter) {
        return transactionManager.execute(connection -> {
            ProductsPageBean page = new ProductsPageBean();
            page.setProducts(productDAO.getFilteredProductList(filter, connection));
            page.setCountOfProducts(productDAO.getCountOfProducts(filter, connection));
            page.setBrands(brandDAO.getAllBrands(connection));
            page.setCategories(categoryDAO.getAllCategories(connection));
            return page;
        });
    }

    @Override
    public Product getProductById(String id) {
        return transactionManager.execute(connection -> productDAO.getProductById(id, connection));
    }
}
