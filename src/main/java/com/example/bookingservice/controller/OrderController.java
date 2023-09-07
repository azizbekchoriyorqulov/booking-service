package com.example.bookingservice.controller;

import com.example.bookingservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("booking/api/v1")
public class OrderController {
    private final OrderService orderService;
    @PostMapping("/bookingRom")
    public ResponseEntity bookingRoom(


    }

    )



}
