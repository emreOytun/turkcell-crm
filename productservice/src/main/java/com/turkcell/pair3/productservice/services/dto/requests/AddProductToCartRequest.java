package com.turkcell.pair3.productservice.services.dto.requests;

import com.turkcell.pair3.core.messages.Messages;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddProductToCartRequest {

    @NotBlank(message = Messages.ValidationErrors.NOT_BLANK)
    private Integer productId;

    @NotBlank(message = Messages.ValidationErrors.NOT_BLANK)
    private Integer cartId;

    @NotBlank(message = Messages.ValidationErrors.NOT_BLANK)
    private Integer productSpecId;

}
