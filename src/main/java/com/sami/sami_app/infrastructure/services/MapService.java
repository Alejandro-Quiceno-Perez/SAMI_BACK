package com.sami.sami_app.infrastructure.services;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.sami.sami_app.api.dto.request.LocationsRequest;
import com.sami.sami_app.infrastructure.AppConfig;
import com.sami.sami_app.infrastructure.abstract_services.IMapService;


@Service
public class MapService implements IMapService{

     @Autowired
    private GeoApiContext geoApiContext;
    @Autowired
    private AppConfig appConfig;

 
    // validated if it received a valid location or if it received any locations
    public String getLocationAddress(Double latitude, Double longitude) {
        try {
            GeoApiContext context = new GeoApiContext.Builder().apiKey(appConfig.getGoogleMapsApiKey()).build();
            GeocodingResult[] results = GeocodingApi.reverseGeocode(context, new LatLng(latitude, longitude)).await();
            if (results.length > 0) {
                return results[0].formattedAddress;
            } else {
                return "No results found";
            }
        } catch (Exception e) {
            return "Error while performing geolocation: " + e.getMessage();
        }
    }

    //method for calculating estimated service time
    @PostMapping("/locations")
    public Map<String, String> getEstimatedTime(LocationsRequest locationsRequest) {
        Double ambulanceLatitude = locationsRequest.getAmbulanceLatitude();
        Double ambulanceLongitude = locationsRequest.getAmbulanceLongitude();
        Double hospitalLatitude = locationsRequest.getHospitalLatitude();
        Double hospitalLongitude = locationsRequest.getHospitalLongitude();

        Map<String, String> result = new HashMap<>();

        try {
            DirectionsApiRequest request = DirectionsApi.newRequest(geoApiContext)
                    .origin(new com.google.maps.model.LatLng(ambulanceLatitude, ambulanceLongitude))
                    .destination(new com.google.maps.model.LatLng(hospitalLatitude, hospitalLongitude))
                    .mode(com.google.maps.model.TravelMode.DRIVING);  
                    

            DirectionsResult directionsResult = request.await();

            
            String estimatedTime = directionsResult.routes[0].legs[0].duration.humanReadable;

            result.put("estimatedTime", estimatedTime);
            result.put("status", "success");
        } catch (Exception e) {
            result.put("error", "Error calculating the estimated time of service: " + e.getMessage());
            result.put("status", "error");
        }

        return result;
    }
    
}
