package com.mannydev.bitfliphelper.bitflip;


public class Token {
    private String name;
    private double ballance;
    private double price;

    public Token(String name, double ballance, double price) {
        this.name = name;
        this.ballance = ballance;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBallance() {
        return ballance;
    }

    public void setBallance(double ballance) {
        this.ballance = ballance;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
