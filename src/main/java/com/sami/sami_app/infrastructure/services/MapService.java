package com.sami.sami_app.infrastructure.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.sami.sami_app.api.dto.request.LocationsRequest;
// import com.sami.sami_app.infrastructure.AppConfig;
import com.sami.sami_app.infrastructure.abstract_services.IMapService;

@Service
public class MapService implements IMapService {

    @Autowired
    private GeoApiContext geoApiContext;

    // @Autowired
    // private AppConfig appConfig;

    // Método para calcular el tiempo estimado de servicio
    public Map<String, String> getEstimatedTime(LocationsRequest locationsRequest) {
        Double ambulanceLatitude = locationsRequest.getAmbulanceLatitude();
        Double ambulanceLongitude = locationsRequest.getAmbulanceLongitude();
        Double hospitalLatitude = locationsRequest.getHospitalLatitude();
        Double hospitalLongitude = locationsRequest.getHospitalLongitude();

        Map<String, String> result = new HashMap<>();

        try {
            DirectionsApiRequest request = DirectionsApi.newRequest(geoApiContext)
                    .origin(new LatLng(ambulanceLatitude, ambulanceLongitude))
                    .destination(new LatLng(hospitalLatitude, hospitalLongitude))
                    .mode(com.google.maps.model.TravelMode.DRIVING);

            DirectionsResult directionsResult = request.await();

            String estimatedTime = directionsResult.routes[0].legs[0].duration.humanReadable;

            result.put("estimatedTime", estimatedTime);
            result.put("status", "success");
        } catch (Exception e) {
            result.put("error", "Error al calcular el tiempo estimado de servicio: " + e.getMessage());
            result.put("status", "error");
        }

        return result;
    }

    // Nuevo método para obtener la posición
    public String getPosition(Double latitude, Double longitude) {
        try {
            GeocodingResult[] results = GeocodingApi.reverseGeocode(geoApiContext, new LatLng(latitude, longitude))
                    .await();
            if (results.length > 0) {
                return results[0].geometry.location.toString();
            } else {
                return "No se encontraron resultados";
            }
        } catch (Exception e) {
            return "Error al realizar la geolocalización: " + e.getMessage();
        }
    }
}
