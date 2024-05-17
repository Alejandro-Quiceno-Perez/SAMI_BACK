package com.sami.sami_app.api.controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.sami.sami_app.api.dto.response.ServiceEntityResponse;
import com.sami.sami_app.infrastructure.abstract_services.IMapService;
import com.sami.sami_app.infrastructure.services.ServiceEntityService;

@Controller
public class MapController {

    @Autowired
    private IMapService mapService;

    @Autowired
    private ServiceEntityService serviceEntityService;

    @PostMapping("/locations/{id}")
    public Map<String, String> getAllLocations(@PathVariable Long id) {

        Map<String, String> locations = new HashMap<>();

        ServiceEntityResponse serviceEntityResponse = this.serviceEntityService.getById(id);

        // SERVICE
        Double serviceLatitude = serviceEntityResponse.getLatidudeLocation();
        Double serviceLongitude = serviceEntityResponse.getLongitudeLocation();

        // AMBULANCE
        Double ambulanceLatitude = serviceEntityResponse.getAmbulance().getLatitude();
        Double ambulanceLongitude = serviceEntityResponse.getAmbulance().getLongitude();

        // HOSPITAL
        Double hospitalLatitude = serviceEntityResponse.getHospital().getLatitude();
        Double hospitalLongitude = serviceEntityResponse.getHospital().getLongitude();

        locations.put("Service", mapService.getPosition(serviceLatitude, serviceLongitude));
        locations.put("Ambulance", mapService.getPosition(ambulanceLatitude, ambulanceLongitude));
        locations.put("Hospital", mapService.getPosition(hospitalLatitude, hospitalLongitude));

        return locations;
    }
}
