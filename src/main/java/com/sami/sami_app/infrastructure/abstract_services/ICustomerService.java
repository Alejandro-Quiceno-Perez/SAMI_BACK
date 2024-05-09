package com.sami.sami_app.infrastructure.abstract_services;

import com.sami.sami_app.api.dto.request.CustomerRequest;
import com.sami.sami_app.api.dto.response.CustomerResponse;
import com.sami.sami_app.infrastructure.abstract_services.CrudService;

public interface ICustomerService  extends CrudService<CustomerRequest,CustomerResponse,Long>{
    
}
