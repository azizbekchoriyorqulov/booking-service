package com.example.bookingservice.exeption;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String massage)  { super(massage);
    }
}
