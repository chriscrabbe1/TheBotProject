package com.example.botexchangeproject;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.verify;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.with;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@WireMockTest(httpPort = 8989)
class LoginIntegrationTest extends TestBase {

  private RequestSpecification requestSpec;
  //String encodedPassword = URLDecoder.decode("P@rola03", "UTF-8");

  String username = "user";
  String password = "pass";

    public LoginIntegrationTest() {
    }

    @BeforeEach
public void createRequestSpec() {
     requestSpec = new RequestSpecBuilder().
        setBaseUri("http://localhost").
         setPort(8989).build();
}

    @Test
    @DisplayName("Checks if the login returns an OK Status Code")
    public void loginRequestReturnsOkStatusCode()
        throws RuntimeException {

      stubFor(post(urlEqualTo("/login?username=" + username + "&password=" + password))
              .willReturn(aResponse()
                  .withStatus(200)
                  .withHeader("X-Application", "npo67wopV4oKVu5g")
                  .withHeader("Content-Type", "application/x-www-form-urlencoded")
                  .withHeader("Accept", "application/json")
          ));

        given().
                spec(requestSpec).
        when().
                post("/login?username=" + username + "&password=" + password).
        then().
                assertThat().
                statusCode(200);


        //String result = Login.returnToken();
        //assertThat(result.length(), lessThanOrEqualTo(44));

        /*
        assertThat(result, containsString("token"));
        assertThat(result, containsString("SUCCESS"));
        verify(postRequestedFor(urlEqualTo("/api/login?username=apitestuk2&password=p@ssword03")));
        */


    }









}
