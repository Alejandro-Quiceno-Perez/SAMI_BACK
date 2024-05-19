package com.sami.sami_app.api.controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.sami.sami_app.api.dto.request.LocationsRequest;
import com.sami.sami_app.infrastructure.abstract_services.IMapService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


/**
 * MAP CONTROLLER
 * 
 * The map controller is in charge of all the management of capturing the *location (latitude-longitude) of the service, ambulance and hospital.
 */

 
//SWAGGER
@Tag(name="Map controller") 
@Controller
public class MapController {

    @Autowired
    private IMapService mapService;

    //SWAGGER 
    @Operation(
        summary = "Capture all service locations",
        description = "captures the latitude and longitude of the service, ambulance and hospital."
    )
     @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved list"),
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        @ApiResponse(responseCode = "401", description = "Unauthorized"),
        @ApiResponse(responseCode = "403", description = "Forbidden"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    //method in charge of capturing all locations of services, ambulances and hospitals.
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

        //returns all locations 
        return locations;
    }
}
