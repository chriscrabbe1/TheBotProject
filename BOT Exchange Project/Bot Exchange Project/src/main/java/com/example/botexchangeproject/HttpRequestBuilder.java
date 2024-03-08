package com.example.botexchangeproject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

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


    public ResponseEntity<String> buildARequest(String requestURL, String returnedSessionToken) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Application", "npo67wopV4oKVu5g");
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "application/json");
        headers.add("X-Authentication", returnedSessionToken);
        HttpEntity<String> finalEntity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(requestURL, HttpMethod.POST, finalEntity,
            String.class);

//        String responseBody = response.getBody();
//        System.out.println(responseBody);

        return response;
    }


}


