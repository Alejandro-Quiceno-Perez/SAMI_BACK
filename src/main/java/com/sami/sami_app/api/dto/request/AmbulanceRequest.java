package com.sami.sami_app.api.dto.request;

import com.sami.sami_app.util.enums.AmbulanceType;
import com.sami.sami_app.util.enums.StatusAmbulance;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
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
    @NotBlank(message = "The vehicle plate is required")
    @Size(max = 10, message = "The vehicle plate can have a maximum of 10 characters.")
    private String vehiclePlate;
    
    @Schema(description = "Status of the ambulance - select ALS (Advanced Life Support) - BLS (Basic Life Support) ",example = "BLS")
    @NotNull(message = "The ambulance type is required")
    private AmbulanceType ambulanceType;
    
    @Schema(description = "Status of the ambulance - select ACTIVE - INACTIVE ")
    @NotNull(message = "The ambulance status is required")
    private StatusAmbulance status;
    
    @Schema(description = "Latitude of the ambulance's location", example = "50.1234")
    @DecimalMin(value = "-90.0", inclusive = true, message = "Ambulance - Latitude must be between -90 and 90")
    @DecimalMax(value = "90.0", inclusive = true, message = "Ambulance - Latitude must be between -90 and 90")
    @NotNull(message = "The latitude of the ambulance is required")
    private Double latitudeAmbulance;
    @DecimalMin(value = "-180.0", inclusive = true, message = "Ambulance - Longitude must be between -180 and 180")
    @DecimalMax(value = "180.0", inclusive = true, message = "Ambulance - Longitude must be between -180 and 180")
    
    @NotNull(message = "The longitude of the ambulance is required")
    @Schema(description = "Longitude of the ambulance's location", example = "50.1234")
    private Double longitudeAmbulance;
    
    @Schema(description = "ID of the driver assigned to the ambulance,value cannot be less than 1", example = "1")
    @NotNull(message = "The driver Id is required")
    @Min(value = 1, message = "The id of the driver must be greater than zero")
    private Long idDriver;
    @NotNull(message = "The emt Id is required")
    @Min(value = 1, message = "The id of the emt must be greater than zero")
    private Long idEmt;
}
