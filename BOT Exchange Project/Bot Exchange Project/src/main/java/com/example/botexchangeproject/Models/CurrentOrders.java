package com.example.botexchangeproject.Models;

import java.util.List;

public class CurrentOrders {
    public List<CurrentOrder> getCurrentOrders() {
        return currentOrders;
    }

    public void setCurrentOrders(List<CurrentOrder> currentOrders) {
        this.currentOrders = currentOrders;
    }

    List<CurrentOrder> currentOrders;
}
