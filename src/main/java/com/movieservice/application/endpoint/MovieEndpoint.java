package com.movieservice.application.endpoint;

import soap.spring.demo.movieservice.MovieRequest;
import soap.spring.demo.movieservice.MovieResponse;

public interface MovieEndpoint {

    public MovieResponse getMovie(MovieRequest request);
}