package com.sami.sami_app.api.dto.request;

import com.sami.sami_app.domain.entities.Ambulance;
import com.sami.sami_app.domain.entities.Hospital;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.sami.sami_app.util.enums.StatusService;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.DecimalMax;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceEntityRequest {
    @DecimalMin(value = "-90.0", inclusive = true, message = "Latitude must be between -90 and 90")
    @DecimalMax(value = "90.0", inclusive = true, message = "Latitude must be between -90 and 90")
    private double latidudeLocation;

    @DecimalMin(value = "-180.0", inclusive = true, message = "Longitude must be between -180 and 180")
    @DecimalMax(value = "180.0", inclusive = true, message = "Longitude must be between -180 and 180")
    private double longitudeLocation;

    private StatusService statusService;

    @Size(max = 500, message = "The anamnesis must have a maximum of 500 characters")
    private String anamnesis;

    @NotNull(message = "Hospital is necesary")
    private Hospital hospital;

    @NotNull(message = "Ambulance is necesary")
    private Ambulance ambulance;
}
