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

        String urlListCompetitions = "http://ang.nxt.internal/exchange/betting/rest/v1.0/listCompetitions/";
        URI uri2 = new URI(urlListCompetitions);

        String urlPlaceBet = "http://ang.nxt.internal/exchange/betting/rest/v1.0/placeOrders/";
        URI uri = new URI(urlPlaceBet);

        String urlListEventTypes = "http://ang.nxt.internal/exchange/betting/rest/v1.0/listEventTypes/";
        URI uri3 = new URI(urlListEventTypes);

        String urlListEvents = "http://ang.nxt.internal/exchange/betting/rest/v1.0/listEvents/";
        URI uri4 = new URI(urlListEvents);

        String urlListMarketTypes = "http://ang.nxt.internal/exchange/betting/rest/v1.0/listMarketTypes/";
        URI uri5 = new URI(urlListMarketTypes);

        String urlListMarketCatalogue = "http://ang.nxt.internal/exchange/betting/rest/v1.0/listMarketCatalogue/";
        URI uri6 = new URI(urlListMarketCatalogue);





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

