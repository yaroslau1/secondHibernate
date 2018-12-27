package com.work.exception;

import java.io.IOException;
import java.sql.SQLException;

public class DaoException extends Exception {


    public DaoException(String description, SQLException e) {
        super(description);
        addSuppressed(e);
    }

    public DaoException(String description, InstantiationException e) {
        super(description);
        initCause(e);
    }

    public DaoException(String description, IllegalAccessException e) {
        super(description);
        initCause(e);
    }

    public DaoException(String description, ClassNotFoundException e) {
        super(description);
        initCause(e);
    }

    public DaoException(String description, IOException e) {
        super(description);
        initCause(e);
    }

    public DaoException(String description, Exception e) {
        super(description);
        addSuppressed(e);
    }

    public DaoException(Exception e) {
        initCause(e);
    }

    public DaoException(String description) {
        super(description);
    }
}
