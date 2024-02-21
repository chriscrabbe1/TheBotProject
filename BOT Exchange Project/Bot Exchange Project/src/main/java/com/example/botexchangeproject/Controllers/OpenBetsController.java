package com.example.botexchangeproject.Controllers;

import com.example.botexchangeproject.HttpRequestBuilder;
import com.example.botexchangeproject.Models.LoginForm;

public class OpenBetsController {


  public static void getOpenBets() {

    String urlOpenBets = "http://ang.nxt.internal/exchange/betting/rest/v1.0/listCurrentOrders/";
    LoginForm loginForm = new LoginForm();
    String expectedSessionToken = loginForm.getSessionToken();

    HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();

    String response = String.valueOf(
        httpRequestBuilder.buildARequest(urlOpenBets, expectedSessionToken));

    System.out.println(response + "+++++");
  }

}
