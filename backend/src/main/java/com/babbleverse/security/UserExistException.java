package com.babbleverse.security;
import org.springframework.security.core.AuthenticationException;

public class UserExistException extends AuthenticationException {
    public UserExistException(final String msg) {
        super(msg);
    }
}
