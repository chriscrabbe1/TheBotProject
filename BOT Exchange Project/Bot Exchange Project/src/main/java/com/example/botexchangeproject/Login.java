package com.example.botexchangeproject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/login")
//public class Login {

//
//    private static final String username = "rgssTZlPyFz6Cmnmbl";
//    private static final String password = "P@rola03";
//
//    @PostMapping("/login")
//   public static String returnToken(String URL) throws IOException, InterruptedException, URISyntaxException {
//
//        //String query = "username=" + username + "&password=" + password;
//        //String urlString = "https://identitysso.nxt.com.betfair/api/login?" + query;
//
//        URI uri = new URI(URL);
//
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(uri)
//                .header("X-Application", "npo67wopV4oKVu5g")
//                .header("Content-Type", "application/x-www-form-urlencoded")
//                .header("Accept", "application/json")
//                .POST(HttpRequest.BodyPublishers.noBody())
//                .build();
//
//        HttpClient client = HttpClient.newHttpClient();
//
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//        Gson gson = new Gson();
//        JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);
//
//      System.out.println(jsonResponse);
//
//       if (jsonResponse.has("token")) {
//           String sessionToken = jsonResponse.get("token").getAsString();
//            System.out.println("Your login was successful! The token is: " + sessionToken);
//
//            return sessionToken;
//
//        } else {
//           throw new IOException("Incorrect Username and/or Password");
//       }
//
//    }
//
//    }










