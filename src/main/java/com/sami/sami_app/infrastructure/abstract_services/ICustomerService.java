package com.sami.sami_app.infrastructure.abstract_services;

import org.springframework.stereotype.Service;

import com.sami.sami_app.api.dto.request.CustomerRequest;
import com.sami.sami_app.api.dto.response.CustomerResponse;


@Service
public interface ICustomerService  extends CrudService<CustomerRequest,CustomerResponse,Long>{
    
}
