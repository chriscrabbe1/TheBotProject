package com.example.botexchangeproject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
@RestController
@RequestMapping(value = "/exchange/betting/rest/v1.0/", method = {RequestMethod.GET, RequestMethod.POST})
public class ListCurrentBets {

@PostMapping("/listCurrentOrders/")
    public static String showLiveBets() throws URISyntaxException, IOException, InterruptedException {

        String urlCurrentBets = "http://ang.nxt.internal/exchange/betting/rest/v1.0/listCurrentOrders/";

        String returnedToken = Login.returnToken();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlCurrentBets))
                .header("Accept", "application/json")
                .header("X-Application", "npo67wopV4oKVu5g")
                .header("X-Authentication", returnedToken)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> currentBetsResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

        //System.out.println(currentBetsResponse.body());

        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Object jsonCurrentBets = gson.fromJson(currentBetsResponse.body(), Object.class);
            String presentedCurrentBets = gson.toJson(jsonCurrentBets);

            System.out.println(presentedCurrentBets);
            return presentedCurrentBets;

        } catch (Exception error) {
            error.printStackTrace();
            return "Error encountered";
        }

    }

}
