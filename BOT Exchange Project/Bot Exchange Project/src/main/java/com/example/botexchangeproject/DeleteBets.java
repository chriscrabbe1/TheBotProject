package com.example.botexchangeproject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DeleteBets {

    public static String cancelBet() throws URISyntaxException, IOException, InterruptedException {

        String urlCancelBets = "http://ang.nxt.internal/exchange/betting/rest/v1.0/cancelOrders/";
        URI uri3 = new URI(urlCancelBets);

        String returnedToken3 = Login.returnToken();
        String cancelBetJsonBody = JsonBodyBuilder.deleteBetJson();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri3)
                .header("Accept", "application/json")
                .header("X-Application", "npo67wopV4oKVu5g")
                .header("X-Authentication", returnedToken3)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(cancelBetJsonBody))
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> cancelBetsResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(cancelBetsResponse.body());

        return cancelBetsResponse.body();

    }

}
