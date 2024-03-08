//package com.example.botexchangeproject.Controllers;
//
//import com.example.botexchangeproject.JsonBodyBuilder;
//import com.example.botexchangeproject.SessionTokenSupplier;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.client.RestTemplate;
//
//public class BetPlacementController {
//
//  public static void placeABet(@RequestBody String requestBody) {
//
//    String urlOpenBets = "http://ang.nxt.internal/exchange/betting/rest/v1.0/placeOrders/";
//    String expectedSessionToken = SessionTokenSupplier.retrieveSessionToken();
//    requestBody = JsonBodyBuilder.placeBetsJson();
//
//    HttpHeaders headers = new HttpHeaders();
//    headers.add("X-Application", "npo67wopV4oKVu5g");
//    headers.add("Content-Type", "application/x-www-form-urlencoded");
//    headers.add("Accept", "application/json");
//    headers.add("X-Authentication", expectedSessionToken);
//    HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
//
//    RestTemplate restTemplate = new RestTemplate();
//    ResponseEntity<String> response = restTemplate.exchange(urlOpenBets, HttpMethod.POST, entity,
//        String.class);
//
//    String responseBody = response.getBody();
//    System.out.println(responseBody);
//
//  }
//
//}
