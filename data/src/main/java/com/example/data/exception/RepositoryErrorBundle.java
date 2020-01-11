package com.example.data.exception;


import com.example.domain.exception.ErrorBundle;

/**
 * Wrapper around Exceptions used to manage errors in the repository.
 */
public class RepositoryErrorBundle implements ErrorBundle {

    private final Exception exception;

    public RepositoryErrorBundle(Exception exception) {
        this.exception = exception;
    }

    public Exception getException() {
        return exception;
    }

    public String getErrorMessage() {
        String message = "";
        if (this.exception != null) {
            this.exception.getMessage();
        }
        return message;
    }
}
