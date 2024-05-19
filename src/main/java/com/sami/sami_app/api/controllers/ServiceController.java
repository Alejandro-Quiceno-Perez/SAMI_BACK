package com.sami.sami_app.api.controllers;

import java.util.Objects;

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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sami.sami_app.api.dto.request.ServiceEntityRequest;
import com.sami.sami_app.api.dto.response.ServiceEntityResponse;
import com.sami.sami_app.infrastructure.abstract_services.IServiceEntityService;
import com.sami.sami_app.util.enums.SortType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;


/**
 * SERVICE CONTROLLER
 * 
 * this controller is responsible for creating, deleting, modifying and displaying all services in the system.
 */

@RestController
@RequestMapping(path = "/service")
@AllArgsConstructor
//SWAGGER
@Tag(name="Service's controller") 
@Controller
public class ServiceController {

    //dependency injection
    @Autowired
    IServiceEntityService service;

     //SWAGGER 
    @Operation(
        summary = "Displays all Services with pagination and SORT",
        description = "Displays the service in a list, it is configured to display 10 items per page. And can be sorted by NONE, ASC, DESC "
    )
    //method that retrieves a paged list of all available ambulances.
     @GetMapping
    public ResponseEntity<Page<ServiceEntityResponse>> getAll(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestHeader(required = false) SortType sortType
    ){
        
        if (Objects.isNull(sortType)) {
            sortType = SortType.NONE;
        }

        return ResponseEntity.ok(this.service.getAll(page -1, size, sortType));
    }
    
    //SWAGGER
    @Operation(
        summary = "Displays one Service by id",
        description = "Shows the service by the ID sent or requested by path,value cannot be less than 1"
    )
    //method that retrieves an service by ID.
    @GetMapping(path = "/{id}")
    public ResponseEntity<ServiceEntityResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.getById(id));
    }


    //SWAGGER
    @Operation(
        summary = "creates a new service",
        description = "create a new service by entering the required data"
    )
    //method that creates an service
     @PostMapping(path = "/create")
    public ResponseEntity<ServiceEntityResponse> create(
       @Validated @RequestBody ServiceEntityRequest request
    ){
        return ResponseEntity.ok(this.service.create(request));
    }

     //SWAGGER
     @Operation(
        summary = "Delete one service by id",
        description = "deletes an service based on an ID to be sent by Path, value cannot be less than 1."
    )
    //method that eliminates an ambulance
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.service.delete(id);

        return ResponseEntity.noContent().build();
    }


    //SWAGGER
    @Operation(
        summary = "update one service by id",
        description = "updates a previously created service and the ID and the new modified parameters must be sent through the Path, value cannot be less than 1"
    )
    //method that update an ambulance registered
    @PutMapping(path = "/{id}" )
    public ResponseEntity<ServiceEntityResponse> update(
        @Validated @RequestBody ServiceEntityRequest request,
        @PathVariable Long id
    ){
        return ResponseEntity.ok(this.service.update(request, id));
    }

}
