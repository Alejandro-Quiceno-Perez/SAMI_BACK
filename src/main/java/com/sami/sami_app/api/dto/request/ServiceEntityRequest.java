package com.sami.sami_app.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.sami.sami_app.util.enums.StatusService;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.DecimalMax;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceEntityRequest {
    @DecimalMin(value = "-90.0", inclusive = true, message = "Service - Latitude must be between -90 and 90")
    @DecimalMax(value = "90.0", inclusive = true, message = "Service - Latitude must be between -90 and 90")
    @NotNull(message = "The latitude of the service is required")
    private double latidudeService;

    @DecimalMin(value = "-180.0", inclusive = true, message = "Service - Longitude must be between -180 and 180")
    @DecimalMax(value = "180.0", inclusive = true, message = "Service - Longitude must be between -180 and 180")
    @NotNull(message = "The longitude of the service is required")
    private double longitudeService;

    @NotNull(message = "The status of the service is required")
    private StatusService statusService;

    @Size(max = 500, message = "The anamnesis must have a maximum of 500 characters")
    private String anamnesis;

    @NotNull(message = "the ID of the Hospital is necessary")
    @Min(value = 1, message = "The id of the hospital must be greater than zero")
    private Long idHospital;

    @NotNull(message = "the ID of the Ambulance is necessary")
    @Min(value = 1, message = "The id of the ambulance must be greater than zero")
    private Long idAmbulance;

    @NotNull(message = "the ID of the client is necessary")
    @Min(value = 1, message = "The id of the client must be greater than zero")
    private Long idClient;
}
