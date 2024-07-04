package com.sami.sami_app.infrastructure.abstract_services;

import com.sami.sami_app.api.dto.request.create.ClientRegisterRequest;
import com.sami.sami_app.api.dto.request.create.LoginRequest;
import com.sami.sami_app.api.dto.request.create.RegisterRequest;
import com.sami.sami_app.api.dto.response.AuthResp;

public interface IAuthService {

    public AuthResp login(LoginRequest request);

    public AuthResp register(RegisterRequest request);

    public AuthResp registerClient(ClientRegisterRequest request);

    public AuthResp registerAdmin(RegisterRequest request);

    public AuthResp registerDriver(RegisterRequest request);

    public AuthResp registerEmt(RegisterRequest request);
}
