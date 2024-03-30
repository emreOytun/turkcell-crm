package com.turkcell.pair3.customerservice.core.exception.details;

public class InternalProblemDetails extends ProblemDetails {
    public InternalProblemDetails() {
        setType("https://turkcell.com/exceptions/internal");
        setTitle("Internal Server Error");
        setDetail("Some error occured.");
    }
}
