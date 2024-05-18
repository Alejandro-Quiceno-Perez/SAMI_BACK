package com.sami.sami_app.util.exceptions;

public class IdNotFoundException extends RuntimeException {
    
    private static final String ERROR_MESSAGE = "No records were found in the entity %s with the ID provided.";
    
    public IdNotFoundException(String nameEntity) {
        super(String.format(ERROR_MESSAGE, nameEntity));
    }
}
