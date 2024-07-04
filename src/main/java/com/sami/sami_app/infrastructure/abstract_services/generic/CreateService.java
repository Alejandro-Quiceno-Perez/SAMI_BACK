package com.sami.sami_app.infrastructure.abstract_services.generic;

public interface CreateService <Request,Response> {
    Response create(Request request);   
}
