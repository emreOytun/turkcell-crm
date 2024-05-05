package com.turkcell.pair3.orderservice.repositories;

import com.turkcell.pair3.orderservice.entities.Order;
import com.turkcell.pair3.orderservice.services.dto.response.ListOrderResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends MongoRepository<Order, String> {

    Optional<Order> findOrderByOrderId(String orderId);




}
