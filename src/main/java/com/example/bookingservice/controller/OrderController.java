package com.example.bookingservice.controller;

import com.example.bookingservice.domain.dto.BookingDto;
import com.example.bookingservice.domain.entity.OrderEntity;
import com.example.bookingservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

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
@PostMapping("/daysOff")
    public ResponseEntity<List<LocalDate>> openDays(
        @PathVariable UUID roomId
        ){
    List<LocalDate> localDates = orderService.DaysOff(roomId);
    return ResponseEntity.ok(localDates);
}
@DeleteMapping ("/deleteBooking")
    public String delete(
            @PathVariable UUID orderId,
            @PathVariable UUID userId
)
{
    return orderService.deleteOrder(orderId,userId);
}
}
