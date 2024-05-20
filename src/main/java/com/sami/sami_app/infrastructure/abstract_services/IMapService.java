package com.sami.sami_app.infrastructure.abstract_services;

import java.util.Map;

import com.sami.sami_app.api.dto.response.LocationsResponse;

public interface IMapService {
    Map<String, String> getEstimatedTime(LocationsResponse locationsResponse);

    String getPosition(Double latitude, Double longitude);
}
