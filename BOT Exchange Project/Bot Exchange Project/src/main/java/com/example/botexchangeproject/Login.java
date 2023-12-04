package com.example.botexchangeproject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;


@Service
public class Login {
    private static final String username = "apitestuk2";
    private static final String password = "p@ssword03";

    private static String sessionToken;


    public static String returnToken() throws IOException, InterruptedException, URISyntaxException {


        String query = "username=" + username + "&password=" + password;
        String urlString = "https://identitysso.nxt.com.betfair/api/login?" + query;

        URI uri = new URI(urlString);


        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("X-Application", "npo67wopV4oKVu5g")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Accept", "application/json")
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //return response.body();

        System.out.println(response.body());



        Gson gson = new Gson();
        JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);

       if (jsonResponse.has("token")) {
            sessionToken = jsonResponse.get("token").getAsString();
            System.out.println("Your login was successful! The token is: " + sessionToken);

            return sessionToken;

        } else {
           throw new IOException("Incorrect Username and/or Password");
       }


    }









    }










