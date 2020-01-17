package com.soapservice.application.endpoint;

import com.soapservice.domain.repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

import io.spring.guides.gs_producing_web_service.GetMovieRequest;
import io.spring.guides.gs_producing_web_service.GetMovieResponse;

@Endpoint
public class MovieEndpointImpl implements MovieEndpoint {

    private MovieRepository repository;

    @Autowired
    public MovieEndpointImpl(MovieRepository repository) {
        this.repository = repository;
    }

    @Override
    public GetMovieResponse getMovie(@RequestPayload GetMovieRequest request) {
        GetMovieResponse response = new GetMovieResponse();
        response.setMovie(repository.findMovie(request.getTitle().toLowerCase()));
        return response;
    }
}