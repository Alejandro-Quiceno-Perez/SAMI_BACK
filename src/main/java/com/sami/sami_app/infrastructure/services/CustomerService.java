package com.sami.sami_app.infrastructure.services;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.sami.sami_app.api.dto.request.CustomerRequest;
import com.sami.sami_app.api.dto.request.UserRequest;
import com.sami.sami_app.api.dto.response.CustomerResponse;
import com.sami.sami_app.api.dto.response.UserResponse;
import com.sami.sami_app.domain.entities.Customer;
import com.sami.sami_app.domain.repositories.CustomerRepository;
import com.sami.sami_app.infrastructure.abstract_services.ICustomerService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;


@Service
@Transactional
@AllArgsConstructor
public class CustomerService implements ICustomerService {

     @Autowired
    private final CustomerRepository customerRepository;

    @Override
    public Page<CustomerResponse> getAll(int page, int size) {
        if (page < 0)
            page = 0;

        PageRequest pagination = PageRequest.of(page, size);
        return this.customerRepository.findAll(pagination).map(this::entityToResponse);
    }

    @Override
    public CustomerResponse getById(Long id) {
        return this.entityToResponse(this.find(id));
    }

    @Override
    public CustomerResponse create(UserRequest request) {

        return null;
    }

    @Override
    public CustomerResponse update(UserRequest request, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {
        this.customerRepository.delete(this.find(id));
        
    }

    private CustomerResponse entityToResponse(Customer entity) {

        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(entity.getUser(), userResponse);

        return CustomerResponse.builder().idCustomer(entity.getIdCustomer()).user(userResponse).build();
    }

    private Customer find(Long id) {
        return this.customerRepository.findById(id).orElseThrow();
    }

    private Customer requestToEntity(UserRequest request) {
        return null;
    }

}
