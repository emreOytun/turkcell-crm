package com.turkcell.pair3.customerservice.repositories;

import com.turkcell.pair3.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    //Optional<Customer> findByNationalityId(String nationalityId);


    //TODO: Implement the paging for the findAll method
//    List<Customer> findAll();

    Optional<Customer> findByCustomerId(String customerId);
    /*@Query("Select new com.turkcell.pair3.customerservice.services.dtos.responses." +
            "SearchCustomerResponse(c.customerId, c.firstName, c.lastName, c.secondName, c.nationalityId)" +
            " from Customer c" +
            " where ( :#{#request.getNationalityId()} <= 0 or c.nationalityId= :#{#request.getNationalityId()})" +
            " and ( :#{#request.getCustomerId()} is null or c.customerId= :#{#request.getCustomerId()})")

    List<SearchIndividualCustomerResponse> search(SearchIndividualCustomerRequest request);*/
}
