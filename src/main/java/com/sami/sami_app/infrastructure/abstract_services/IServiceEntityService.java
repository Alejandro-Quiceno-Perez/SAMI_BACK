package com.sami.sami_app.infrastructure.abstract_services;

import com.sami.sami_app.api.dto.request.ServiceEntityRequest;
import com.sami.sami_app.api.dto.response.ServiceEntityResponse;
import com.sami.sami_app.util.enums.StatusService;

import java.util.List;

public interface IServiceEntityService extends CrudService <ServiceEntityRequest, ServiceEntityResponse, Long> {
    public List<ServiceEntityRequest> search(StatusService statusService);
}
