package com.sami.sami_app.api.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HospitalResponse {
    private Long id;
    private String name;
    private Double latitude;
    private Double longitude;
    private String address;
    private String complexityGrade;
    private String specialty; 
    private List<ServicesInHospital> services;
}
