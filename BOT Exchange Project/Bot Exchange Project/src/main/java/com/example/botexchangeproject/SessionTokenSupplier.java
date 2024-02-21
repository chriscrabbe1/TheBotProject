package com.example.botexchangeproject;

import com.example.botexchangeproject.Models.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionTokenSupplier {

  @Autowired
  static LoginForm loginForm;


  public static String retrieveSessionToken() {

    String expectedSessionToken = loginForm.getSessionToken();

    System.out.println(expectedSessionToken + "KKKK");

    return expectedSessionToken;
  }

}
