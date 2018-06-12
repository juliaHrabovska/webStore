package com.epam.preprod.hrabovska.service.transaction;

import com.epam.preprod.hrabovska.exception.DBException;

public interface TransactionManager {

    <T> T execute(TransactionOperation<T> op) throws DBException;
}
