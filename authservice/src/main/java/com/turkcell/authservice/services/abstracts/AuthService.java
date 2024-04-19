package com.turkcell.authservice.services.abstracts;

import com.turkcell.pair3.core.services.dtos.requests.RegisterRequest;
import com.turkcell.authservice.services.dtos.requests.LoginRequest;

public interface AuthService {
    void register(RegisterRequest request);
    String login(LoginRequest request);
}
