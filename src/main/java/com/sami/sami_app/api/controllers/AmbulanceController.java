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

import com.sami.sami_app.api.dto.request.AmbulanceRequest;
import com.sami.sami_app.api.dto.response.AmbulanceResponse;
import com.sami.sami_app.infrastructure.abstract_services.IAmbulanceService;
import com.sami.sami_app.util.enums.SortType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

/**
 * AMBULANCE CONTROLLER
 * 
 * The AmbulanceController class manages the operations related to *ambulance units.
 * It provides functionality to display all available ambulances, search *for ambulances by ID,
 * create new ambulance records, update existing ambulance information, *and delete ambulances.
 * 
 */


@RestController
@RequestMapping(path = "/ambulance")
@AllArgsConstructor
//SWAGGER
@Tag(name="Ambulance's controller") 
@Controller
public class AmbulanceController {

    //dependency injection
    @Autowired
    private final IAmbulanceService iAmbulanceService; 
        
    //SWAGGER 
    @Operation(
        summary = "Displays all ambulances with pagination",
        description = "Displays the ambulances in a list, it is configured to display 10 items per page."
    )
    //method that retrieves a paged list of all available ambulances.
    @GetMapping
    public ResponseEntity<Page<AmbulanceResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(this.iAmbulanceService.getAll(page - 1, size, SortType.NONE));
    }
    //SWAGGER
    @Operation(
        summary = "Displays one Ambulance by id",
        description = "Shows the ambulance by the ID sent or requested by path, value cannot be less than 1."
    )
    //method that retrieves an ambulance by ID.
    @GetMapping(path = "/{id}")
    public ResponseEntity<AmbulanceResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.iAmbulanceService.getById(id));
    }

    //SWAGGER
    @Operation(
        summary = "creates a new ambulance",
        description = "create a new ambulance by entering the required data"
    )
    //method that creates an ambulance
    @PostMapping
    public ResponseEntity<AmbulanceResponse> create(
            @Validated @RequestBody AmbulanceRequest request) {
        return ResponseEntity.ok(this.iAmbulanceService.create(request));
    }

    //SWAGGER
    @Operation(
        summary = "Delete one ambulance by id",
        description = "deletes an ambulance based on an ID to be sent by Path, value cannot be less than 1."
    )
    //method that eliminates an ambulance
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        //delete ambulance
        this.iAmbulanceService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    //SWAGGER
    @Operation(
        summary = "update one ambulance by id",
        description = "updates a previously created ambulance and the ID and the new modified parameters must be sent through the Path, value cannot be less than 1,"
    )
    //method that update an ambulance registered
    @PutMapping(path = "/{id}")
    public ResponseEntity<AmbulanceResponse> update(
            @Validated @RequestBody AmbulanceRequest request,
            @PathVariable Long id) {
        return ResponseEntity.ok(this.iAmbulanceService.update(request, id));
    }
}
