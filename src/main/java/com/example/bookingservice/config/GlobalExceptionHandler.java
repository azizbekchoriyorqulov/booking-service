package com.example.bookingservice.config;

import com.example.bookingservice.exeption.BookedException;
import com.example.bookingservice.exeption.DataNotFoundException;
import com.example.bookingservice.exeption.NoPermissionException;
import com.example.bookingservice.exeption.OrdersException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {DataNotFoundException.class})
    public ResponseEntity<String> DataNotFoundExceptionHandler(
            DataNotFoundException e
    ) {
        return ResponseEntity.status(401).body(e.getMessage());
    }
    @ExceptionHandler(value = {OrdersException.class})
    public ResponseEntity<String> OrdersExceptionHandler(
            OrdersException e
    ) {
        return ResponseEntity.status(403).body(e.getMessage());
    }
    @ExceptionHandler(value = {BookedException.class})
    public ResponseEntity<String> BookedExceptionHandler(
            BookedException e
    ) {
        return ResponseEntity.status(400).body(e.getMessage());
    }
    @ExceptionHandler(value = {NoPermissionException.class})
    public ResponseEntity<String> NoPermissionExceptionHandler(
            NoPermissionException e
    ) {
        return ResponseEntity.status(403).body(e.getMessage());
    }



}
