package com.sami.sami_app.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sami.sami_app.api.dto.response.LocationsResponse;
import com.sami.sami_app.api.dto.response.ServiceEntityResponse;
import com.sami.sami_app.infrastructure.abstract_services.IMapService;
import com.sami.sami_app.infrastructure.services.ServiceEntityService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * MAP CONTROLLER
 * 
 * The map controller is in charge of all the management of capturing the
 * *location (latitude-longitude) of the service, ambulance and hospital.
 */

// SWAGGER
@Tag(name = "Map controller")
@RestController
@RequestMapping(path = "/map")
@CrossOrigin(origins = "*")
public class MapController {

    @SuppressWarnings("unused")
    @Autowired
    private IMapService iMapService;

    // inyects the service repository
    @Autowired
    private ServiceEntityService serviceEntityService;

    // SWAGGER
    @Operation(summary = "Capture all service locations", description = "captures the latitude and longitude of the service, ambulance and hospital.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/locations/{id}")
    public LocationsResponse getAllLocations(@PathVariable Long id) {

        // search service by id
        ServiceEntityResponse serviceEntityResponse = this.serviceEntityService.getById(id);

        // returns all locations
        return LocationsResponse
                .builder()
                .serviceLatitude(serviceEntityResponse.getLatitudeService())
                .serviceLongitude(serviceEntityResponse.getLongitudeService())
                .ambulanceLatitude(serviceEntityResponse.getAmbulance().getLatitudeAmbulance())
                .ambulanceLongitude(serviceEntityResponse.getAmbulance().getLongitudeAmbulance())
                .hospitalLatitude(serviceEntityResponse.getHospital().getLatitudeHospital())
                .hospitalLongitude(serviceEntityResponse.getHospital().getLongitudeHospital())
                .build();
    }
}
