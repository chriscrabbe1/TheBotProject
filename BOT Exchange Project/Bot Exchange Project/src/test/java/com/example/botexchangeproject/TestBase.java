package com.example.botexchangeproject;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class TestBase {

  public TestBase() {
  }

  protected void verifyLogin() {


    stubFor(post(urlEqualTo("/login?username=rgssTZlPyFz6Cmnmbl&password=P@rola03"))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader("X-Application", "npo67wopV4oKVu5g")
            .withHeader("Content-Type", "application/x-www-form-urlencoded")
            .withHeader("Accept", "application/json")
        ));
  }

}
