package com.sami.sami_app.infrastructure.abstract_services.generic;

import java.util.Optional;

public interface ReadService<Response, Id> {
    Optional<Response> getById(Long id);
}
