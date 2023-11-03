package com.example.botexchangeproject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Login {

    private static final String apiURL = "https://identitysso.nxt.com.betfair/api/login";
    private static final String username = "apitestuk2";
    private static final String password = "p@ssword03";


    public String returnToken() throws IOException, InterruptedException {

        String credentials = username + ":" + password;
        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());
        String body = "grant_type=password&username=" + username + "&password=" + password;

        HttpRequest.BodyPublisher bodyPublisher = HttpRequest.BodyPublishers.ofString(body);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .POST(bodyPublisher)
                .header("X-Application", "npo67wopV4oKVu5g")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Accept", "application/json")
                .uri(URI.create(apiURL))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //System.out.println(response.body());

        String responseBody = response.body();
        String token ="";

        if (response.statusCode() == 200) {
            Gson gson = new Gson();
            JsonObject jsonResponse = gson.fromJson(responseBody, JsonObject.class);

            if (jsonResponse.has("token")) {
                token = jsonResponse.get("token").getAsString();
            }
        }

        return token;




    }

}




