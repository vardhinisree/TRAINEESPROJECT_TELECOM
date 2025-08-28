package com.telecom.Wezen.exception;

public class UsageNotFoundException extends RuntimeException {
    public UsageNotFoundException(Long id) {
        super("Usage record not found with id: " + id);
    }
}
