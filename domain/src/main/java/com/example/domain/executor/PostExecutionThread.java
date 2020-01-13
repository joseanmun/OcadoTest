/*
 * Created by Anselmo Jose Munoz Medina on 1/13/20 1:03 PM
 * Email: Joseanmun@gmail.com
 *
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 1/11/20 8:40 PM
 */

package com.example.domain.executor;

/**
 * Thread abstraction created to change the execution context from any thread to any other thread.
 * Useful to encapsulate a UI Thread for example, since some job will be done in background, an
 * implementation of this interface will change context and update the UI.
 */
public interface PostExecutionThread {
    /**
     * Causes the {@link Runnable} to be added to the message queue of the Main UI Thread
     * of the application.
     *
     * @param runnable {@link Runnable} to be executed.
     */
    void post(Runnable runnable);
}
