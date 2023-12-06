package com.joonfluence.starbucks.domain.admin.product.exception;

import java.util.NoSuchElementException;

public class NoSuchProductException extends NoSuchElementException {
    public NoSuchProductException() {
    }

    public NoSuchProductException(String s, Throwable cause) {
        super(s, cause);
    }

    public NoSuchProductException(Throwable cause) {
        super(cause);
    }

    public NoSuchProductException(String s) {
        super(s);
    }
}
