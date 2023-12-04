package com.joonfluence.starbucks.domain.user.auth.exception;



public class DuplicateUserEmailException extends RuntimeException {
    public DuplicateUserEmailException() {
    }

    public DuplicateUserEmailException(String message) {
        super(message);
    }

    public DuplicateUserEmailException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateUserEmailException(Throwable cause) {
        super(cause);
    }

    public DuplicateUserEmailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
