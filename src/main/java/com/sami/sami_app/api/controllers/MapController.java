package com.sami.sami_app.api.controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.sami.sami_app.api.dto.request.LocationsRequest;
import com.sami.sami_app.infrastructure.abstract_services.IMapService;

@Controller
public class MapController {

    @Autowired
    private IMapService mapService;

    @PostMapping("/locations")
    public Map<String, String> getAllLocations(@RequestBody LocationsRequest locationsRequest) {
        Double serviceLatitude = locationsRequest.getServiceLatitude();
        Double serviceLongitude = locationsRequest.getServiceLongitude();
        Double ambulanceLatitude = locationsRequest.getAmbulanceLatitude();
        Double ambulanceLongitude = locationsRequest.getAmbulanceLongitude();
        Double hospitalLatitude = locationsRequest.getHospitalLatitude();
        Double hospitalLongitude = locationsRequest.getHospitalLongitude();

        Map<String, String> locations = new HashMap<>();
        locations.put("Service", mapService.getLocationAddress(serviceLatitude, serviceLongitude));
        locations.put("Ambulance", mapService.getLocationAddress(ambulanceLatitude, ambulanceLongitude));
        locations.put("Hospital", mapService.getLocationAddress(hospitalLatitude, hospitalLongitude));

        return locations;
    }
}
