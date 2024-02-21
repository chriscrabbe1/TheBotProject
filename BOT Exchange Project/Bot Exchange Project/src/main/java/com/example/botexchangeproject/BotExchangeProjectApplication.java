package com.example.botexchangeproject;


import com.example.botexchangeproject.Controllers.LoginController;
import com.example.botexchangeproject.Controllers.OpenBetsController;
import com.example.botexchangeproject.Models.LoginForm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BotExchangeProjectApplication{



    public static void main(String[] args) { SpringApplication.run(BotExchangeProjectApplication.class, args);

        //LoginController.createSession("rgssTZlPyFz6Cmnmbl", "P@rola03", null);
        //SessionTokenSupplier.retrieveSessionToken();
        //OpenBetsController.getOpenBets();


        //Login.returnToken(loginURL);
        //BetPlacement.placeLayBet();
        //JsonBodyBuilder.deleteBetJson();
        //ListCurrentBets.showLiveBets();
        //DeleteBets.cancelBet();


    }



}


