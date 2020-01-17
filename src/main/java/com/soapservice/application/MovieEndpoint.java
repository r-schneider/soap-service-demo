package com.soapservice.application;

import com.springsoap.soapservice.application.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.MovieRequest;
import io.spring.guides.gs_producing_web_service.MovieResponse;

@Endpoint
public class MovieEndpoint {

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private MovieRepository repository;

    @Autowired
    public MovieEndpoint(MovieRepository repository) {
        this.repository = repository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "movieRequest")
    @ResponsePayload
    public MovieResponse getMovie(@RequestPayload MovieRequest request) {
        MovieResponse response = new MovieResponse();
        response.setMovie(repository.findMovie(request.getTitle().toLowerCase()));
        return response;
    }
}