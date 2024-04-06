package com.turkcell.pair3.authservice.services.abstracts;

import com.turkcell.pair3.authservice.services.dtos.requests.LoginRequest;
import com.turkcell.pair3.authservice.services.dtos.requests.RegisterRequest;

public interface AuthService {
    void register(RegisterRequest request);
    String login(LoginRequest request);
}
