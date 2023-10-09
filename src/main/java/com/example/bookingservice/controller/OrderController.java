package com.example.bookingservice.controller;

import com.example.bookingservice.domain.dto.BookingDto;
import com.example.bookingservice.domain.entity.OrderEntity;
import com.example.bookingservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("booking/api/v1")
public class OrderController {
        private final OrderService orderService;
    @PostMapping("/addOrder")
public ResponseEntity<OrderEntity> addOrder(
        @RequestBody BookingDto bookingDto
        ){
    OrderEntity orderEntity = orderService.addOrder(bookingDto);
    return ResponseEntity.ok(orderEntity);
}
}
