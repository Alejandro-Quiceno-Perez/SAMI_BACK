package com.sami.sami_app.api.dto.request;

import com.sami.sami_app.domain.entities.Ambulance;
import com.sami.sami_app.domain.entities.Customer;
import com.sami.sami_app.domain.entities.Hospital;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.sami.sami_app.util.enums.StatusService;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceEntityRequest {
    @NotBlank(message = "Latitude is mandatory")
    private double latidudeLocation;
    @NotBlank(message = "Longitude is mandatory")
    private double longitudeLocation;

    @NotBlank(message = "Service status is required")
    private StatusService statusService;

    @Size(
            max = 500,
            message = "The anamnesis must have a maximum of 500 characters"
    )
    private String anamnesis;

    @NotBlank(message = "The hospital is required")
    private Hospital hospital;

    @NotBlank(message = "The Ambulance is required")
    private Ambulance ambulance;

    @NotBlank(message = "The Customer is required")
    private Customer customer;
}
