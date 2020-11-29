package com.agileengine;

public class MissingOriginAttributeException extends RuntimeException {
    public MissingOriginAttributeException(String attributeId) {
        super(String.format("Couldn't found an attribute with id %s", attributeId));
    }
}
