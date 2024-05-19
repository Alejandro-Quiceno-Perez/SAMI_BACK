package com.sami.sami_app.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.sami.sami_app.util.enums.StatusService;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.DecimalMax;
/**
 * SERVICE REQUEST DTO
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO for service entity requests")
public class ServiceEntityRequest {
    
    private Long id;
    @DecimalMin(value = "-90.0", inclusive = true, message = "Latitude must be between -90 and 90")
    @DecimalMax(value = "90.0", inclusive = true, message = "Latitude must be between -90 and 90")
    @Schema(description = "latituted of the service's location", example = "50.1234")
    private double latidudeLocation;

    @DecimalMin(value = "-180.0", inclusive = true, message = "Longitude must be between -180 and 180")
    @DecimalMax(value = "180.0", inclusive = true, message = "Longitude must be between -180 and 180")
    
    @Schema(description = "Longitude of the service's location", example = "50.1234")
    private double longitudeLocation;
    
    @Schema(description = "Status of Services, this can be  INACTIVE, ACTIVE, CANCELED",example="ACTIVE")
    private StatusService statusService;
    
    @Size(max = 500, message = "The anamnesis must have a maximum of 500 characters")
    @Schema(description = "Description of the anamnesis ", example = "patient due to bicycle accident, fracture of left foot with multiple ematomas ")
    private String anamnesis;

    @NotNull(message = "the ID of the Hospital is necessary,value cannot be less than 1")
    @Schema(description = "ID of the Hospital", example = "1")
    private Long idHospital;

    @NotNull(message = "the ID of the Ambulance is necessary,value cannot be less than 1")
    @Schema(description = "ID of the ambulance", example = "1")
    private Long idAmbulance;

    @NotNull(message = "the ID of the client is necessary,value cannot be less than 1")
    @Schema(description = "ID of the client", example = "1")
    private Long idClient;
}
