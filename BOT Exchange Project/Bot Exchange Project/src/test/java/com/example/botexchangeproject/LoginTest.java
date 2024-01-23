package com.example.botexchangeproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@WireMockTest
@SpringBootTest
class LoginTest {


    @Test
    public void executePostRequest() throws IOException, URISyntaxException, InterruptedException, RuntimeException {

        // Login login = new Login();
        ObjectMapper objectMapper = new ObjectMapper();



        /*stubFor(post(urlEqualTo("/api/login?username=apitestuk2&password=p@ssword03"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("X-Application", "npo67wopV4oKVu5g")
                        .withHeader("Content-Type", "application/x-www-form-urlencoded")
                        .withHeader("Accept", "application/json")
                        .withBody(objectMapper.writeValueAsString(login))));

        // Create the HTTP client - address the code below (figure out how to proceed)

        /*CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost request = new HttpPost("https://identitysso.nxt.com.betfair/api/login");
        HttpResponse httpResponse = httpClient.execute(request);
        */

        // Assert

        String result = Login.returnToken();
        assertThat(result.length(), lessThanOrEqualTo(44));

        /*
        assertThat(result, containsString("token"));
        assertThat(result, containsString("SUCCESS"));
        verify(postRequestedFor(urlEqualTo("/api/login?username=apitestuk2&password=p@ssword03")));
        */


    }









}
