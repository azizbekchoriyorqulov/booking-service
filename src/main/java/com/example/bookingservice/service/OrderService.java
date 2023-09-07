package com.example.bookingservice.service;

import com.example.bookingservice.domain.dto.BookingDto;
import com.example.bookingservice.domain.entity.OrderEntity;
import com.example.bookingservice.exeption.BookedException;
import com.example.bookingservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final RestTemplate restTemplate;

    private final ModelMapper modelMapper;
    private final OrderRepository orderRepository;
    @Value("${services.room-url}")
    public String roomUrl ;
public OrderEntity bookingRoom(BookingDto bookingDto,String uri){
    OrderEntity map = modelMapper.map(bookingDto, OrderEntity.class);
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<BookingDto> entity = new HttpEntity<>(bookingDto, httpHeaders);
    ResponseEntity<Boolean> response = restTemplate.exchange(
            URI.create(roomUrl + uri),
            HttpMethod.GET,
            entity,
            Boolean.class);
    if (response.getBody()){
    OrderEntity save = orderRepository.save(map);
    return save;
    }
    else
        throw new BookedException("the room is booked");
    
}

}
