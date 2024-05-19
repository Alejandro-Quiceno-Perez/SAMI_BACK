package com.sami.sami_app.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "DTO for Hospital requests")
public class HospitalRequest {
    
    @NotBlank(message ="The name of the hospital is required")
    @Size(max = 100, message = "The name of the hospital must have a maximum of 100 characters")
    @Schema(description = "Name of the Hospital", example = "SAMI hospital ")
    private String name;
    
    @NotNull(message ="The latitude of the hospital is required")
    @Schema(description = "Latitude of the hospital location", example = "50.1234")
    private Double latitude;
    
    @NotNull(message ="The longitude of the hospital is required")
    @Schema(description = "Longitude of the hospital location", example = "50.1234")
    private Double longitude;
    
    @NotBlank(message = "The adress of the hospital is required")
    @Size(max = 100, message = "The adress of the hospital must have a maximum of 200 characters")
    @Schema(description = "Adress of the hopsital", example = "happy aveniue 123")
    private String address;
    
    @NotNull(message = "The hospital level is required")
    @Size(max = 100, message = "The hospital level must have a maximum of 50 characters")
    @Schema(description = "Enter the degree of emergency which may be from 1 to 3 ",example = "1")
    private String complexityGrade;
    
    @NotNull(message ="The specialty of the hospital is required")
    @Schema(description = "short description of hospital specialties",example = "this hospital is specialized in cardiac emergencies")
    private String specialty;
    
}
