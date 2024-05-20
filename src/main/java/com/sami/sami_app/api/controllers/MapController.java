package com.sami.sami_app.api.controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.sami.sami_app.api.dto.response.ServiceEntityResponse;
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
    @Autowired
    private ServiceEntityService serviceEntityService;

    @PostMapping("/locations/{id}")
    public Map<String, String> getAllLocations(@PathVariable Long id) {

        Map<String, String> locations = new HashMap<>();

        ServiceEntityResponse serviceEntityResponse = this.serviceEntityService.getById(id);

        // SERVICE
        Double serviceLatitude = serviceEntityResponse.getLatitudeService();
        Double serviceLongitude = serviceEntityResponse.getLongitudeService();

        // AMBULANCE
        Double ambulanceLatitude = serviceEntityResponse.getAmbulance().getLatitudeAmbulance();
        Double ambulanceLongitude = serviceEntityResponse.getAmbulance().getLongitudeAmbulance();

        // HOSPITAL
        Double hospitalLatitude = serviceEntityResponse.getHospital().getLatitudeHospital();
        Double hospitalLongitude = serviceEntityResponse.getHospital().getLongitudeHospital();

        locations.put("Service", mapService.getPosition(serviceLatitude, serviceLongitude));
        locations.put("Ambulance", mapService.getPosition(ambulanceLatitude, ambulanceLongitude));
        locations.put("Hospital", mapService.getPosition(hospitalLatitude, hospitalLongitude));

        //returns all locations 
        return locations;
    }
}
