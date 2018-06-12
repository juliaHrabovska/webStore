package com.epam.preprod.hrabovska.model.bean;

import com.epam.preprod.hrabovska.model.constant.Sorts;
import com.epam.preprod.hrabovska.model.entity.Brand;
import com.epam.preprod.hrabovska.model.entity.Category;
import com.epam.preprod.hrabovska.model.entity.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ProductsPageBean class
 */
public class ProductsPageBean {
    private List<Product> products;
    private int totalCountOfProducts;
    private Map<String, String> pagination;
    private Map<Integer, String> limits;
    private List<Category> categories;
    private List<Brand> brands;
    private Map<Sorts, String> sorts;

    public ProductsPageBean() {
        products = new ArrayList<>();
        totalCountOfProducts = 0;
        pagination = new HashMap<>();
        limits = new HashMap<>();
        sorts = new HashMap<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getCountOfProducts() {
        return totalCountOfProducts;
    }

    public void setCountOfProducts(int totalCountOfProducts) {
        this.totalCountOfProducts = totalCountOfProducts;
    }

    public Map<String, String> getPagination() {
        return pagination;
    }

    public void setPagination(Map<String, String> pagination) {
        this.pagination = pagination;
    }

    public Map<Integer, String> getLimits() {
        return limits;
    }

    public void setLimits(Map<Integer, String> limits) {
        this.limits = limits;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }

    public Map<Sorts, String> getSorts() {
        return sorts;
    }

    public void setSorts(Map<Sorts, String> sorts) {
        this.sorts = sorts;
    }

    @Override
    public String toString() {
        return "ProductsPageBean{" +
                "products=" + products +
                ", totalCountOfProducts=" + totalCountOfProducts +
                ", pagination=" + pagination +
                ", limits=" + limits +
                ", categories=" + categories +
                ", brands=" + brands +
                ", sorts=" + sorts +
                '}';
    }
}
