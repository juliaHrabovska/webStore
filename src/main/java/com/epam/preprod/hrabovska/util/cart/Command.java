package com.epam.preprod.hrabovska.util.cart;

import com.epam.preprod.hrabovska.model.bean.CartBean;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class Command {

    private static final String RETURN_ANSWER_ERROR = "Return answer error";
    private static final Logger LOG = Logger.getLogger(Command.class);

    public void doAction(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        CartBean cart = CartBean.getInstance(session);
        JSONObject answer = updateCart(request, cart);
        outResultToResponse(response, answer);
    }

    private void outResultToResponse(HttpServletResponse response, JSONObject result) {
        try {
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.println(result);
            out.close();
        } catch (IOException e) {
            LOG.error(RETURN_ANSWER_ERROR, e);
        }
    }

    public abstract JSONObject updateCart(HttpServletRequest request, CartBean cart);
}
