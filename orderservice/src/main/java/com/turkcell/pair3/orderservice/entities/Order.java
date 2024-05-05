package com.turkcell.pair3.orderservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private LocalDateTime orderDate;
    private String customerId;
    private double totalPrice;
    private List<Integer> products;

}
