package com.springsoap.api.movies.application.endpoint;

import com.springsoap.api.movies.SearchMovieRequest;
import com.springsoap.api.movies.SearchMovieResponse;

public interface MovieEndpoint {

    public SearchMovieResponse getMovie(SearchMovieRequest request);
}