package com.pityubak.collier.exception;

/**
 *
 * @author Pityubak
 */
public class ClassCollectException extends RuntimeException {

    public ClassCollectException(String message,Object... args) {
        super(String.format(message, args));
    }
    
    
}
