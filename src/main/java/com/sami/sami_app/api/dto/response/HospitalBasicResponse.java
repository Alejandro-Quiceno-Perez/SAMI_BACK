package com.sami.sami_app.api.dto.response;

import com.sami.sami_app.util.enums.ComplexityGrade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HospitalBasicResponse {
    private Long idHospital;
    private String name;
    private Double latitudeHospital;
    private Double longitudeHospital;
    private String address;
    private ComplexityGrade complexityGrade;
    private String specialty;
}
