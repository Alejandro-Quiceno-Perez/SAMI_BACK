package com.sami.sami_app.api.dto.response;

import java.math.BigDecimal;

import com.sami.sami_app.util.enums.StatusService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceEntityResponse {
    private long idService;
    private double latitudeService;
    private double longitudeService;
    private BigDecimal price;
    private StatusService statusService;
    private String anamnesis;
    private HospitalBasicResponse hospital;
    private AmbulanceResponse ambulance;
    private UserResponse client;

}
