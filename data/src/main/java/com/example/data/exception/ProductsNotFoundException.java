package com.example.data.exception;

/**
 * Exception throw by the application when any itemDetail from a product can be found.
 */
public class ProductsNotFoundException extends Exception {

    public ProductsNotFoundException() {
        super();
    }

    public ProductsNotFoundException(final String message) {
        super(message);
    }

    public ProductsNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ProductsNotFoundException(final Throwable cause) {
        super(cause);
    }
}
