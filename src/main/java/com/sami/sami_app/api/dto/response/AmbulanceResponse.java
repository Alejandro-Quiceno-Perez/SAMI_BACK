package com.sami.sami_app.api.dto.response;

import com.sami.sami_app.util.enums.StatusAmbulance;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AmbulanceResponse {

    private Long idAmbulance;
    private String vehiclePlate;
    private String ambulanceType;
    private StatusAmbulance status;
    private Double latitude;
    private Double longitude;
    private UserResponse driver;
    private UserResponse emt;
}
