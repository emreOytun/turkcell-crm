package com.turkcell.pair3.customerservice.repositories;

import com.turkcell.pair3.customerservice.entities.Customer;
import com.turkcell.pair3.customerservice.entities.IndividualCustomer;
import com.turkcell.pair3.customerservice.services.dtos.requests.SearchIndividualCustomerRequest;
import com.turkcell.pair3.customerservice.services.dtos.responses.SearchIndividualCustomerResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomer, Integer> {
    Optional<IndividualCustomer> findByNationalityId(String nationalityId);


    //TODO: Implement the paging for the findAll method
//    List<Customer> findAll();

    Optional<IndividualCustomer> findByCustomerId(String customerId);
    @Query("Select new com.turkcell.pair3.customerservice.services.dtos.responses." +
            "SearchIndividualCustomerResponse(c.customerId, c.firstName, c.lastName, c.secondName, c.nationalityId)" +
            " from IndividualCustomer c" +
            " where ( :#{#request.getNationalityId()} <= 0 or c.nationalityId= :#{#request.getNationalityId()})" +
            " and ( :#{#request.getCustomerId()} is null or c.customerId= :#{#request.getCustomerId()})")
    List<SearchIndividualCustomerResponse> search(SearchIndividualCustomerRequest request);
}
