package com.example.robot_service.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by elmar on 11.03.18.
 */
public class InvalidDirectionException extends Exception {
    public InvalidDirectionException() {
    }

    public InvalidDirectionException(String message) {
        super(message);
    }

    public InvalidDirectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDirectionException(Throwable cause) {
        super(cause);
    }

    public InvalidDirectionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
