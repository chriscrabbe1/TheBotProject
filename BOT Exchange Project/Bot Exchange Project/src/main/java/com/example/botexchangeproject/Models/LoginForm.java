package com.example.botexchangeproject.Models;

import org.springframework.stereotype.Service;

@Service
public class LoginForm {

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  protected String username;
  protected String password;

  public String getSessionToken() {
    return sessionToken;
  }

  public void setSessionToken(String sessionToken) {
    this.sessionToken = sessionToken;
  }

  protected String sessionToken;



}
