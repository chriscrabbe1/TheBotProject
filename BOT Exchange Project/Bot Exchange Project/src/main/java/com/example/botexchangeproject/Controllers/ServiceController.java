package com.example.botexchangeproject.Controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import com.example.botexchangeproject.HttpRequestBuilder;
import com.example.botexchangeproject.Models.CurrentOrder;
import com.example.botexchangeproject.Models.CurrentOrders;
import com.example.botexchangeproject.Models.LoginForm;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
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
  public String showLoginForm() {
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
  public String showCurrentBets(Model model, CurrentOrder currentOrder) {

  String urlOpenBets = "http://ang.nxt.internal/exchange/betting/rest/v1.0/listCurrentOrders/";

  HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();

  ResponseEntity response = httpRequestBuilder.buildARequest(urlOpenBets, passedToken);

  String currentBetsString = (String) response.getBody();

  System.out.println(currentBetsString);

  Gson gson = new Gson();

  CurrentOrders currentOrders = gson.fromJson(currentBetsString, CurrentOrders.class);

  model.addAttribute("orders", currentOrders);

  System.out.println(response + "+++++");

  return "CurrentBets";
  }

  //DELETE BETS
  @RequestMapping(value = "/deleteBets")
  public String deleteBets(@RequestParam String betId, @RequestParam String marketId) {
        String urlOpenBets = "http://ang.nxt.internal/exchange/betting/rest/v1.0/cancelOrders/";

    String finalBody = deleteBetsJson(betId, marketId);

    HttpHeaders headers = new HttpHeaders();
    headers.add("X-Application", "npo67wopV4oKVu5g");
    headers.add("Content-Type", "application/json");
    headers.add("Accept", "application/json");
    headers.add("X-Authentication", passedToken);
    HttpEntity<String> entity = new HttpEntity<>(finalBody, headers);

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response = restTemplate.exchange(urlOpenBets, HttpMethod.POST, entity,
        String.class);

    String responseBody = response.getBody();
    System.out.println(responseBody);

    return "redirect:/openBets";
  }

  private static String deleteBetsJson(String betId, String marketId) {
    JsonObject cancelJsonObject = new JsonObject();
    JsonObject deleteInstructionObj = new JsonObject();
    JsonArray deleteInstructionArray = new JsonArray();

    //adds marketID and instructions to the main body of JSON
    cancelJsonObject.addProperty("marketId", marketId);
    cancelJsonObject.add("instructions", deleteInstructionArray);

    //inserts betID into "instructions"
    deleteInstructionObj.addProperty("betId", betId);

    //inserts whole "instructions" into array
    deleteInstructionArray.add(deleteInstructionObj);

    String finalBody = cancelJsonObject.toString();
    return finalBody;
  }

}
