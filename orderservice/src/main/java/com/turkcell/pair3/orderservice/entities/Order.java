package com.turkcell.pair3.orderservice.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(value="orders")
public class Order {
    @Id
    private String id;
    private String orderId;
    private Date orderDate;
    private String customerId;
    private double totalPrice;
    private Integer billAccountId;
    //private List<Integer> products;
    private List<OrderDetails> orderDetails;
}

