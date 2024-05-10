package com.sami.sami_app.api.controllers;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
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

import com.sami.sami_app.api.dto.request.CustomerRequest;
import com.sami.sami_app.api.dto.response.CustomerResponse;
import com.sami.sami_app.infrastructure.abstract_services.ICustomerService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/customer")
@AllArgsConstructor
public class CustomerController {
    
    @Autowired
    private final ICustomerService customer;

    @GetMapping
    public ResponseEntity<Page<CustomerResponse>> getAll(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(this.customer.getAll(page -1, size));
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<CustomerResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.customer.getById(id));
    }
        
    @PostMapping
    public ResponseEntity<CustomerResponse> create(
       @Validated @RequestBody CustomerRequest request
    ) {
        return ResponseEntity.ok(this.customer.create(request));
    }
    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.customer.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}" )
    public ResponseEntity<CustomerResponse> update(
        @Validated @RequestBody CustomerRequest request,
        @PathVariable Long id
    ){
        return ResponseEntity.ok(this.customer.update(request, id));
    }
}
