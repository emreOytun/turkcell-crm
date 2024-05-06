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
    private Date orderDate;
    private String orderNumber;
    private Integer billAddressId;
    private Integer billAccountId;
    private double totalPrice;
    private List<OrderDetails> orderDetails;
}

