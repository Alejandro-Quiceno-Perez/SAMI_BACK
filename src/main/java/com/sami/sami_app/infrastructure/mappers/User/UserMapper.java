package com.sami.sami_app.infrastructure.mappers.User;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.sami.sami_app.api.dto.response.UserResponse;
import com.sami.sami_app.domain.entities.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserResponse toResponse (User user);

    List <UserResponse> toResponseList (List <User> entity);
    
}
