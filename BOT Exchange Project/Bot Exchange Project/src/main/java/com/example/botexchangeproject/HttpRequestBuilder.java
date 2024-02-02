package com.example.botexchangeproject;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;

public class HttpRequestBuilder {

    public HttpRequest buildRequest(String url, String returnedToken, String jsonBody) throws URISyntaxException {

        URI uri = new URI(url);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Accept", "application/json")
                .header("X-Application", "npo67wopV4oKVu5g")
                .header("X-Authentication", returnedToken)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        return request;
    }
}
