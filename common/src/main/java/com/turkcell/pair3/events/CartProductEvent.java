package com.turkcell.pair3.events;

import com.turkcell.pair3.messages.Messages;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartProductEvent {

    @NotBlank(message = Messages.ValidationErrors.NOT_BLANK)
    private Integer productId;

    @NotBlank(message = Messages.ValidationErrors.NOT_BLANK)
    private Integer cartId;

    @NotBlank(message = Messages.ValidationErrors.NOT_BLANK)
    private Integer productSpecId;

}
