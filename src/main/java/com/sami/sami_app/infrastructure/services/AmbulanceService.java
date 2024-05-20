package com.sami.sami_app.infrastructure.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.sami.sami_app.api.dto.request.AmbulanceRequest;
import com.sami.sami_app.api.dto.response.AmbulanceResponse;
import com.sami.sami_app.api.dto.response.UserResponse;
import com.sami.sami_app.domain.entities.Ambulance;
import com.sami.sami_app.domain.entities.User;
import com.sami.sami_app.domain.repositories.AmbulanceRepository;
import com.sami.sami_app.domain.repositories.UserRepository;
import com.sami.sami_app.infrastructure.abstract_services.IAmbulanceService;
import com.sami.sami_app.util.enums.SortType;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AmbulanceService implements IAmbulanceService {

    @Autowired
    private final AmbulanceRepository ambulanceRepository;

    @Autowired
    private final UserRepository userRepository;

    @Override
    public Page<AmbulanceResponse> getAll(int page, int size, SortType sortType) {
        if (page < 0)
            page = 0;
        PageRequest pagination = PageRequest.of(page, size);
        return this.ambulanceRepository.findAll(pagination).map(this::entityToResponse);
    }

    @Override
    public AmbulanceResponse getById(Long id) {
        return this.entityToResponse(this.find(id));
    }

    @Override
    public AmbulanceResponse create(AmbulanceRequest request) {
        Ambulance ambulance = this.requestToEntity(request);
        return this.entityToResponse(this.ambulanceRepository.save(ambulance));
    }

    @Override
    public AmbulanceResponse update(AmbulanceRequest request, Long id) {
        Ambulance ambulance = this.find(id);
        ambulance = this.requestToEntity(request);
        ambulance.setIdAmbulance(id);
        return this.entityToResponse(this.ambulanceRepository.save(ambulance));
    }

    @Override
    public void delete(Long id) {
        this.ambulanceRepository.delete(this.find(id));
    }

    private Ambulance find(Long id) {
        return this.ambulanceRepository.findById(id).orElseThrow();
    }

    private AmbulanceResponse entityToResponse(Ambulance entity) {
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

    private Ambulance requestToEntity(AmbulanceRequest request) {

        return Ambulance.builder()
                .vehiclePlate(request.getVehiclePlate())
                .ambulanceType(request.getAmbulanceType())
                .status(request.getStatus())
                .latitudeAmbulance(request.getLatitudeAmbulance())
                .longitudeAmbulance(request.getLongitudeAmbulance())
                .driver(findUser(request.getIdDriver(), "Driver"))
                .emt(findUser(request.getIdEmt(), "EMT"))
                .build();
    }

    private UserResponse userToResponse(User entity) {
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(entity, userResponse);
        return userResponse;
    }

    private User findUser(Long id, String type) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No Ambulance was found with this ID: " + id));
    }
}
