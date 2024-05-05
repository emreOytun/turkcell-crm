package com.turkcell.pair3.orderservice.repositories;

import com.turkcell.pair3.orderservice.entities.Order;
import com.turkcell.pair3.orderservice.services.dtos.responses.ListOrderResponse;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface OrderRepository extends MongoRepository<Order, String> {

    Optional<Order> findOrderByOrderId(String orderId);

    List<Order> findOrdersByBillAccountId(Integer billAccountId);

    List<Integer> findOrderIdsByBillAccountId(Integer billAccountId);

}