package com.joonfluence.starbucks.domain.user.order.service;

import java.util.NoSuchElementException;

public class NoSuchOrderException extends NoSuchElementException {
    public NoSuchOrderException() {
    }

    public NoSuchOrderException(String s, Throwable cause) {
        super(s, cause);
    }

    public NoSuchOrderException(Throwable cause) {
        super(cause);
    }

    public NoSuchOrderException(String s) {
        super(s);
    }
}
