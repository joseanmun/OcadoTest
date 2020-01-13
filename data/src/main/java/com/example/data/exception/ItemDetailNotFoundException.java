/*
 * Created by Anselmo Jose Munoz Medina on 1/13/20 1:03 PM
 * Email: Joseanmun@gmail.com
 *
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 1/12/20 9:19 PM
 */

package com.example.data.exception;

/**
 * Exception throw by the application when Products cannot be found.
 */
public class ItemDetailNotFoundException extends Exception {

    public ItemDetailNotFoundException() {
        super();
    }

    public ItemDetailNotFoundException(final String message) {
        super(message);
    }

    public ItemDetailNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ItemDetailNotFoundException(final Throwable cause) {
        super(cause);
    }
}
