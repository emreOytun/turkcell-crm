package com.turkcell.pair3.customerservice.services.abstracts;

import com.turkcell.pair3.customerservice.services.dtos.requests.CityAddRequest;
import com.turkcell.pair3.customerservice.services.dtos.requests.CityUpdateRequest;
import com.turkcell.pair3.customerservice.services.dtos.responses.CityUpdateResponse;

public interface CityService {
    Integer add(CityAddRequest request);

    void delete(Integer id);

    CityUpdateResponse update(int id, CityUpdateRequest request);
}
