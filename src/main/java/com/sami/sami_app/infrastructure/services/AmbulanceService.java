package com.sami.sami_app.infrastructure.services;

import java.util.Optional;


import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sami.sami_app.api.dto.request.create.AmbulanceRequest;
import com.sami.sami_app.api.dto.response.AmbulanceResponse;
import com.sami.sami_app.infrastructure.abstract_services.IAmbulanceService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AmbulanceService implements IAmbulanceService {@Override
    public AmbulanceResponse create(AmbulanceRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<AmbulanceResponse> getAll(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Optional<AmbulanceResponse> getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public AmbulanceResponse update(String id, AmbulanceRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

   
}
