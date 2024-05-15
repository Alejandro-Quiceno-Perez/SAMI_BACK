package main.java.com.sami.sami_app.infrastructure.abstract_services;

import main.java.com.sami.sami_app.api.dto.request.LoginRequest;
import main.java.com.sami.sami_app.api.dto.request.RegisterRequest;
import main.java.com.sami.sami_app.api.dto.response.AuthResp;

public interface IAuthService {
    public AuthResp login(LoginRequest request);

    public AuthResp regiter(RegisterRequest request);
    
}
