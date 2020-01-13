/*
 * Created by Anselmo Jose Munoz Medina on 1/13/20 1:03 PM
 * Email: Joseanmun@gmail.com
 *
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 1/12/20 9:19 PM
 */

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
