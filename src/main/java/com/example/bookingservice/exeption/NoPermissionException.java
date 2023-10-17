package com.example.bookingservice.exeption;

public class NoPermissionException extends RuntimeException {
    public NoPermissionException(String message){
        super(message);
    }
}
