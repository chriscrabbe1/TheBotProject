package com.example.botexchangeproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


public class BetPlacement {

    public static void returnEventTypes(JsonData betPlacementScanner, Scanner scanner) throws IOException, URISyntaxException, InterruptedException {

        //List<String> eventTypesFilter = new ArrayList<>();
        //eventTypesFilter.add(betPlacementScanner.getEventTypeIds());


        ObjectMapper objectMapper = new ObjectMapper();
        //objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String jsonBody = objectMapper.writeValueAsString(betPlacementScanner);




        System.out.print(jsonBody);

        String urlListEventTypes = "http://ang.nxt.internal/exchange/betting/rest/v1.0/listEventTypes/";
        URI uri3 = new URI(urlListEventTypes);

        String returnedToken = Login.returnToken();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri3)
                .header("Accept", "application/json")
                .header("X-Application", "npo67wopV4oKVu5g")
                .header("X-Authentication", returnedToken)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> eventTypesResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

        //return response.body();

        System.out.println(eventTypesResponse.body());


    }

    public static void placeLayBet(JsonData betPlacementScanner, Scanner scanner) throws URISyntaxException, IOException, InterruptedException {

        String returnedToken = Login.returnToken();

        String urlPlaceBet = "http://ang.nxt.internal/exchange/betting/rest/v1.0/placeOrders/";
        URI uri = new URI(urlPlaceBet);


        String jSON = """
                {
                    "marketId": "1.181908454",
                    "instructions": [
                        {
                            "selectionId": "237493",
                            "handicap": "0",
                            "side": "LAY",
                                    "orderType": "LIMIT",
                                    "limitOrder": {
                                        "size": "0.10",
                                        "price": "3",
                                        "persistenceType": "LAPSE"
                                    }
                                }
                            ]
                }
                """;



        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Accept", "application/json")
                .header("X-Application", "npo67wopV4oKVu5g")
                .header("X-Authentication", returnedToken)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jSON))
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> betResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

        //return response.body();

        System.out.println(betResponse.body());

        Gson gson = new Gson();
        JsonObject response = gson.fromJson(betResponse.body(), JsonObject.class);

       }

    }

