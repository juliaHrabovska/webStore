package com.epam.preprod.hrabovska.web.servlet;

import com.epam.preprod.hrabovska.model.bean.CartBean;
import com.epam.preprod.hrabovska.model.bean.OrderInfoBean;
import com.epam.preprod.hrabovska.model.entity.Order;
import com.epam.preprod.hrabovska.model.entity.OrderItem;
import com.epam.preprod.hrabovska.model.entity.Product;
import com.epam.preprod.hrabovska.model.entity.User;
import com.epam.preprod.hrabovska.service.OrderService;
import com.epam.preprod.hrabovska.web.Path;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

import static com.epam.preprod.hrabovska.web.RequestProperty.ADDRESS;
import static com.epam.preprod.hrabovska.web.RequestProperty.PAYMENT_METHOD;

@WebServlet(name = "MakeOrderServlet", urlPatterns = "/makeOrder")
public class MakeOrderServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(MakeOrderServlet.class);

    private OrderService orderService;

    public void init(ServletConfig servletConfig) throws ServletException {
        LOG.trace("MakeOrder servlet start");
        ServletContext context = servletConfig.getServletContext();
        orderService = (OrderService) context.getAttribute("orderService");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String forward = Path.MAKE_ORDER_PAGE;
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(forward);
        LOG.trace("Forward to : " + forward);
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        CartBean cartBean = (CartBean) session.getAttribute("cart");

        String address = request.getParameter(ADDRESS);
        String paymentMethod = request.getParameter(PAYMENT_METHOD);

        OrderInfoBean orderInfoBean = new OrderInfoBean(getListItems(cartBean), address, paymentMethod);
        Order order = getOrderFromBean(orderInfoBean, user);

        if (orderService.createOrder(order)) {
            session.removeAttribute("cart");
            LOG.trace("New order successful created! Forward to: " + Path.SUCCESS_ORDER_SERVLET);
            session.setAttribute("createdOrderId", String.valueOf(order.getId()));
            response.sendRedirect(Path.SUCCESS_ORDER_SERVLET);
            return;
        }

        LOG.trace("Order creation error! Redirect to: " + Path.ERROR_PAGE);
        response.sendRedirect(Path.ERROR_PAGE);
    }

    private Order getOrderFromBean(OrderInfoBean orderInfoBean, User user) {
        Order order = new Order();

        order.setUserId(user.getId());
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        order.setDate(currentDate);
        order.setItems(orderInfoBean.getItems());
        order.setAddress(orderInfoBean.getAddress());
        order.setPaymentMethod(orderInfoBean.getPaymentMethod());

        return order;
    }

    private List<OrderItem> getListItems(CartBean cartBean) {
        List<OrderItem> items = new ArrayList<>();
        for (Map.Entry<Product, Integer> entry : cartBean.getProducts().entrySet()) {
            items.add(dispatchOrderItem(entry, cartBean));
        }
        return items;
    }

    private OrderItem dispatchOrderItem(Map.Entry<Product, Integer> entry, CartBean cartBean) {
        OrderItem orderItem = new OrderItem();
        Long productId = entry.getKey().getId();
        orderItem.setProductId(productId);
        orderItem.setQuantity(cartBean.getTotalCountOfProductById(String.valueOf(productId)));
        orderItem.setPrice(BigDecimal.valueOf(cartBean.getTotalOfProductById(String.valueOf(productId))));

        return orderItem;
    }
}
