//package com.example.botexchangeproject;
//
//import com.example.botexchangeproject.Controllers.LoginController;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.IOException;
//import java.net.URISyntaxException;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//@RestController
//@RequestMapping(value = "/exchange/betting/rest/v1.0/", method = {RequestMethod.GET, RequestMethod.POST})
//public class DeleteBets extends LoginController {
//
//private String endpoint;
//    @PostMapping("/cancelOrders/")
//    public static String cancelBet() throws URISyntaxException, IOException, InterruptedException {
//
//        String urlCancelBets = "http://ang.nxt.internal/exchange/betting/rest/v1.0/cancelOrders/";
//
//        String sessionURL = loginURL;
//
//        //String returnedToken = Login.returnToken(sessionURL);
//
//        String cancelBetJsonBody = JsonBodyBuilder.deleteBetJson();
//
//        HttpRequest request = new HttpRequestBuilder().buildRequest(urlCancelBets, returnedToken, cancelBetJsonBody);
//
//        HttpClient client = HttpClient.newHttpClient();
//
//        HttpResponse<String> cancelBetsResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//        System.out.println(cancelBetsResponse.body());
//
//        return cancelBetsResponse.body();
//
//    }
//
//}
