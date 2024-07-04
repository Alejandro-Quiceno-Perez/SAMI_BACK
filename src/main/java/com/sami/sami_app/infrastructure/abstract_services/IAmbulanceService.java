package com.sami.sami_app.infrastructure.abstract_services;

import com.sami.sami_app.api.dto.request.create.AmbulanceRequest;
import com.sami.sami_app.api.dto.response.AmbulanceResponse;
import com.sami.sami_app.infrastructure.abstract_services.generic.CreateService;
import com.sami.sami_app.infrastructure.abstract_services.generic.DeleteService;
import com.sami.sami_app.infrastructure.abstract_services.generic.ReadAllService;
import com.sami.sami_app.infrastructure.abstract_services.generic.ReadService;
import com.sami.sami_app.infrastructure.abstract_services.generic.UpdateService;

public interface IAmbulanceService extends 
    CreateService<AmbulanceRequest,AmbulanceResponse>,
    DeleteService<String>,                               
    ReadAllService<AmbulanceResponse>,
    ReadService<AmbulanceResponse,String>,
    UpdateService<AmbulanceRequest,AmbulanceResponse, String> {
    

}
