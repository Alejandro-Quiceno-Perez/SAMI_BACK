package com.sami.sami_app.api.dto.response;

import com.sami.sami_app.domain.entities.Ambulance;
import com.sami.sami_app.domain.entities.Customer;
import com.sami.sami_app.domain.entities.Hospital;
import com.sami.sami_app.util.enums.StatusService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceEntityResponse {
    private double latidudeLocation;
    private double longitudeLocation;
    private StatusService statusService;
    private String anamnesis;
    private Hospital hospital;
    private Ambulance ambulance;
    private Customer customer;
}
