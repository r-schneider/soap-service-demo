package com.soapservice.application.endpoint;

import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public interface MovieEndpoint {

    @PayloadRoot(namespace = "http://springsoap.com/demo/movieservice", localPart = "getMovieRequest")
    @ResponsePayload
    public GetMovieResponse getMovie(@RequestPayload GetMovieRequest request);
}