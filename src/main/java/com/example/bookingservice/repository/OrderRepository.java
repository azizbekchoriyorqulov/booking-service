package com.example.bookingservice.repository;

import com.example.bookingservice.domain.entity.BookingStatus;
import com.example.bookingservice.domain.entity.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {

    Page<OrderEntity> findAllByUserId(UUID userId, Pageable pageable);
//    Optional<List<OrderEntity>>findAllByRoomId(UUID roomId, Pageable pageable);
    @Query(value = "select o from OrderEntity o where o.bookingStatus = :bookingStatus and o.roomId = :roomId")
    Optional<List<OrderEntity>>findOrderEntitiesByBookingStatusAndRoomId(
            @Param(value = "bookingStatus") BookingStatus bookingStatus, @Param(value = "roomId") UUID roomId);
}

