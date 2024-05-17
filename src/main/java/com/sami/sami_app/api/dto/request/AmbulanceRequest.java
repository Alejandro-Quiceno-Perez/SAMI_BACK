package com.sami.sami_app.api.dto.request;

import com.sami.sami_app.util.enums.StatusAmbulance;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AmbulanceRequest {
    @NotBlank(message = "Te vehicle plate is required")
    @Size(max = 10, message = "The vehicle plate can have a maximum of 10 characters.")
    private String vehiclePlate;
    @NotBlank(message = "Te ambulance type is required")
    @Size(max = 50, message = "The ambulance type can have a maximum of 50 characters.")
    private String ambulanceType;
    @NotNull(message = "The ambulance status is required")
    private StatusAmbulance status;
    @NotNull(message = "The latitude is required")
    private Double latitude;
    @NotNull(message = "The longitude is required")
    private Double longitude;
    @NotNull(message = "The driver Id is required")
    private Long driverId;
    @NotNull(message = "The emt Id is required")
    private Long emtId;
}
