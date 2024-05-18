package com.sami.sami_app.api.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sami.sami_app.api.dto.request.AmbulanceRequest;
import com.sami.sami_app.api.dto.response.AmbulanceResponse;
import com.sami.sami_app.infrastructure.abstract_services.IAmbulanceService;
import com.sami.sami_app.util.enums.SortType;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/ambulance")
@AllArgsConstructor
public class AmbulanceController {

    @Autowired
    private final IAmbulanceService iAmbulanceService;

    @GetMapping
    public ResponseEntity<Page<AmbulanceResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(this.iAmbulanceService.getAll(page - 1, size, SortType.NONE));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AmbulanceResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.iAmbulanceService.getById(id));
    }

    @PostMapping(path = "/create")
    public ResponseEntity<AmbulanceResponse> create(
            @Validated @RequestBody AmbulanceRequest request) {
        return ResponseEntity.ok(this.iAmbulanceService.create(request));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.iAmbulanceService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<AmbulanceResponse> update(
            @Validated @RequestBody AmbulanceRequest request,
            @PathVariable Long id) {
        return ResponseEntity.ok(this.iAmbulanceService.update(request, id));
    }
}
