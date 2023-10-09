package com.example.bookingservice.service;

import com.example.bookingservice.domain.dto.BookingDto;
import com.example.bookingservice.domain.entity.BookingStatus;
import com.example.bookingservice.domain.entity.OrderEntity;
import com.example.bookingservice.exeption.BookedException;
import com.example.bookingservice.exeption.DataNotFoundException;
import com.example.bookingservice.exeption.OrdersException;
import com.example.bookingservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ModelMapper modelMapper;
    private final OrderRepository orderRepository;
    @Value("${services.room-url}")
    public String roomUrl ;

public List<OrderEntity>UserBookingsHistory(Pageable pageable, UUID userId){

    //    .orElseThrow(()-> new DataNotFoundException("user not found"));
return orderRepository.findAllByUserId(userId,pageable).getContent();

}

public List<LocalDate> DaysOff(UUID roomId){
    BookingStatus booked = BookingStatus.BOOKED;
    List<OrderEntity> orderEntities = orderRepository.findOrderEntitiesByBookingStatusAndRoomId(booked, roomId).orElseThrow( ()->new DataNotFoundException("booking not found"));
    LocalDate  today = LocalDate.now();
    List<LocalDate> thirtyDays = new ArrayList<>();
    for (int i = 0; i < 30; i++) {
        thirtyDays.add(today.plusDays(i));
    }
    List<LocalDate> openDays = new ArrayList<>();
    for (LocalDate day: thirtyDays ) {
        for (OrderEntity order: orderEntities) {
            if (!((day.isBefore(order.getStartDay())||day == order.getStartDay())&& (day.isAfter(order.getEndDay())))){
              openDays.add(day);
            }
        }


    }
    return openDays;
 }
    public static List<LocalDate> getDatesBetween(LocalDate startDate, LocalDate endDate) {
        List<LocalDate> dates = new ArrayList<>();
        LocalDate currentDate = startDate;

        while (!currentDate.isAfter(endDate)) {
            dates.add(currentDate);
            currentDate = currentDate.plusDays(1);
        }

        return dates;
    }
    public static List<LocalDate> findCommonDates(List<LocalDate> list1, List<LocalDate> list2) {
        List<LocalDate> commonDates = new ArrayList<>();


        for (LocalDate date : list1) {
            if (list2.contains(date)) {
                commonDates.add(date);
            }
        }

        return commonDates;
    }


    public OrderEntity addOrder(BookingDto bookingDto){
  List<LocalDate>bookingDays = getDatesBetween(bookingDto.startDay,bookingDto.endDay);
  List<LocalDate>openDayRooms = DaysOff(bookingDto.roomId);
  List<LocalDate>commonDates = findCommonDates(bookingDays,openDayRooms);
  if (commonDates==null) {
      OrderEntity map = modelMapper.map(bookingDto, OrderEntity.class);
      OrderEntity save = orderRepository.save(map);
      return save;
  }
  throw new OrdersException("Try again in the room you have already booked or choose another room");
 }
}
