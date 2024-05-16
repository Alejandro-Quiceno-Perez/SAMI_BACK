package com.sami.sami_app.api.dto.response;

import com.sami.sami_app.util.enums.StatusService;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServicesInHospital {
    private Long id;
    private double latitude;
    private double longitude;
    private StatusService status;
    private String anamnesis;
    private AmbulanceResponse ambulance;
    private UserResponse client;
}