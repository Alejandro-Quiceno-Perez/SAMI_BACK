package com.sami.sami_app.api.controllers;

import com.sami.sami_app.util.enums.SortType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.sami.sami_app.api.dto.request.create.UserRequest;
import com.sami.sami_app.api.dto.response.UserResponse;
import com.sami.sami_app.infrastructure.abstract_services.IUserService;

import lombok.AllArgsConstructor;

/**
 * USER CONTROLLER
 * 
 * this controller is responsible for creating, deleting, modifying and displaying all users in the system.
 */

@RestController
@RequestMapping(path = "/user")
@AllArgsConstructor
@Controller
@CrossOrigin(origins = "*")
public class UserController {

    //dependency injection
    @Autowired
    private final IUserService objIUserService;

    //SWAGGER 
    @Operation(
        summary = "Displays all Users with pagination and SORT",
        description = "Displays the users in a list, it is configured to display 10 items per page. "
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved User List"),
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        @ApiResponse(responseCode = "401", description = "Not authorized to view the list of users. Invalid token"),
        @ApiResponse(responseCode = "403", description = "Forbidden access"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error. Please contact support")
    })
    //method that retrieves a paged list of all available ambulances.
    @GetMapping
    public ResponseEntity<Page<UserResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
                return null;
    }

    //SWAGGER
    @Operation(
        summary = "Displays one user by id",
        description = "Shows the user by the ID sent or requested by path,value cannot be less than 1."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved User"),
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        @ApiResponse(responseCode = "401", description = "Not authorized to view the user. Invalid token"),
        @ApiResponse(responseCode = "403", description = "Forbidden access"),
        @ApiResponse(responseCode = "404", description = "User not found"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error. Please contact support")
    })
    //method that retrieves an user by ID.
    @GetMapping(path = "/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Long id) {
        return null;
    }

     //SWAGGER
     @Operation(
        summary = "creates a new user",
        description = "create a new user by entering the required data"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Successfully created User"),
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        @ApiResponse(responseCode = "401", description = "Not authorized to create a user. Invalid token"),
        @ApiResponse(responseCode = "403", description = "Forbidden access"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error. Please contact support")
    })
    //method that creates an user
    @PostMapping(path = "/create")
    public ResponseEntity<UserResponse> create(
            @Validated @RequestBody UserRequest request) {
                return null;
    }


    //SWAGGER
    @Operation(
        summary = "Delete user by ID",
        description = "deletes an user based on an ID to be sent by Path,value cannot be less than 1"
    ) 
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully deleted User"),
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        @ApiResponse(responseCode = "401", description = "Not authorized to delete the user. Invalid token"),
        @ApiResponse(responseCode = "403", description = "Forbidden access"),
        @ApiResponse(responseCode = "404", description = "User not found"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error. Please contact support")
    })
    //method that eliminates an ambulance
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return null;
    }

    //SWAGGER
    @Operation(
        summary = "update  user by ID",
        description = "updates a previously created user and the ID and the new modified parameters must be sent through the Path, value cannot be less than 1"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully updated User"),
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        @ApiResponse(responseCode = "401", description = "Not authorized to update the user. Invalid token"),
        @ApiResponse(responseCode = "403", description = "Forbidden access"),
        @ApiResponse(responseCode = "404", description = "User not found"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error. Please contact support")
    })
    //method that update an user registered
    @PutMapping(path = "/update/{id}")
    public ResponseEntity<UserResponse> update(
            @Validated @RequestBody UserRequest request,
            @PathVariable Long id) {
                return null;
    }
}
