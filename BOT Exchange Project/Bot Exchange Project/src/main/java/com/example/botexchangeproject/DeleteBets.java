package com.example.botexchangeproject;

import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DeleteBets {
@Value("{endpoint}")
private String endpoint;

    public String cancelBet() throws URISyntaxException, IOException, InterruptedException {

        String urlCancelBets = endpoint + "cancelOrders/";

        String returnedToken3 = Login.returnToken();
        String cancelBetJsonBody = JsonBodyBuilder.deleteBetJson();

        HttpRequest request = new HttpRequestBuilder().buildRequest(urlCancelBets, returnedToken3, cancelBetJsonBody);

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> cancelBetsResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(cancelBetsResponse.body());

        return cancelBetsResponse.body();

    }

}
