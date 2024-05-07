package com.turkcell.pair3.orderservice.entities;

import lombok.*;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(value="order_details")
public class OrderDetails {
    @Id
    private String id;
    private String orderId;
    private Integer productId;
    private Integer productSpecDetailsId;
    private Integer campaignId;
    private Date serviceStartDate;
    private Date serviceEndDate;
    private Integer quantity;
    private Double orderPrice;
    private Double discount;

}
