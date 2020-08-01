package com.pityubak.collier.exception;

/**
 *
 * @author Pityubak
 */
public class PathParsingException extends RuntimeException{

    public PathParsingException(String message,Object... args) {
        super(String.format(message, args));
    }

   
    
    
}
