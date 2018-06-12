package com.epam.preprod.hrabovska.service.transaction;

import com.epam.preprod.hrabovska.util.db.DBUtil;
import com.epam.preprod.hrabovska.exception.DBException;

import java.sql.Connection;

public class JDBCTransactionManager implements TransactionManager {
    private DBUtil dbUtil;

    public JDBCTransactionManager(DBUtil dbUtil) {
        this.dbUtil = dbUtil;
    }

    public <T> T execute(TransactionOperation<T> op) throws DBException {

        Connection con = dbUtil.getConnection();
        T res;
        try {
            con.setAutoCommit(false);
            res = op.execute(con);
            con.commit();
        } catch (Exception e) {
            dbUtil.rollback(con);
            throw new DBException(e.getMessage(), e);
        } finally {
            dbUtil.closeConnection(con);
        }
        return res;
    }

}
