package com.sami.sami_app.infrastructure.services;


import com.sami.sami_app.domain.entities.Ambulance;
import com.sami.sami_app.domain.entities.Hospital;
import com.sami.sami_app.domain.entities.ServiceEntity;
import com.sami.sami_app.domain.entities.User;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sami.sami_app.api.dto.request.ServiceEntityRequest;
import com.sami.sami_app.api.dto.response.AmbulanceResponse;
import com.sami.sami_app.api.dto.response.HospitalBasicResponse;
import com.sami.sami_app.api.dto.response.HospitalResponse;
import com.sami.sami_app.api.dto.response.HospitalsInService;
import com.sami.sami_app.api.dto.response.HospitalsInServiceResponse;
import com.sami.sami_app.api.dto.response.ServiceEntityResponse;
import com.sami.sami_app.api.dto.response.ServicesInHospital;
import com.sami.sami_app.api.dto.response.ServicesInServices;
import com.sami.sami_app.api.dto.response.UserResponse;
import com.sami.sami_app.domain.repositories.ServiceEntityRepository;
import com.sami.sami_app.infrastructure.abstract_services.IServiceEntityService;
import com.sami.sami_app.util.enums.SortType;
import com.sami.sami_app.util.enums.StatusService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import java.util.List;




@Service
@Transactional
@AllArgsConstructor
public class ServiceEntityService implements IServiceEntityService {

    @Autowired
    private final ServiceEntityRepository serviceEntityRepository;

    @Override
    public Page<ServiceEntityResponse> getAll(int page, int size, SortType sortType) {
        if (page < 0) page = 0;

        PageRequest pagination = null;

        switch (sortType) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }


        return this.serviceEntityRepository.findAll(pagination)
                .map(this::entityToResp);

    }

    @Override
    public ServiceEntityResponse getById(Long id) {
        return null;
    }


    @Override
    public ServiceEntityResponse create(ServiceEntityRequest request) {
        ServiceEntity service = this.requestToEntity(request);

        return this.entityToResp(this.serviceEntityRepository.save(service));
    }

    @Override
    public ServiceEntityResponse update(ServiceEntityRequest serviceEntityRequest, Long id) {
        
        ServiceEntity serviceUpdate = this.requestToEntity(serviceEntityRequest);
        serviceUpdate.setId(id);

        return this.entityToResp(this.serviceEntityRepository.save(serviceUpdate));
    }

    @Override
    public void delete(Long id) {
        this.serviceEntityRepository.delete(this.find(id));
    }

    @Override
    public List<ServiceEntityRequest> search(StatusService statusService) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }


    private ServiceEntityResponse entityToResp(ServiceEntity entity){

      
        return ServiceEntityResponse.builder()
                .latidudeLocation(entity.getLatitude())
                .longitudeLocation(entity.getLongitude())
                .statusService(entity.getStatus())
                .anamnesis(entity.getAnamnesis())
                .hospital(entity.getHospital())
                .ambulance(entity.getAmbulance())
                .client(entity.getClient())
                
                .build();
    }

    private ServiceEntity requestToEntity(ServiceEntityRequest request){
        ServiceEntity service = new ServiceEntity();
        BeanUtils.copyProperties(request, service);
        return  service;
    }


    private ServiceEntity find(Long id) {
        return this.serviceEntityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el servicio con el ID: " + id));
    }

    /*-
     * ESPECIFIC METHODS
     */


    
    private ServicesInHospital serviceToResponse(ServiceEntity serviceEntity) {
        return ServicesInHospital
                .builder()
                .id(serviceEntity.getId())
                .latitude(serviceEntity.getLatitude())
                .longitude(serviceEntity.getLongitude())
                .status(serviceEntity.getStatus())
                .anamnesis(serviceEntity.getAnamnesis())
                .ambulance(ambulanceToResponse(serviceEntity.getAmbulance()))
                .client(userToResponse(serviceEntity.getClient()))
                .build();
    }

   


    private AmbulanceResponse ambulanceToResponse(Ambulance entity) {
        AmbulanceResponse ambulanceResponse = new AmbulanceResponse();
        BeanUtils.copyProperties(entity, ambulanceResponse);
        return ambulanceResponse;
    
    }




    

    private UserResponse userToResponse(User entity) {
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(entity, userResponse);
        return userResponse;
    }



    private HospitalBasicResponse hospitalToResponse(Hospital entity) {
        HospitalBasicResponse hospitalResponse = new HospitalBasicResponse();
        BeanUtils.copyProperties(entity, hospitalResponse);
        return hospitalResponse;
        
    }




}