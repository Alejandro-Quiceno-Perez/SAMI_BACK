package com.sami.sami_app.infrastructure.abstract_services;

import org.springframework.stereotype.Service;


import com.sami.sami_app.api.dto.request.create.HospitalRequest;
import com.sami.sami_app.api.dto.response.HospitalResponse;
import com.sami.sami_app.infrastructure.abstract_services.generic.CreateService;
import com.sami.sami_app.infrastructure.abstract_services.generic.DeleteService;
import com.sami.sami_app.infrastructure.abstract_services.generic.ReadAllService;
import com.sami.sami_app.infrastructure.abstract_services.generic.ReadService;
import com.sami.sami_app.infrastructure.abstract_services.generic.UpdateService;

@Service
public interface IHospitalService extends 
    CreateService<HospitalRequest,HospitalResponse>,
    DeleteService<String>,                                
    ReadAllService<HospitalResponse>,
    ReadService<HospitalResponse,String>,
    UpdateService<HospitalRequest,HospitalResponse, String>{

}
