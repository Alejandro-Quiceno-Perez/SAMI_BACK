package com.sami.sami_app.infrastructure.services;
import main.java.com.sami.sami_app.api.dto.request.LoginRequest;
import main.java.com.sami.sami_app.api.dto.request.RegisterRequest;
import main.java.com.sami.sami_app.api.dto.response.AuthResp;
import main.java.com.sami.sami_app.infrastructure.abstract_services.IAuthService;

public class AuthService implements  IAuthService{
    @Override
    public AuthResp login(LoginRequest request) {
        return null;
    }

    @Override
    public AuthResp regiter(RegisterRequest request) {
        return null;
    }
}
