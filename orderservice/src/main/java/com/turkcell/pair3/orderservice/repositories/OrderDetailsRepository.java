package com.turkcell.pair3.orderservice.repositories;

import com.turkcell.pair3.orderservice.entities.Order;
import com.turkcell.pair3.orderservice.entities.OrderDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface OrderDetailsRepository extends MongoRepository<OrderDetails, String> {
    //List<String> findOrderDetailsIdsByOrderId(String orderId);

    //Date findOrderDateByOrderDetailsId(String orderDetailsId);

    //Date findServiceEndDateByOrderDetailsId(String orderDetailsId);
}
