package com.soapservice.application.endpoint;

import io.spring.guides.gs_producing_web_service.MovieRequest;
import io.spring.guides.gs_producing_web_service.MovieResponse;

public interface MovieEndpoint {

    public MovieResponse getMovie(MovieRequest request);
}