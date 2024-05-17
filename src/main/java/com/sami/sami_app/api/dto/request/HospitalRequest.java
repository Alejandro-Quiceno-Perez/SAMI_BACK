package com.sami.sami_app.api.dto.request;

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
public class HospitalRequest {
    @NotBlank(message ="The name of the hospital is required")
    @Size(max = 100, message = "The name of the hospital must have a maximum of 100 characters")
    private String name;
    @NotNull(message ="The latitude of the hospital is required")
    private Double latitude;
    @NotNull(message ="The longitude of the hospital is required")
    private Double longitude;
    @NotBlank(message = "The adress of the hospital is required")
    @Size(max = 100, message = "The adress of the hospital must have a maximum of 200 characters")
    private String address;
    @NotNull(message = "The hospital level is required")
    @Size(max = 100, message = "The hospital level must have a maximum of 50 characters")
    private String complexityGrade;
    @NotNull(message ="The specialty of the hospital is required")
    private String specialty;
    
}
