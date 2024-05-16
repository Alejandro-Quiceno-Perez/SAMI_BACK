package com.sami.sami_app.infrastructure.abstract_services;

import org.springframework.stereotype.Service;

import com.sami.sami_app.api.dto.request.HospitalRequest;
import com.sami.sami_app.api.dto.response.HospitalResponse;

@Service
public interface IHospitalService extends CrudService<HospitalRequest,HospitalResponse,Long>{

}
