package com.company.Summative1CristieJBNicholas.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException() {
        super();
    }
    public ProductNotFoundException(String message) {
        super(message);
    }
}
