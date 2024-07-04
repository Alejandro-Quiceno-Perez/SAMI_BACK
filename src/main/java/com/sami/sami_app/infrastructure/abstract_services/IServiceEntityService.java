package com.sami.sami_app.infrastructure.abstract_services;

import com.sami.sami_app.api.dto.request.create.ServiceEntityRequest;
import com.sami.sami_app.api.dto.response.ServiceEntityResponse;
import com.sami.sami_app.infrastructure.abstract_services.generic.CreateService;
import com.sami.sami_app.infrastructure.abstract_services.generic.DeleteService;
import com.sami.sami_app.infrastructure.abstract_services.generic.ReadAllService;
import com.sami.sami_app.infrastructure.abstract_services.generic.ReadService;
import com.sami.sami_app.infrastructure.abstract_services.generic.UpdateService;
import com.sami.sami_app.util.enums.SortType;
import org.springframework.data.domain.Page;


public interface IServiceEntityService extends 
    CreateService<ServiceEntityRequest,ServiceEntityResponse>,
    DeleteService<String>,                                
    ReadAllService<ServiceEntityResponse>,
    ReadService<ServiceEntityResponse,String>,
    UpdateService<ServiceEntityRequest,ServiceEntityResponse, String>{
    
        //Pagination
    Page<ServiceEntityResponse> getAll(int page, int size, SortType sortType);
    public final String FIELD_BY_SORT = "status";

}
