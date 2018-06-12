package com.epam.preprod.hrabovska.service;

import com.epam.preprod.hrabovska.model.bean.FilterBean;
import com.epam.preprod.hrabovska.model.bean.ProductsPageBean;
import com.epam.preprod.hrabovska.model.entity.Product;

public interface ProductService {

    ProductsPageBean doFilter(FilterBean filter);

    Product getProductById(String id);
}
