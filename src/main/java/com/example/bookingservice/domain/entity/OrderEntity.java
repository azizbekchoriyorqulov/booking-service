package com.example.bookingservice.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
 import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderEntity extends BaseEntity {
    private UUID userId;
    private UUID hotelId;

    public UUID roomId;

    private Double price;
    private LocalDate startDay;
    private LocalDate endDay;
    private BookingStatus bookingStatus;



}
