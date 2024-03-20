package com.turkcell.pair3.orderservice.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(value="orders")
public class Order {
    @Id
    private String id;
    private Date orderDate;
    private int customerId;
    private double totalPrice;
}
