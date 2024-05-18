package com.sami.sami_app.api.dto.request;

import com.sami.sami_app.util.enums.StatusAmbulance;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * AMBULANCE REQUEST DTO
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO for ambulance requests")
public class AmbulanceRequest {
    @Schema(description = "Vehicle plate of the ambulance", example = "ABC123")
    @NotBlank(message = "Te vehicle plate is required")
    @Size(max = 10, message = "The vehicle plate can have a maximum of 10 characters.")
    private String vehiclePlate;
    @Schema(description = "Status of the ambulance - select ALS (Advanced Life Support) - BLS (Basic Life Support) ",example = "BLS")
    @NotBlank(message = "Te ambulance type is required")
    @Size(max = 50, message = "The ambulance type can have a maximum of 50 characters.")
    private String ambulanceType;
    @Schema(description = "Status of the ambulance - select ACTIVE - INACTIVE ")
    @NotNull(message = "The ambulance status is required")
    private StatusAmbulance status;
    @Schema(description = "Latitude of the ambulance's location", example = "50.1234")
    @NotNull(message = "The latitude is required")
    private Double latitude;
    @NotNull(message = "The longitude is required")
    @Schema(description = "Longitude of the ambulance's location", example = "50.1234")
    private Double longitude;
    @Schema(description = "ID of the driver assigned to the ambulance", example = "1")
    @NotNull(message = "The driver Id is required")
    private Long driverId;
    @NotNull(message = "The emt Id is required")
    @Schema(description = "ID of the emergency medical technician assigned to the ambulance", example = "1")
    private Long emtId;
}
