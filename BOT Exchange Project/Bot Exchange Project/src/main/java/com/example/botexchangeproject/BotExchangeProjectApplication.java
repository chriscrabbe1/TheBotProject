package com.example.botexchangeproject;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;


@SpringBootApplication
public class BotExchangeProjectApplication {

    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException
    { SpringApplication.run(BotExchangeProjectApplication.class, args);

        Scanner scanner = new Scanner(System.in);
        JsonData betPlacementScanner = new JsonData();
        UserInput.loginScanner();
        Login.returnToken();
        UserInput.userSelection(scanner);
        //BetPlacement.placeLayBet();
        BetPlacement.returnEventTypes(betPlacementScanner, scanner);


    }



}


