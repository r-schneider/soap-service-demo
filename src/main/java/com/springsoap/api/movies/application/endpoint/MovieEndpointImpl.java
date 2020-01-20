package com.springsoap.api.movies.application.endpoint;

import com.springsoap.api.movies.SearchMovieRequest;
import com.springsoap.api.movies.SearchMovieResponse;
import com.springsoap.api.movies.domain.repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class MovieEndpointImpl implements MovieEndpoint {

    private MovieRepository repository;

    @Autowired
    public MovieEndpointImpl(MovieRepository repository) {
        this.repository = repository;
    }

    @Override
    @PayloadRoot(namespace = "http://springsoap.com/api/movies", localPart = "searchMovieRequest")
    @ResponsePayload
    public SearchMovieResponse getMovie(@RequestPayload SearchMovieRequest request) {
        SearchMovieResponse response = new SearchMovieResponse();
        response.setMovie(repository.findMovie(request.getTitle().toLowerCase()));
        return response;
    }
}