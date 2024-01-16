package com.example.botexchangeproject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class BetPlacement {

    public static void placeLayBet() throws URISyntaxException, IOException, InterruptedException {

        String returnedToken = Login.returnToken();

        String jSON2 = JsonBodyBuilder.placeBetsJson();

        String urlPlaceBet = "http://ang.nxt.internal/exchange/betting/rest/v1.0/placeOrders/";
        URI uri = new URI(urlPlaceBet);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Accept", "application/json")
                .header("X-Application", "npo67wopV4oKVu5g")
                .header("X-Authentication", returnedToken)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jSON2))
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> betResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

        //return response.body();

        System.out.println(betResponse.body());

        Gson gson = new Gson();
        JsonObject response = gson.fromJson(betResponse.body(), JsonObject.class);

       }

    }

