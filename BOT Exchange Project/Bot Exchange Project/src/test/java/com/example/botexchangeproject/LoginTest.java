package com.example.botexchangeproject;

import org.junit.jupiter.api.Test;


class LoginTest {

    private final String receivedToken;


    {
        receivedToken = "token";
    }

    @Test
    void shouldReturnSessionToken() {
        LoginTest loginTest = new LoginTest();

        String expected = loginTest.receivedToken;

    }





}