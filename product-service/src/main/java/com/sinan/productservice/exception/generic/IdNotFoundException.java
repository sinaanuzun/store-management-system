package com.sinan.productservice.exception.generic;

public class IdNotFoundException extends RuntimeException {
    public IdNotFoundException(String s) {
        super(s);
    }
}
