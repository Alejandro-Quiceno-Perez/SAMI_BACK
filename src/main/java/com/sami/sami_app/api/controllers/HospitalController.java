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

import com.sami.sami_app.api.dto.request.HospitalRequest;
import com.sami.sami_app.api.dto.response.HospitalResponse;
import com.sami.sami_app.infrastructure.abstract_services.IHospitalService;
import com.sami.sami_app.util.enums.SortType;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/hospital")
@AllArgsConstructor
public class HospitalController {

    @Autowired
    private final IHospitalService iHospitalService;

    @GetMapping
    public ResponseEntity<Page<HospitalResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(this.iHospitalService.getAll(page - 1, size, SortType.NONE));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<HospitalResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.iHospitalService.getById(id));
    }

    @PostMapping(path = "/create")
    public ResponseEntity<HospitalResponse> create(
            @Validated @RequestBody HospitalRequest request) {
        return ResponseEntity.ok(this.iHospitalService.create(request));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.iHospitalService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<HospitalResponse> update(
            @Validated @RequestBody HospitalRequest request,
            @PathVariable Long id) {
        return ResponseEntity.ok(this.iHospitalService.update(request, id));
    }
}
