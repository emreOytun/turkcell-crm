package com.turkcell.pair3.customerservice.services.dtos.requests;

import com.turkcell.pair3.customerservice.enums.EnumGender;
import com.turkcell.pair3.customerservice.services.constants.Messages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdateRequest {
    @NotBlank(message = Messages.ValidationErrors.NOT_BLANK)
    private String firstName;

    @NotBlank(message = Messages.ValidationErrors.NOT_BLANK)
    private String lastName;

    @NotNull(message = Messages.ValidationErrors.NOT_NULL)
    private EnumGender gender;

    @NotBlank(message = Messages.ValidationErrors.NOT_BLANK)
    private String motherName;

    @NotBlank(message = Messages.ValidationErrors.NOT_BLANK)
    private String fatherName;

    @NotBlank(message = Messages.ValidationErrors.NOT_BLANK)
    private String secondName;

    @NotNull(message = Messages.ValidationErrors.NOT_NULL)
    private LocalDate birthDate;

    @NotNull(message = Messages.ValidationErrors.NOT_NULL)
    private int nationalityId;
}
