package dev.kerim.core.expection;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}