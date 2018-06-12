package com.epam.preprod.hrabovska.web.servlet;

import com.epam.preprod.hrabovska.model.bean.FilterBean;
import com.epam.preprod.hrabovska.model.bean.ProductsPageBean;
import com.epam.preprod.hrabovska.model.constant.Sorts;
import com.epam.preprod.hrabovska.service.ProductService;
import com.epam.preprod.hrabovska.util.builder.URLBuilder;
import com.epam.preprod.hrabovska.util.pager.Pager;
import com.epam.preprod.hrabovska.util.validator.FilterValidator;
import com.epam.preprod.hrabovska.web.Path;
import com.epam.preprod.hrabovska.web.RequestProperty;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.epam.preprod.hrabovska.model.bean.FilterBean.*;

/**
 * ShowProductsServlet class
 */
@WebServlet(name = "ShowProductsServlet", urlPatterns = "/product")
public class ShowProductsServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(ShowProductsServlet.class);

    private ProductService productService;

    public void init(ServletConfig servletConfig) throws ServletException {
        LOG.trace("ShowProductsServlet start");
        ServletContext context = servletConfig.getServletContext();
        productService = (ProductService) context.getAttribute("productService");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        FilterBean filter = getFilterFromRequest(request);

        String forward;

        if (!new FilterValidator(filter).validate()) {
            forward = Path.ERROR_PAGE;
        } else {
            ProductsPageBean pageBean = productService.doFilter(filter);
            setPagerLimitsSorts(pageBean, filter);

            request.setAttribute(RequestProperty.PAGE_BEAN, pageBean);
            request.setAttribute(RequestProperty.FILTER, filter);

            forward = Path.PRODUCT_PAGE;
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(forward);
        LOG.trace("Forward to : " + forward);
        requestDispatcher.forward(request, response);
        LOG.debug("Command finished");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private FilterBean getFilterFromRequest(HttpServletRequest request) {
        FilterBean filterBean = new FilterBean();
        if (!StringUtils.isEmpty(request.getParameter(NAME))) {
            filterBean.setName(request.getParameter(NAME));
        }
        if (!StringUtils.isEmpty(request.getParameter(CATEGORY))) {
            filterBean.setCategory(request.getParameterValues(CATEGORY));
        }
        if (!StringUtils.isEmpty(request.getParameter(BRAND))) {
            filterBean.setBrands(request.getParameterValues(BRAND));
        }
        if (!StringUtils.isEmpty(request.getParameter(PRICE_FROM))) {
            filterBean.setPriceFrom(request.getParameter(PRICE_FROM));
        }
        if (!StringUtils.isEmpty(request.getParameter(PRICE_TO))) {
            filterBean.setPriceTo(request.getParameter(PRICE_TO));
        }
        if (!StringUtils.isEmpty(request.getParameter(LIMIT))) {
            filterBean.setLimit(Integer.parseInt(request.getParameter(LIMIT)));
        }
        if (!StringUtils.isEmpty(request.getParameter(PAGE))) {
            filterBean.setPage(Integer.parseInt(request.getParameter(PAGE)));
        }
        if (!StringUtils.isEmpty(request.getParameter(SORT))) {
            filterBean.setSort(request.getParameter(SORT));
        }
        if (!StringUtils.isEmpty(request.getParameter(SORT_TYPE))) {
            filterBean.setSortType(request.getParameter(SORT_TYPE));
        }
        return filterBean;
    }

    private void setPagerLimitsSorts(ProductsPageBean pageBean, FilterBean filter) {
        Pager pager = new Pager(pageBean.getCountOfProducts(), filter);
        pageBean.setPagination(pager.generatePagination());
        pageBean.setLimits(generateLimits(filter));
        pageBean.setSorts(generateSorts(filter));

    }

    private Map<Integer, String> generateLimits(FilterBean filterBean) {
        URLBuilder urlBuilder = new URLBuilder("product");
        urlBuilder.fillFilterStateFromFilterBean(filterBean);
        urlBuilder.fillOrdersFromFilterBean(filterBean);
        Map<Integer, String> limits = new LinkedHashMap<>();

        for (int i = 5; i < 100; i += 20) {
            limits.put(i, urlBuilder.getUrl() + "&limit=" + i);
        }
        return limits;
    }

    private Map<Sorts, String> generateSorts(FilterBean filterBean) {
        URLBuilder urlBuilder = new URLBuilder("product");
        urlBuilder.fillFilterStateFromFilterBean(filterBean);
        urlBuilder.fillPageFromFilterBean(filterBean);
        urlBuilder.fillLimitsFromFilterBean(filterBean);

        Map<Sorts, String> sorts = new LinkedHashMap<>();
        for (Sorts sortElem : Sorts.values()) {
            sorts.put(sortElem, urlBuilder.getUrl() + "&sort=" + sortElem.getName() + "&type=" + sortElem.getSortType());
        }
        return sorts;
    }
}
