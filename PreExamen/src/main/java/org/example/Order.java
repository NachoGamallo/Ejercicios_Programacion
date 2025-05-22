package org.example;

import java.util.ArrayList;

public class Order extends PizzaExpress{

    private Client client;
    private ArrayList<PizzasMenu> pizzasMenus;
    private Status orderStatus;

    public Order(Client client) {

        this.client = client;
        pizzasMenus = new ArrayList<>();


    }

    @Override
    void obtainDetails() {

    }

    public double applyDiscount(int discount){
        return 0.0;
    }
}
