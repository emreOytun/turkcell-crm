package com.turkcell.pair3.customerservice.repositories;

import com.turkcell.pair3.customerservice.entities.IndividualCustomer;
import com.turkcell.pair3.customerservice.services.dtos.requests.IndividualCustomerSearchRequest;
import com.turkcell.pair3.customerservice.services.dtos.responses.IndividualCustomerSearchResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomer, Integer> {
    Optional<IndividualCustomer> findByNationalityId(String nationalityId);

    Optional<IndividualCustomer> findByCustomerId(String customerId);

    Boolean existsByNationalityId(String nationalityId);

    // TODO not working
    @Query("Select new com.turkcell.pair3.customerservice.services.dtos.responses." +
            "IndividualCustomerSearchResponse(c.customerId, c.firstName, c.lastName, c.secondName, c.nationalityId)" +
            " from IndividualCustomer c" +
            " where ( :#{#request.getNationalityId()} is null or c.nationalityId= :#{#request.getNationalityId()})" +
            " and ( :#{#request.getCustomerId()} is null or c.customerId= :#{#request.getCustomerId()})")
    List<IndividualCustomerSearchResponse> search(IndividualCustomerSearchRequest request);

}
