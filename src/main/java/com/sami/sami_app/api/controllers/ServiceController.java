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

import com.sami.sami_app.api.dto.request.ServiceEntityRequest;
import com.sami.sami_app.api.dto.response.ServiceEntityResponse;
import com.sami.sami_app.infrastructure.abstract_services.IServiceEntityService;
import com.sami.sami_app.util.enums.SortType;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/service")
@AllArgsConstructor
public class ServiceController {

    @Autowired
    IServiceEntityService service;

    @GetMapping
    public ResponseEntity<Page<ServiceEntityResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestHeader(required = false) SortType sortType) {

        if (Objects.isNull(sortType)) {
            sortType = SortType.NONE;
        }

        return ResponseEntity.ok(this.service.getAll(page - 1, size, sortType));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ServiceEntityResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.getById(id));
    }

    @PostMapping(path = "/create")
    public ResponseEntity<ServiceEntityResponse> create(
            @Validated @RequestBody ServiceEntityRequest request) {
        return ResponseEntity.ok(this.service.create(request));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<ServiceEntityResponse> update(
            @Validated @RequestBody ServiceEntityRequest request,
            @PathVariable Long id) {
        return ResponseEntity.ok(this.service.update(request, id));
    }

}
