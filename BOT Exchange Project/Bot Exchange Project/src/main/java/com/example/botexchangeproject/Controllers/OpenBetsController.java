//package com.example.botexchangeproject.Controllers;
//
//import static org.springframework.web.bind.annotation.RequestMethod.POST;
//
//import com.example.botexchangeproject.HttpRequestBuilder;
//import com.example.botexchangeproject.Models.LoginForm;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//public class OpenBetsController {
//
//  public static String getOpenBets() {
//
//    String urlOpenBets = "http://ang.nxt.internal/exchange/betting/rest/v1.0/listCurrentOrders/";
//    LoginForm loginForm = new LoginForm();
//    String expectedSessionToken = loginForm.getSessionToken();
//
//    HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
//
//    String response = String.valueOf(
//        httpRequestBuilder.buildARequest(urlOpenBets, expectedSessionToken));
//
//    System.out.println(response + "+++++");
//
//    return "CurrentBets";
//  }
//
//
//
//}
