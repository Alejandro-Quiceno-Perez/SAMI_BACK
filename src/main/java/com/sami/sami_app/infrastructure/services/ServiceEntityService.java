package com.sami.sami_app.infrastructure.services;

import com.sami.sami_app.api.dto.request.ServiceEntityRequest;
import com.sami.sami_app.api.dto.response.ServiceEntityResponse;
import com.sami.sami_app.infrastructure.abstract_services.IServiceEntityService;
import com.sami.sami_app.util.enums.StatusService;
import org.springframework.data.domain.Page;

import java.util.List;

public class ServiceEntityService implements IServiceEntityService {
    @Override
    public Page<ServiceEntityResponse> getAll(int page, int size) {
        return null;
    }

    @Override
    public ServiceEntityResponse getById(Long id) {
        return null;
    }

    @Override
    public ServiceEntityResponse create(ServiceEntityRequest serviceEntityRequest) {
        return null;
    }

    @Override
    public ServiceEntityResponse update(ServiceEntityRequest serviceEntityRequest, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<ServiceEntityRequest> search(StatusService statusService) {
        return null;
    }
}
