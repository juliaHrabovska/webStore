package com.epam.preprod.hrabovska.model.bean;

import com.epam.preprod.hrabovska.model.entity.Product;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Cart of products
 */
public class CartBean {
    private Map<Product, Integer> products;

    public CartBean() {
        products = new HashMap<>();
    }

    public void addProduct(Product product) {
        Integer count = products.get(product);
        if (count == null) {
            count = 0;
        }
        products.put(product, count + 1);
    }

    public void updateProductCount(String id, Integer quantity) {
        products.put(getProductById(id), quantity);
    }

    public void removeProduct(String id) {
        products.remove(getProductById(id));
    }

    public Set<Product> getProductSet() {
        return products.keySet();
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public Integer getTotalCountOfProducts() {
        int count = 0;
        for (Integer itemCount : products.values()) {
            count += itemCount;
        }
        return count;
    }

    public Integer getTotalCountOfProductById(String id) {
        Product product = getProductById(id);
        if (product != null) {
            return products.get(product);
        }
        return 0;
    }

    public double getTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> item : products.entrySet()) {
            double count = item.getValue();
            total = total + item.getKey().getPrice() * count;
        }
        return total;
    }

    public double getTotalOfProductById(String id) {
        double total;
        Product product = getProductById(id);
        double count = products.get(product);
        total = product.getPrice() * count;
        return total;
    }

    public static CartBean getInstance(HttpSession session) {
        CartBean cart = (CartBean) session.getAttribute("cart");
        if (cart == null) {
            cart = new CartBean();
            session.setAttribute("cart", cart);
        }
        return cart;
    }

    private Product getProductById(String id) {
        if (StringUtils.isNotBlank(id)) {
            int productId = Integer.parseInt(id);
            for (Product product : products.keySet()) {
                if (product.getId() == productId) {
                    return product;
                }
            }
        }
        return null;
    }
}
