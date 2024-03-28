package com.turkcell.pair3.customerservice.core.exception.handlers;

import com.turkcell.pair3.customerservice.core.exception.details.BusinessProblemDetails;
import com.turkcell.pair3.customerservice.core.exception.details.ProblemDetails;
import com.turkcell.pair3.customerservice.core.exception.details.ValidationProblemDetails;
import com.turkcell.pair3.customerservice.core.exception.types.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BusinessProblemDetails handleBusinessException(BusinessException businessException)
    {
        BusinessProblemDetails problemDetails = new BusinessProblemDetails();
        problemDetails.setDetail(businessException.getMessage());
        return problemDetails;
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ProblemDetails handleOtherExceptions(){
        ProblemDetails problemDetails = new
                ProblemDetails("Internal Server Error","Some error occured.","https://turkcell.com/exceptions/internal");
        return problemDetails;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
        ValidationProblemDetails validationError = new ValidationProblemDetails();
        return validationError;
    }



}
