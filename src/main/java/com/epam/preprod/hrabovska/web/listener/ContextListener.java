package com.epam.preprod.hrabovska.web.listener;

import com.epam.preprod.hrabovska.dao.*;
import com.epam.preprod.hrabovska.dao.impl.*;
import com.epam.preprod.hrabovska.service.OrderService;
import com.epam.preprod.hrabovska.service.ProductService;
import com.epam.preprod.hrabovska.service.UserService;
import com.epam.preprod.hrabovska.service.impl.OrderServiceImpl;
import com.epam.preprod.hrabovska.service.impl.ProductServiceImpl;
import com.epam.preprod.hrabovska.service.impl.UserServiceImpl;
import com.epam.preprod.hrabovska.service.transaction.JDBCTransactionManager;
import com.epam.preprod.hrabovska.service.transaction.TransactionManager;
import com.epam.preprod.hrabovska.util.captcha.CaptchaUtil;
import com.epam.preprod.hrabovska.util.captcha.manager.CaptchaManager;
import com.epam.preprod.hrabovska.util.captcha.manager.CaptchaManagerFactory;
import com.epam.preprod.hrabovska.util.db.DBUtil;
import com.epam.preprod.hrabovska.util.localization.manager.LocaleManager;
import com.epam.preprod.hrabovska.util.localization.manager.LocaleManagerFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

/**
 * ContextListener class. Init all application's components
 */
@WebListener
public class ContextListener implements ServletContextListener {

    private static final Logger LOG = Logger.getLogger(ContextListener.class);

    private UserService userService;
    private ProductService productService;
    private OrderService orderService;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();

        initLog4J(servletContext);

        long captchaMaxAge = Long.parseLong(servletContext.getInitParameter("CaptchaMaxAge"));
        String initParamCaptcha = servletContext.getInitParameter("Captcha");
        int cookieMaxAge = Integer.parseInt(servletContext.getInitParameter("CookieMaxAge"));

        String initParamLocale = servletContext.getInitParameter("LocaleManager");

        DataSource dataSource = getDataSource();

        initService(dataSource);

        CaptchaUtil captchaUtil = new CaptchaUtil(captchaMaxAge);
        CaptchaManagerFactory captchaFactory = new CaptchaManagerFactory();
        CaptchaManager captchaManager = captchaFactory.getCaptchaManger(initParamCaptcha);

        LocaleManagerFactory localeFactory = new LocaleManagerFactory();
        LocaleManager localeManager = localeFactory.getLocaleManager(initParamLocale);

        servletContext.setAttribute("userService", userService);
        servletContext.setAttribute("productService", productService);
        servletContext.setAttribute("orderService", orderService);

        servletContext.setAttribute("cookieMaxAge", cookieMaxAge);
        servletContext.setAttribute("captchaUtil", captchaUtil);
        servletContext.setAttribute("captchaManager", captchaManager);

        servletContext.setAttribute("ImagePath", servletContext.getInitParameter("ImagePath"));

        servletContext.setAttribute("localeManager", localeManager);

    }

    private DataSource getDataSource() {
        DataSource dataSource = null;
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/webstore");
        } catch (NamingException e) {
            LOG.warn(e.getMessage());
        }
        return dataSource;
    }

    private void initLog4J(ServletContext servletContext) {
        try {
            PropertyConfigurator.configure(servletContext.getRealPath("/WEB-INF/log4j.properties"));
            LOG.debug("Log4j has been initialized");
        } catch (Exception ex) {
            LOG.warn(ex.getMessage());
        }
    }

    private void initService(DataSource dataSource) {
        TransactionManager transactionManager = new JDBCTransactionManager(new DBUtil(dataSource));

        UserDAO userDAO = new UserDAOImpl();
        userService = new UserServiceImpl(userDAO, transactionManager);

        CategoryDAO categoryDAO = new CategoryDAOImpl();
        BrandDAO brandDAO = new BrandDAOImpl();
        ProductDAO productDAO = new ProductDAOImpl();
        productService = new ProductServiceImpl(productDAO, categoryDAO, brandDAO, transactionManager);

        OrderDAO orderDAO = new OrderDAOImpl();
        OrderItemDAO orderItemDAO = new OrderItemDAOImpl();
        orderService = new OrderServiceImpl(transactionManager, orderDAO, orderItemDAO);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}