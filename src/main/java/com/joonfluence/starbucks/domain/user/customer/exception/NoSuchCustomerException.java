package com.joonfluence.starbucks.domain.user.customer.exception;

import java.util.NoSuchElementException;

public class NoSuchCustomerException extends NoSuchElementException {
    public NoSuchCustomerException() {
    }

    public NoSuchCustomerException(String s, Throwable cause) {
        super(s, cause);
    }

    public NoSuchCustomerException(Throwable cause) {
        super(cause);
    }

    public NoSuchCustomerException(String s) {
        super(s);
    }
}
