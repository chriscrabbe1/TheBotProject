package com.example.botexchangeproject.Models;

public class CurrentOrder {
    String betId;
    String marketId;

    PriceSize priceSize;

    public class PriceSize {
        String price;
        String size;
    }

}
