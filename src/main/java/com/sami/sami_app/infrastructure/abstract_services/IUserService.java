package com.sami.sami_app.infrastructure.abstract_services;

import org.springframework.stereotype.Service;

import com.sami.sami_app.api.dto.request.create.UserRequest;
import com.sami.sami_app.api.dto.response.UserResponse;
import com.sami.sami_app.infrastructure.abstract_services.generic.CreateService;
import com.sami.sami_app.infrastructure.abstract_services.generic.DeleteService;
import com.sami.sami_app.infrastructure.abstract_services.generic.ReadAllService;
import com.sami.sami_app.infrastructure.abstract_services.generic.ReadService;
import com.sami.sami_app.infrastructure.abstract_services.generic.UpdateService;

@Service
public interface IUserService extends
        CreateService<UserRequest, UserResponse>,
        DeleteService<String>,
        ReadAllService<UserResponse>,
        ReadService<UserResponse, String>,
        UpdateService<UserRequest, UserResponse, String> {

}
