package com.example.bookingservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookingDto {
    public UUID roomId;

    public UUID userId;

    public LocalDate startDay;

    public LocalDate endDay;


    public Double price;

}
