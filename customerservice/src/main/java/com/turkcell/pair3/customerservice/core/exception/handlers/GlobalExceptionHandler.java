package com.turkcell.pair3.customerservice.core.exception.handlers;

import com.turkcell.pair3.customerservice.core.exception.details.BusinessProblemDetails;
import com.turkcell.pair3.customerservice.core.exception.details.InternalProblemDetails;
import com.turkcell.pair3.customerservice.core.exception.details.ProblemDetails;
import com.turkcell.pair3.customerservice.core.exception.details.ValidationProblemDetails;
import com.turkcell.pair3.customerservice.core.exception.types.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice   //try
public class GlobalExceptionHandler
{
    @ExceptionHandler({BusinessException.class}) //catch
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BusinessProblemDetails handleBusinessException(BusinessException businessException)
    {
        BusinessProblemDetails problemDetails = new BusinessProblemDetails();
        problemDetails.setDetail(businessException.getMessage());
        return problemDetails;
    }

    /*
    @ExceptionHandler({Exception.class})    //catch
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ProblemDetails handleOtherExceptions(){
        return new InternalProblemDetails();
    }*/

    @ExceptionHandler({MethodArgumentNotValidException.class})  //catch
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
        ValidationProblemDetails validationError = new ValidationProblemDetails();
        validationError.setDetail(methodArgumentNotValidException.getMessage());
        return validationError;
    }



}
