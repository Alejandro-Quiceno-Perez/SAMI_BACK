package com.sami.sami_app.infrastructure.services;
import com.sami.sami_app.domain.entities.Service;

import com.sami.sami_app.api.dto.request.ServiceEntityRequest;
import com.sami.sami_app.api.dto.response.ServiceEntityResponse;
import com.sami.sami_app.infrastructure.abstract_services.IServiceEntityService;
import com.sami.sami_app.util.enums.StatusService;

import main.java.com.sami.sami_app.util.enums.SortType;

import org.springframework.data.domain.Page;


import java.util.List;

public class ServiceEntityService implements IServiceEntityService {

    @Autowired
    private final ServiceEntityRepository serviceEntityRepository;


    //Pagination

    @Override
    public Page<ServiceEntityResponse> getAll(int page, int size,SortType sortType) {
        if (page < 0) page = 0;
        
        PageRequest pagination = null;
        switch (sortType) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascendig());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }
        return this.serviceEntityRepository.findAll(pagination).map(this::entityToResponse);
    }


    // Metodo para buscar por ID
    @Override
    public ServiceEntityResponse getById(Long id) {
        return this.entityToResponse(this.find(id));
    }

    // Metodo para crear un servicio 
    @Override
    public ServiceEntityResponse create(ServiceEntityRequest serviceEntityRequest) {
        Service service = this.requestToEntity(serviceEntityRequest);
        return this.entityToResponse(this.serviceEntityRepository.save(service));
    }

    // Actualizar el servicio 
    @Override
    public ServiceEntityResponse update(ServiceEntityRequest serviceEntityRequest, Long id) {
        Service service = this.find(id);
        Service serviceUpdate = this.requestToEntity(serviceEntityRequest);

        serviceUpdate.setIdService(id);
        
        return this.entityToResponse(this.serviceEntityRepository.save(serviceUpdate));
    }


    // ELiminar Servicio
    @Override
    public void delete(Long id) {
        this.serviceEntityRepository.delete(this.find(id));
    }

    @Override
    public List<ServiceEntityRequest> search(StatusService statusService) {
        return null;
    }

    // 
    private ServiceEntityResponse entityToResponse (Service entity) {
        return ServiceEntityResponse.builder()
            .idService(entity.getIdService())
            .latidudeLocation(entity.getLatidudeLocation())
            .longitudeLocation(entity.getLongitudeLocation())
            .statusService(entity.getStatusService())
            .anamnesis(entity.getAnamnesis())
            .build();
    }

    private Service requestToEntity (ServiceEntityRequest request) {
        return Service.builder()
            .latidudeLocation(request.getLatidudeLocation())
            .longitudeLocation(request.getLongitudeLocation())
            .statusService(request.getStatusService())
            .anamnesis(request.getAnamnesis())
            .build();
    }

    private Service find(Long id) {
        return this.serviceEntityRepository.find(id)
        .orElseThrow(() -> new RuntimeException("No se encontro el servicio"));
    }
}
