package com.sami.sami_app.infrastructure.abstract_services;

import com.sami.sami_app.api.dto.request.AmbulanceRequest;
import com.sami.sami_app.api.dto.response.AmbulanceResponse;

public interface IAmbulanceService extends CrudService<AmbulanceRequest, AmbulanceResponse, Long> {

}
