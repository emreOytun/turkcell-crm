package com.turkcell.pair3.productservice.services.dto.requests;

import com.turkcell.pair3.core.messages.Messages;
import com.turkcell.pair3.productservice.entities.Product;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryRequest {
    @NotBlank(message = Messages.ValidationErrors.NOT_BLANK)
    @Length(min = 3, max = 15, message = "length")
    private String name;

    private List<Product> products;
}
