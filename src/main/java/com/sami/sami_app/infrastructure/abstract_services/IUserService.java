package com.sami.sami_app.infrastructure.abstract_services;

import org.springframework.stereotype.Service;

import com.sami.sami_app.api.dto.request.create.UserRequest;
import com.sami.sami_app.api.dto.response.UserResponse;


@Service
public interface IUserService  extends CrudService<UserRequest,UserResponse,Long>{
    
}
