package com.example.botexchangeproject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ListCurrentBets {


    public static String showLiveBets() throws URISyntaxException, IOException, InterruptedException {

        String urlCurrentBets = "http://ang.nxt.internal/exchange/betting/rest/v1.0/listCurrentOrders/";
        URI uri2 = new URI(urlCurrentBets);

        String returnedToken2 = Login.returnToken();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri2)
                .header("Accept", "application/json")
                .header("X-Application", "npo67wopV4oKVu5g")
                .header("X-Authentication", returnedToken2)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> currentBetsResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(currentBetsResponse.body());

        return currentBetsResponse.body();

    }

}
