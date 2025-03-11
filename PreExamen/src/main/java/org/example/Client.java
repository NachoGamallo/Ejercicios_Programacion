package org.example;

public class Client extends PizzaExpress implements OrderActions{

    private String name;
    private int discount;

    public Client(String name){

        this.name = name;
        this.discount = 20;

    }

    public Client(String name , int discount){

        this.name = name;
        this.discount = discount;

    }

    public void ask(){}

    public void pay(){}

    public void recollect(){}

    public void cancel(Order order) {}

    void obtainDetails() {}
}
