package com.sami.sami_app.infrastructure.services;
import com.sami.sami_app.domain.repositories.AccountRepository;
import com.sami.sami_app.infrastructure.helpers.JwtService;
import lombok.AllArgsConstructor;
import main.java.com.sami.sami_app.api.dto.request.LoginRequest;
import main.java.com.sami.sami_app.api.dto.request.RegisterRequest;
import main.java.com.sami.sami_app.api.dto.response.AuthResp;
import main.java.com.sami.sami_app.infrastructure.abstract_services.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService implements  IAuthService{
    @Autowired
    private final AccountRepository accountRepository;
    @Autowired
    private final JwtService jwtService;
    @Override
    public AuthResp login(LoginRequest request) {
        return null;
    }

    @Override
    public AuthResp regiter(RegisterRequest request) {
        return null;
    }
}
