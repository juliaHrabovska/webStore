package com.epam.preprod.hrabovska.exception;

/**
 * Exception from database
 */
public class DBException extends RuntimeException{

    public DBException() {
        super();
    }

    public DBException(String message, Throwable cause) {
        super(message, cause);
    }
}
