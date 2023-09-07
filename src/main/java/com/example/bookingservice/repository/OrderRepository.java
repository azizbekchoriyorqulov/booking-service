package com.example.bookingservice.repository;

import com.example.bookingservice.domain.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {

}
