package com.phodal.layer.application.infrastructure.concept.exception;

public abstract class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }
}
