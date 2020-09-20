/*******************************************************************************
 * Copyright Axiata Digital Labs, 2020.
 *******************************************************************************/

package com.example.ecom.exception;

/**
 * Authentication controller.
 *
 * @author Gangani
 * @version 1.0
 * @since 2020-09-19
 */

public class AuthenticationException extends RuntimeException {

    private static final long serialVersionUID = -3467334316399408761L;
    private int status;
    private String message;

    /**
     * Instantiate with the User readable message and {@link AuthenticationException}.
     *
     * @param status  the status of the message.
     * @param message the detail message.
     */
    public AuthenticationException(final int status, final String message) {
        this.message = message;
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
