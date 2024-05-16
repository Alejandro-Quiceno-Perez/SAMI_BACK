package com.sami.sami_app.api.controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.sami.sami_app.api.dto.request.LocationsRequest;
import com.sami.sami_app.domain.entities.Ambulance;
import com.sami.sami_app.domain.entities.Hospital;
import com.sami.sami_app.domain.entities.ServiceEntity;
import com.sami.sami_app.infrastructure.abstract_services.IMapService;
import com.sami.sami_app.infrastructure.services.ServiceEntityService;

@Controller
public class MapController {

    @Autowired
    private IMapService mapService;

    @Autowired
    private ServiceEntityService serviceEntityService;

    @Autowired
    private AmbulanceService ambulanceService;

    @Autowired
    private HospitalService hospitalService;

    

   @PostMapping("/locations")
public Map<String, String> getAllLocations() {
    Map<String, String> locations = new HashMap<>();
    
    //USER
    ServiceEntity service = serviceEntityService.findById(id);
    Double serviceLatitude = service.getLatitude();
    Double serviceLongitude = service.getLongitude();
    
    //AMBULANCE
    Ambulance ambulance = ambulanceService.findById(idDeLaAmbulancia);
    Double ambulanceLatitude = ambulance.getLatitude();
    Double ambulanceLongitude = ambulance.getLongitude();
    
    //HOSPITAL
    Hospital hospital = hospitalService.findById(idDelHospital);
    Double hospitalLatitude = hospital.getLatitude();
    Double hospitalLongitude = hospital.getLongitude();
    
   
    locations.put("Service", mapService.getPosition(serviceLatitude, serviceLongitude));
    locations.put("Ambulance", mapService.getPosition(ambulanceLatitude, ambulanceLongitude));
    locations.put("Hospital", mapService.getPosition(hospitalLatitude, hospitalLongitude));

    return locations;
}
}