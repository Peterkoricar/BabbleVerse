package com.BabbleVerse.Security;
import org.springframework.security.core.AuthenticationException;

class UserExistsException extends AuthenticationException {
    public UserExistsException(final String msg) {
        super(msg);
    }
}