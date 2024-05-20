package com.sami.sami_app.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sami.sami_app.api.dto.request.HospitalRequest;
import com.sami.sami_app.api.dto.response.HospitalResponse;
import com.sami.sami_app.infrastructure.abstract_services.IHospitalService;
import com.sami.sami_app.util.enums.SortType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

/**
 * AMBULANCE CONTROLLER
 * 
 *The HospitalController class manages the operations related to the *Hospitals managed by the API.
 *Provides functionality to display all available hospitals, search for *Hospitals by ID, create new Hospital records, update existing hospital *information and delete ambulances,
 *create new Hospital records, update existing hospital information and *delete ambulances.
 * 
 */

@RestController
@RequestMapping(path = "/hospital")
@AllArgsConstructor
//SWAGGER
@Tag(name="Hospital's controller") 
@Controller
public class HospitalController {

    //dependency injection
    @Autowired
    private final IHospitalService iHospitalService;

    //SWAGGER 
    @Operation(
        summary = "Displays all hospitals with pagination",
        description = "Displays the hospitals in a list, it is configured to display 10 items per page."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved Hospital List"),
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        @ApiResponse(responseCode = "401", description = "Not authorized to view the list of hospitals. Invalid token"),
        @ApiResponse(responseCode = "403", description = "Forbidden access"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error. Please contact support")
    })
    //method that retrieves a paged list of all available hospitals.
    @GetMapping
    public ResponseEntity<Page<HospitalResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(this.iHospitalService.getAll(page - 1, size, SortType.NONE));
    }

    //SWAGGER
    @Operation(
        summary = "Displays one Hospital by id",
        description = "Shows the Hospital by the ID sent or requested by path,value cannot be less than 1."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved Hospital"),
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        @ApiResponse(responseCode = "401", description = "Not authorized to view the hospital. Invalid token"),
        @ApiResponse(responseCode = "403", description = "Forbidden access"),
        @ApiResponse(responseCode = "404", description = "Hospital not found"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error. Please contact support")
    })
    //method that retrieves an hospital by ID.
    @GetMapping(path = "/{id}")
    public ResponseEntity<HospitalResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.iHospitalService.getById(id));
    }

    //SWAGGER
    @Operation(
        summary = "creates a new hospital",
        description = "create a new hospital by entering the required data"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Successfully created Hospital"),
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        @ApiResponse(responseCode = "401", description = "Not authorized to create a hospital. Invalid token"),
        @ApiResponse(responseCode = "403", description = "Forbidden access"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error. Please contact support")
    })
    //method that creates an Hospital
    @PostMapping(path = "/create")
    public ResponseEntity<HospitalResponse> create(
            @Validated @RequestBody HospitalRequest request) {
        return ResponseEntity.ok(this.iHospitalService.create(request));
    }

     //SWAGGER
     @Operation(
        summary = "Delete one hospital by id",
        description = "deletes an hospital based on an ID to be sent by Path, value cannot be less than 1"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully deleted Hospital"),
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        @ApiResponse(responseCode = "401", description = "Not authorized to delete the hospital. Invalid token"),
        @ApiResponse(responseCode = "403", description = "Forbidden access"),
        @ApiResponse(responseCode = "404", description = "Hospital not found"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error. Please contact support")
    })
    //method that eliminates an hospital
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.iHospitalService.delete(id);
        return ResponseEntity.noContent().build();
    }


    //SWAGGER
    @Operation(
        summary = "update one Hospital by id",
        description = "updates a previously created hospital and the ID and the new modified parameters must be sent through the Path, value cannot be less than 1"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully updated Hospital"),
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        @ApiResponse(responseCode = "401", description = "Not authorized to update the hospital. Invalid token"),
        @ApiResponse(responseCode = "403", description = "Forbidden access"),
        @ApiResponse(responseCode = "404", description = "Hospital not found"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error. Please contact support")
    })
    
    //method that update an hopsital registered
    @PutMapping(path = "/update/{id}")

    public ResponseEntity<HospitalResponse> update(
            @Validated @RequestBody HospitalRequest request,
            @PathVariable Long id) {
        return ResponseEntity.ok(this.iHospitalService.update(request, id));
    }
}
