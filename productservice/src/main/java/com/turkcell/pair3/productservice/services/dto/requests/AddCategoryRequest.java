package com.turkcell.pair3.productservice.services.dto.requests;

import com.turkcell.pair3.core.messages.Messages;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddCategoryRequest {
    @NotBlank(message = Messages.ValidationErrors.NOT_BLANK)
    @Length(min = 2, max = 15)
    private String name;

}
