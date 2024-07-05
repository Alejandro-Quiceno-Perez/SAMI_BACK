package com.sami.sami_app.api.controllers;


import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sami.sami_app.api.dto.request.create.AmbulanceRequest;
import com.sami.sami_app.api.dto.response.AmbulanceResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

/**
 * AMBULANCE CONTROLLER
 * 
 * The AmbulanceController class manages the operations related to *ambulance
 * units.
 * It provides functionality to display all available ambulances, search *for
 * ambulances by ID,
 * create new ambulance records, update existing ambulance information, *and
 * delete ambulances.
 * 
 */

@RestController
@RequestMapping(path = "/ambulance")
@AllArgsConstructor
// SWAGGER
@Tag(name = "Ambulance's controller")
@Controller
@CrossOrigin(origins = "*")
public class AmbulanceController {

    

    // SWAGGER
    @Operation(summary = "Displays all ambulances with pagination", description = "Displays the ambulances in a list, it is configured to display 10 items per page.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved Ambulance List"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "401", description = "Not authorized to view the list of ambulances. invalid token"),
            @ApiResponse(responseCode = "403", description = "Forbidden access."),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.please contact support")
    })
    // method that retrieves a paged list of all available ambulances.
    @GetMapping
    public ResponseEntity<Page<AmbulanceResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return null;
    }

    // SWAGGER
    @Operation(summary = "Displays one Ambulance by id", description = "Shows the ambulance by the ID sent or requested by path, value cannot be less than 1.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved Ambulance"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "401", description = "Not authorized to view the ambulance. Invalid token"),
            @ApiResponse(responseCode = "403", description = "Forbidden access"),
            @ApiResponse(responseCode = "404", description = "Ambulance not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error. Please contact support")
    })
    // method that retrieves an ambulance by ID.
    @GetMapping(path = "/{id}")
    public ResponseEntity<AmbulanceResponse> getById(@PathVariable Long id) {
        return null;
    }

    // SWAGGER
    @Operation(summary = "creates a new ambulance", description = "create a new ambulance by entering the required data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created Ambulance"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "401", description = "Not authorized to create an ambulance. Invalid token"),
            @ApiResponse(responseCode = "403", description = "Forbidden access"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error. Please contact support")
    })

    // method that creates an ambulance
    @PostMapping(path = "/create")
    public ResponseEntity<AmbulanceResponse> create(
            @Validated @RequestBody AmbulanceRequest request) {
                return null;
    }

    // SWAGGER
    @Operation(summary = "Delete one ambulance by id", description = "deletes an ambulance based on an ID to be sent by Path, value cannot be less than 1.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted Ambulance"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "401", description = "Not authorized to delete the ambulance. Invalid token"),
            @ApiResponse(responseCode = "403", description = "Forbidden access"),
            @ApiResponse(responseCode = "404", description = "Ambulance not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error. Please contact support")
    })
    // method that eliminates an ambulance

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        
        return null;
    }

    // SWAGGER
    @Operation(summary = "update one ambulance by id", description = "updates a previously created ambulance and the ID and the new modified parameters must be sent through the Path, value cannot be less than 1,")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated Ambulance"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "401", description = "Not authorized to update the ambulance. Invalid token"),
            @ApiResponse(responseCode = "403", description = "Forbidden access"),
            @ApiResponse(responseCode = "404", description = "Ambulance not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error. Please contact support")
    })
    // method that update an ambulance registered
    @PutMapping(path = "/update/{id}")
    public ResponseEntity<AmbulanceResponse> update(
            @Validated @RequestBody AmbulanceRequest request,
            @PathVariable Long id) {
                return null;
    }
}
