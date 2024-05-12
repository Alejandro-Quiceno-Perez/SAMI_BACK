package com.sami.sami_app.infrastructure.services;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.sami.sami_app.api.dto.request.CustomerRequest;
import com.sami.sami_app.api.dto.response.CustomerResponse;
import com.sami.sami_app.infrastructure.abstract_services.ICustomerService;
import com.sami.sami_app.util.enums.SortType;

@Service
public class CustomerService implements ICustomerService{

    @Override
    public Page<CustomerResponse> getAll(int page, int size, SortType sortType) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public CustomerResponse getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public CustomerResponse create(CustomerRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public CustomerResponse update(CustomerRequest request, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
