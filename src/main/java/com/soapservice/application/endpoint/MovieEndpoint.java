package com.soapservice.application.endpoint;

import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

public interface MovieEndpoint {

    @PayloadRoot(namespace = "${service.constants.NAMESPACE_URI}", localPart = "getMovieRequest")
    @ResponsePayload
    public GetMovieResponse getMovie(@RequestPayload GetMovieRequest request);
}