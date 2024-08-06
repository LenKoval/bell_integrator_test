package ru.bi.kovaleva;

public class EmptyProductException extends RuntimeException {
    public EmptyProductException(String message) {
        super(message);
    }
}
