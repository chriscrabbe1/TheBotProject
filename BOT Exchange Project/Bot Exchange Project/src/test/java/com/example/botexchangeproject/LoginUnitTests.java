package com.example.botexchangeproject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.example.botexchangeproject.Controllers.ServiceController;
import com.example.botexchangeproject.Models.LoginForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LoginUnitTests {

private String username = "testuser";
  private String password = "testpass";

  @Mock
  private ServiceController serviceController;

  @Mock
  LoginForm loginForm;
@DisplayName("user login is valid")
@Test
  void testValidLogin() {



  when(serviceController.createSession(username, password, loginForm)).thenReturn("SUCCESS");

    String result = serviceController.createSession(username, password, loginForm);

  System.out.println(result);

    assertThat(result.contains("SUCCESS"));

  }
  @Test
  @DisplayName("user login is invalid")
  void testInvalidLogin() {

  String result = serviceController.createSession("user", "1234", loginForm);

  assertThat(result.isEmpty());
  }

}
