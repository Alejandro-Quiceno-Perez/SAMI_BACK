package com.sami.sami_app.api.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HospitalBasicResponse {
    private Long id;
    private String name;
    private Double latitude;
    private Double longitude;
    private String address;
    private String complexityGrade;
    private String specialty; 
}
