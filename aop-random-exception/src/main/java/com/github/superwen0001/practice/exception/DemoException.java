package com.github.superwen0001.practice.exception;

/**
 * Created by wenshiliang on 2017/8/8.
 */
public class DemoException extends RuntimeException {
    public DemoException() {
    }

    public DemoException(String message) {
        super(message);
    }

    public DemoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DemoException(Throwable cause) {
        super(cause);
    }

    public DemoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
