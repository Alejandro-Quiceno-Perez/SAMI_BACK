package com.sami.sami_app.infrastructure.mappers.User;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import org.mapstruct.MappingConstants;


import com.sami.sami_app.api.dto.request.create.UserRequest;
import com.sami.sami_app.api.dto.response.UserResponse;
import com.sami.sami_app.domain.entities.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserCreateMapper {
   
    User toEntity (UserRequest request);

    @InheritInverseConfiguration
    UserResponse toResponse (User user);

    List <User> toEntityList (List<UserRequest>request);
    List <UserResponse> toResponseList (List<User>entity);
    
}
