package com.sami.sami_app.api.dto.response;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO for hospital responses")
public class HospitalResponse {
    @Schema(description = "ID of the hospital", example = "1")
    private Long id;
    @Schema(description = "Name of the hospital", example = "Hospital General de Medellín")
    private String name;
    @Schema(description = "Latitude of the hospital's location", example = "40.7128")
    private Double latitude;
    @Schema(description = "Longitude of the hospital's location", example = "-74.0060")
    private Double longitude;
    @Schema(description = "Address of the hospital", example = "happy avenue 123")
    private String address;
    @Schema(description = "Grade of complexity of the hospital", example = "Level 1")
    private String complexityGrade;
    @Schema(description = "Specialty of the hospital", example = "Cardiology")
    private String specialty; 
    @Schema(description = "List of services offered by the hospital")
    private List<ServicesInHospital> services;
}
