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
import com.sami.sami_app.api.dto.response.ServiceEntityResponse;
import com.sami.sami_app.api.dto.response.UserResponse;
import com.sami.sami_app.domain.repositories.AmbulanceRepository;
import com.sami.sami_app.domain.repositories.HospitalRepository;
import com.sami.sami_app.domain.repositories.ServiceEntityRepository;
import com.sami.sami_app.domain.repositories.UserRepository;
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
    @Autowired
    private final AmbulanceRepository ambulanceRepository;
    @Autowired
    private final HospitalRepository hospitalRepository;
    @Autowired
    private final UserRepository userRepository;

    @Override
    public Page<ServiceEntityResponse> getAll(int page, int size, SortType sortType) {
        if (page < 0)
            page = 0;

        PageRequest pagination = null;

        switch (sortType) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }

        return this.serviceEntityRepository.findAll(pagination)
                .map(this::entityToResponse);

    }

    @Override
    public ServiceEntityResponse getById(Long id) {
        return entityToResponse(this.find(id));
    }

    @Override
    public ServiceEntityResponse create(ServiceEntityRequest request) {
        ServiceEntity service = this.requestToEntity(request);
        return this.entityToResponse(this.serviceEntityRepository.save(service));
    }

    @Override
    public ServiceEntityResponse update(ServiceEntityRequest serviceEntityRequest, Long id) {

        ServiceEntity service = this.find(id);
        service = this.requestToEntity(serviceEntityRequest);
        service.setIdService(id);
        return this.entityToResponse(this.serviceEntityRepository.save(service));

    }

    @Override
    public void delete(Long id) {
        this.serviceEntityRepository.delete(this.find(id));
    }

    @Override
    public List<ServiceEntityRequest> search(StatusService statusService) {
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    private ServiceEntityResponse entityToResponse(ServiceEntity entity) {

        return ServiceEntityResponse.builder()
                .idService(entity.getIdService())
                .latitudeService(entity.getLatitudeService())
                .longitudeService(entity.getLongitudeService())
                .statusService(entity.getStatus())
                .price(entity.getPrice())
                .anamnesis(entity.getAnamnesis())
                .hospital(hospitalToResponse(entity.getHospital()))
                .ambulance(ambulanceToResponse(entity.getAmbulance()))
                .client(userToResponse(entity.getClient()))

                .build();
    }

    private ServiceEntity requestToEntity(ServiceEntityRequest request) {

        return ServiceEntity.builder()
                .latitudeService(request.getLatidudeService())
                .longitudeService(request.getLongitudeService())
                .status(request.getStatusService())
                .anamnesis(request.getAnamnesis())
                .ambulance(this.ambulanceRepository.findById(request.getIdAmbulance()).orElseThrow())
                .hospital(this.hospitalRepository.findById(request.getIdHospital()).orElseThrow())
                .client(this.userRepository.findById(request.getIdClient()).orElseThrow())
                .build();
    }

    private ServiceEntity find(Long id) {
        return this.serviceEntityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el servicio con el ID: " + id));
    }

    /*-
     * ESPECIFIC METHODS
     */

    private AmbulanceResponse ambulanceToResponse(Ambulance entity) {
        return AmbulanceResponse.builder()
                .idAmbulance(entity.getIdAmbulance())
                .vehiclePlate(entity.getVehiclePlate())
                .ambulanceType(entity.getAmbulanceType())
                .status(entity.getStatus())
                .latitudeAmbulance(entity.getLatitudeAmbulance())
                .longitudeAmbulance(entity.getLongitudeAmbulance())
                .emt(userToResponse(entity.getEmt()))
                .driver(userToResponse(entity.getDriver()))
                .build();
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
