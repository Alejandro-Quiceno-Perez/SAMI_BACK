package com.sami.sami_app.infrastructure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${GOOGLE_MAPS_API_KEY}")
    private String googleMapsApiKey;

    public String getGoogleMapsApiKey() {
        return googleMapsApiKey;
    }
}