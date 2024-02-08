package com.example.botexchangeproject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/v1.0")
public class BetPlacement {

    @Value("{endpoint}")
    private String endpoint;
@PostMapping("/placeOrders")
    public void placeLayBet() throws URISyntaxException, IOException, InterruptedException {

        String returnedToken = Login.returnToken();

        String placeBetsJsonBody = JsonBodyBuilder.placeBetsJson();

        String urlPlaceBet = endpoint + "placeOrders/";

        HttpRequest request = new HttpRequestBuilder().buildRequest(urlPlaceBet, returnedToken, placeBetsJsonBody);

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> betResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(betResponse.body());

       }

    }

