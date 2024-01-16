package com.example.botexchangeproject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class UserInput {

    private static String username = "rgssTZlPyFz6Cmnmbl";
    private static String password = "P@rola03";

//method to accept correct username and password, then pass it into Login class
    public static Map<String, String> loginScanner() {



        Map<String, String> credentials = new HashMap<>();
        boolean correctCredentials = false;
        Scanner scanner = new Scanner(System.in);

        while (!correctCredentials) {
            System.out.println("Welcome! Please provide your credentials");

            //Req login credentials

            System.out.print("Username: ");
            username = scanner.next();

            System.out.print("Password: ");
            password = scanner.next();

            // check if username & password correct, then pass them to be returned, else print error message

            if (Objects.equals(username, "rgssTZlPyFz6Cmnmbl") && Objects.equals(password, "P@rola03")) {
                credentials.put("username", username);
                credentials.put("password", password);
                correctCredentials = true;


            } else {
                System.out.println("Sorry, wrong credentials, please try again");
            }

            System.out.println();

        }

        return credentials;

    }


}
