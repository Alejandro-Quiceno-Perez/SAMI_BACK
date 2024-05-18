package com.sami.sami_app.api.dto.response;


import com.sami.sami_app.util.enums.StatusAmbulance;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO for ambulance responses")
public class AmbulanceResponse {

    @Schema(description = "ID of the ambulance", example = "1")
    private Long id;
    @Schema(description = "Vehicle plate of the ambulance", example = "ABC123")
    private String vehiclePlate;
    @Schema(description = "Type of the ambulance",example = "ALS")
    private String ambulanceType;
    @Schema(description = "Status of the ambulance",example = "INACTIVE")
    private StatusAmbulance status;
    @Schema(description = "Latitude of the ambulance's location")
    private Double latitude;
    @Schema(description = "Longitude of the ambulance's location")
    private Double longitude;
    @Schema(description = "Driver assigned to the ambulance")
    private UserResponse driver;
    @Schema(description = "Emergency medical technician assigned to the ambulance")
    private UserResponse emt;
}
