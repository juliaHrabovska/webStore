package com.epam.preprod.hrabovska.util.cart;

import com.epam.preprod.hrabovska.model.bean.CartBean;
import com.epam.preprod.hrabovska.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CartCommand {
    private static final String PRODUCT_ID = "productId";
    private static final String QUANTITY = "quantity";
    private static final String RESPONSE_PRODUCT_QUANTITY = "productQuantity";
    private static final String RESPONSE_PRODUCT_TOTAL = "productTotal";
    private static final String RESPONSE_TOTAL = "total";
    private static final String RESPONSE_COUNT = "count";
    private static final String REMOVE_COMMAND = "remove";
    private static final String UPDATE_COMMAND = "update";
    private static final String ADD_COMMAND = "add";
    private Map<String, Command> commands;

    public CartCommand(ProductService productService) {
        commands = new HashMap<>();
        commands.put(ADD_COMMAND, new Command() {

            @Override
            public JSONObject updateCart(HttpServletRequest request, CartBean cart) {
                String id = request.getParameter(PRODUCT_ID);
                cart.addProduct(productService.getProductById(id));
                JSONObject answer = new JSONObject();
                answer.put(RESPONSE_TOTAL, "$" + String.valueOf(cart.getTotal()));

                return answer;
            }
        });
        commands.put(UPDATE_COMMAND, new Command() {

            @Override
            public JSONObject updateCart(HttpServletRequest request, CartBean cart) {
                String id = request.getParameter(PRODUCT_ID);
                String quantity = request.getParameter(QUANTITY);
                JSONObject answer = new JSONObject();

                if (StringUtils.isNotBlank(id) && StringUtils.isNotBlank(quantity)) {
                    cart.updateProductCount(id, Integer.parseInt(quantity));
                }
                answer.put(RESPONSE_COUNT, cart.getTotalCountOfProducts());
                answer.put(RESPONSE_TOTAL, cart.getTotal());
                answer.put(RESPONSE_PRODUCT_TOTAL, cart.getTotalOfProductById(id));
                answer.put(RESPONSE_PRODUCT_QUANTITY, cart.getTotalCountOfProductById(id));

                return answer;
            }
        });
        commands.put(REMOVE_COMMAND, new Command() {

            @Override
            public JSONObject updateCart(HttpServletRequest request, CartBean cart) {
                String id = request.getParameter(PRODUCT_ID);
                JSONObject answer = new JSONObject();

                if (StringUtils.isNotBlank(id)) {
                    cart.removeProduct(id);
                }
                answer.put(RESPONSE_COUNT, cart.getTotalCountOfProducts());
                return answer;
            }
        });
    }

    public Command getAction(String key) {
        return commands.get(key);
    }

}
