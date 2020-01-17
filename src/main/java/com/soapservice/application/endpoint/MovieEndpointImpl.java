package com.soapservice.application.endpoint;

import com.soapservice.domain.repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.MovieRequest;
import io.spring.guides.gs_producing_web_service.MovieResponse;

@Endpoint
public class MovieEndpointImpl implements MovieEndpoint {

    private MovieRepository repository;

    @Autowired
    public MovieEndpointImpl(MovieRepository repository) {
        this.repository = repository;
    }

    @Override
    @PayloadRoot(namespace = "http://spring.io/guides/gs-producing-web-service", localPart = "movieRequest")
    @ResponsePayload
    public MovieResponse getMovie(@RequestPayload MovieRequest request) {
        MovieResponse response = new MovieResponse();
        response.setMovie(repository.findMovie(request.getTitle().toLowerCase()));
        return response;
    }
}