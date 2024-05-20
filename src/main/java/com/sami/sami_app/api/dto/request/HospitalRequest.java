package com.sami.sami_app.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import com.sami.sami_app.util.enums.ComplexityGrade;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
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
    
    @NotBlank(message = "The name of the hospital is required")
    @Size(max = 100, message = "The name of the hospital must have a maximum of 100 characters")
    @Schema(description = "Name of the Hospital", example = "SAMI hospital ")
    private String name;
    @NotNull(message = "The latitude of the hospital is required")
    @DecimalMin(value = "-90.0", inclusive = true, message = "Hospital - Latitude must be between -90 and 90")
    @DecimalMax(value = "90.0", inclusive = true, message = "Hospital - Latitude must be between -90 and 90")
    private Double latitudeHospital;
    @DecimalMin(value = "-180.0", inclusive = true, message = "Hospital - Longitude must be between -180 and 180")
    @DecimalMax(value = "180.0", inclusive = true, message = "Hospital - Longitude must be between -180 and 180")
    @NotNull(message = "The longitude of the hospital is required")
    private Double longitudeHospital;
    @NotBlank(message = "The adress of the hospital is required")
    @Size(max = 100, message = "The adress of the hospital must have a maximum of 200 characters")
    @Schema(description = "Adress of the hopsital", example = "happy aveniue 123")
    private String address;
    @NotNull(message = "The complexity grade of the hospital is required")
    private ComplexityGrade complexityGrade;
    @NotNull(message = "The specialty of the hospital is required")
    private String specialty;

}
