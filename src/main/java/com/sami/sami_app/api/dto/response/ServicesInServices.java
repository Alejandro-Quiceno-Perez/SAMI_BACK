package com.sami.sami_app.api.dto.response;

import com.sami.sami_app.util.enums.StatusService;

public class ServicesInServices {

    private long id;
   
    private double latidudeLocation;

    
    private double longitudeLocation;

    private StatusService statusService;

   
    private String anamnesis;

    private HospitalResponse hospital;

    private AmbulanceResponse ambulance;
    private UserResponse client;

    
}
