package com.seguro.polizas.exception;

public class AseguradoNotFoundException extends RuntimeException {
    public AseguradoNotFoundException(String message) {
        super(message);
    }
}