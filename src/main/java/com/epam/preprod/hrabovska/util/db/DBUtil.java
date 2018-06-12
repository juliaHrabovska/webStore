package com.epam.preprod.hrabovska.util.db;

import com.epam.preprod.hrabovska.exception.DBException;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DBUtil {
    private static final Logger LOG = Logger.getLogger(DBUtil.class);

    private static final String CLOSE_CONNECTION_ERROR = "Cant close connection";
    private static final String ROLLBACK_ERROR = "Can't rollback";
    private static final String NEW_CONNECTION_ERROR = "Can't get a new connection";

    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private DataSource dataSource;

    public DBUtil(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection() {
        Connection connection;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            LOG.error(NEW_CONNECTION_ERROR, e);
            throw new DBException(NEW_CONNECTION_ERROR, e);
        }
        return connection;
    }

    public void rollback(Connection connection) {
        try {
            connection.rollback();
        } catch (SQLException e) {
            LOG.error(ROLLBACK_ERROR, e);
            throw new DBException(ROLLBACK_ERROR, e);
        }
    }

    public void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            LOG.error(CLOSE_CONNECTION_ERROR, e);
            throw new DBException(CLOSE_CONNECTION_ERROR, e);
        }
    }


    public static String dateToString(Date date) {
        String dateString = "";
        if (date != null) {
            dateString = DATE_FORMAT.format(date);
        }
        return dateString;
    }
}
