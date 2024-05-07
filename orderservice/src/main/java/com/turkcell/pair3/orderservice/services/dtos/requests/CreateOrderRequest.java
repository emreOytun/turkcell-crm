package com.turkcell.pair3.orderservice.services.dtos.requests;

import com.turkcell.pair3.events.CartProductEvent;
import com.turkcell.pair3.messages.Messages;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequest {

    @NotNull(message = Messages.ValidationErrors.NOT_NULL)
    private Integer billAccountId;

    @NotNull(message = Messages.ValidationErrors.NOT_NULL)
    private Integer billAddressId;

    @NotNull(message = Messages.ValidationErrors.NOT_NULL)
    private Integer cartId;

}