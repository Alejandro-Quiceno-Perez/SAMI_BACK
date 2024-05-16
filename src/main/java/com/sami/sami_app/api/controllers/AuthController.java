package com.sami.sami_app.api.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import main.java.com.sami.sami_app.infrastructure.abstract_services.IAuthService;
import main.java.com.sami.sami_app.api.dto.response.AuthResp;
import main.java.com.sami.sami_app.api.dto.request.LoginRequest;


@RestController
@RequestMapping
@AllArgsConstructor
public class AuthController {
    @Autowired
    private final IAuthService authService;

    @PostMapping (path = "/auth/login")
    public ResponseEntity<AuthResp> login (@Validated @RequestBody LoginRequest request) {
        return ResponseEntity.ok(this.authService.login(request));
    }
}
