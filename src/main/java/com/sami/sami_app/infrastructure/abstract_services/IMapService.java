package com.sami.sami_app.infrastructure.abstract_services;

import java.util.Map;

import com.sami.sami_app.api.dto.request.LocationsRequest;

public interface IMapService {

    Map<String, String> getEstimatedTime(LocationsRequest locationsRequest); 
    String getLocationAddress(Double latitude, Double longitude);
    String getPosition(Double latitude, Double longitude);
}
