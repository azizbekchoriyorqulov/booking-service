package com.example.bookingservice.repository;

import com.example.bookingservice.domain.entity.BookingStatus;
import com.example.bookingservice.domain.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {

    Optional<List<OrderEntity>> findAllByUserId(UUID userId,Pageable pageable);
    Optional<List<OrderEntity>>findAllByRoomId(UUID roomId, Pageable pageable);
    Optional<List<OrderEntity>>findOrderEntitiesByBookingStatusAndRoomId(UUID roomId,BookingStatus bookingStatus);
}

