package com.phodal.layer.application.domain.blog.exception;

import com.phodal.layer.application.infrastructure.concept.exception.DomainException;

public class NoNeedToPublishException extends DomainException {
    public NoNeedToPublishException() {
        super("no need to publish");
    }
}
