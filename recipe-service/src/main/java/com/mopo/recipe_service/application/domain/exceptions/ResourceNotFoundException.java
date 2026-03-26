package com.mopo.recipe_service.application.domain.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String entity, String field, Object id) {
        super(String.format("%s with %s %s not found", entity, field, id));
    }
}
