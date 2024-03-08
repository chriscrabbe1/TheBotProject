package com.example.botexchangeproject.Controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import com.example.botexchangeproject.HttpRequestBuilder;
import com.example.botexchangeproject.JsonBodyBuilder;
import com.example.botexchangeproject.Models.LoginForm;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class ServiceController {

  public static String passedToken;

//SHOW LOGIN PAGE
  @RequestMapping(value = "/login", method = GET)
  public String showLoginForm(Model model, LoginForm loginForm) {
    model.addAttribute("loginForm", new LoginForm());
    model.addAttribute("username", loginForm.getUsername());
    model.addAttribute("password", loginForm.getPassword());
    return "index";
  }

  //LOGIN REQUEST
  @RequestMapping(value = "/login", method = POST)
  public static String createSession(@RequestParam(value = "username") String username,
      @RequestParam(value = "password") String password, LoginForm loginForm) {
    loginForm.setUsername(username);
    loginForm.setPassword(password);
    String requestURL = "https://identitysso.nxt.com.betfair/api/login?username="
        + loginForm.getUsername()
        + "&password="
        + loginForm.getPassword();

    HttpHeaders headers = new HttpHeaders();
    headers.add("X-Application", "npo67wopV4oKVu5g");
    headers.add("Content-Type", "application/x-www-form-urlencoded");
    headers.add("Accept", "application/json");
    HttpEntity<String> entity = new HttpEntity<>(headers);

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response = restTemplate.exchange(requestURL, HttpMethod.POST, entity,
        String.class);

    String responseBody = response.getBody();
    System.out.println(responseBody);

    Gson gson = new Gson();
    JsonObject jsonResponse = gson.fromJson(response.getBody(), JsonObject.class);

    if (jsonResponse.has("token")) {
      passedToken = jsonResponse.get("token").getAsString();
      System.out.println(passedToken);

    }
    return "HomePage";
  }

  //SHOW OPEN BETS
@RequestMapping(value = "openBets", method = {RequestMethod.GET, RequestMethod.POST})
  public String showCurrentBets(Model model) {

  String urlOpenBets = "http://ang.nxt.internal/exchange/betting/rest/v1.0/listCurrentOrders/";

  HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();

      Object response = httpRequestBuilder.buildARequest(urlOpenBets, passedToken);

  model.addAttribute("currentOrders", response);

//  Gson gson = new Gson();
//  JsonObject jsonResponse = gson.fromJson(response.toString(), JsonObject.class);
//
//  model.addAttribute("currentOrders", response);

  System.out.println(response + "+++++");



//  JsonArray jsonArray = new Gson().fromJson(response, JsonArray.class);
//
//  for (Object betId:
//  jsonArray) {
//    System.out.println(betId);
//  }

//  String[] jsonResponseArray = response.split("\n");
//  System.out.println(jsonResponseArray);

  return "CurrentBets";
  }

  //DELETE BETS
  @RequestMapping(value = "/deleteBets")
  public String deleteBets() {
        String urlOpenBets = "http://ang.nxt.internal/exchange/betting/rest/v1.0/cancelOrders/";

    String requestBody = JsonBodyBuilder.deleteBetJson();

    HttpHeaders headers = new HttpHeaders();
    headers.add("X-Application", "npo67wopV4oKVu5g");
    headers.add("Content-Type", "application/x-www-form-urlencoded");
    headers.add("Accept", "application/json");
    headers.add("X-Authentication", passedToken);
    HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response = restTemplate.exchange(urlOpenBets, HttpMethod.POST, entity,
        String.class);

    String responseBody = response.getBody();
    System.out.println(responseBody);





    return null;
  }

}
