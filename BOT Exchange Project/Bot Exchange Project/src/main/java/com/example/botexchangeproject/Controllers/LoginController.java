package com.example.botexchangeproject.Controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class LoginController {

  @RequestMapping(value = "/login", method = GET)
  public String showLoginForm(Model model, LoginForm loginForm) {
    model.addAttribute("loginForm", new LoginForm());
    model.addAttribute("username", loginForm.getUsername());
    model.addAttribute("password", loginForm.getUsername());
    return "index";
  }
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
      loginForm.setSessionToken(jsonResponse.get("token").getAsString());
      System.out.println(loginForm.getSessionToken());
    }

    return "HomePage";

    //return jsonResponse.get("token").getAsString();

  }
@RequestMapping(value = "/openBets")
  public String showCurrentBets() {

    return "CurrentBets";
  }

}
