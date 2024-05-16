package com.sami.sami_app.infrastructure.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.sami.sami_app.api.dto.request.HospitalRequest;
import com.sami.sami_app.api.dto.response.AmbulanceResponse;
import com.sami.sami_app.api.dto.response.HospitalResponse;
import com.sami.sami_app.api.dto.response.ServicesInHospital;
import com.sami.sami_app.api.dto.response.UserResponse;
import com.sami.sami_app.domain.entities.Ambulance;
import com.sami.sami_app.domain.entities.Hospital;
import com.sami.sami_app.domain.entities.ServiceEntity;
import com.sami.sami_app.domain.entities.User;
import com.sami.sami_app.domain.repositories.HospitalRepository;
import com.sami.sami_app.infrastructure.abstract_services.IHospitalService;
import com.sami.sami_app.util.enums.SortType;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class HospitalService implements IHospitalService {

    @Autowired
    private final HospitalRepository hospitalRepository;

    @Override
    public Page<HospitalResponse> getAll(int page, int size, SortType sortType) {
        if (page < 0)
            page = 0;

        PageRequest pagination = PageRequest.of(page, size);
        return this.hospitalRepository.findAll(pagination).map(this::entityToResponse);
    }

    @Override
    public HospitalResponse getById(Long id) {
        return this.entityToResponse(this.find(id));
    }

    @Override
    public HospitalResponse create(HospitalRequest request) {
        Hospital hospital = this.requestToEntity(request);
        hospital.setServices(new ArrayList<>());
        return this.entityToResponse(this.hospitalRepository.save(hospital));
    }

    @Override
    public HospitalResponse update(HospitalRequest request, Long id) {
        Hospital hospital = this.find(id);
        Hospital hospitalUpdate = this.requestToEntity(request);
        hospitalUpdate.setId(id);
        hospitalUpdate.setServices(hospital.getServices());
        return this.entityToResponse(this.hospitalRepository.save(hospitalUpdate));
    }

    @Override
    public void delete(Long id) {
        this.hospitalRepository.delete(this.find(id));
    }

    private Hospital find(Long id) {
        return this.hospitalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No hospital was found with this ID:" + id));
    }

    private HospitalResponse entityToResponse(Hospital entity) {
        List<ServicesInHospital> services = entity.getServices().stream().map(this::serviceToResponse).toList();
        return HospitalResponse
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .latitude(entity.getLatitude())
                .longitude(entity.getLongitude())
                .address(entity.getAddress())
                .complexityGrade(entity.getComplexityGrade())
                .specialty(entity.getSpecialty())
                .services(services)
                .build();
    }

    private Hospital requestToEntity(HospitalRequest hospitalRequest) {
        Hospital hospital = new Hospital();
        BeanUtils.copyProperties(hospitalRequest, hospital);
        return hospital;
    }

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

    private UserResponse userToResponse(User entity) {
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(entity, userResponse);
        return userResponse;
    }

    private AmbulanceResponse ambulanceToResponse(Ambulance entity) {
        return AmbulanceResponse.builder()
                .id(entity.getId())
                .vehiclePlate(entity.getVehiclePlate())
                .ambulanceType(entity.getAmbulanceType())
                .status(entity.getStatus())
                .latitude(entity.getLatitude())
                .longitude(entity.getLongitude())
                .emt(userToResponse(entity.getEmt()))
                .driver(userToResponse(entity.getDriver()))
                .build();
    }
}
