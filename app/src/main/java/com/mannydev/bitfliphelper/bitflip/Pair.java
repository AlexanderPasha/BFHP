package com.mannydev.bitfliphelper.bitflip;

public class Pair {

    private String name;
    private double buy;
    private double sell;

    public Pair(String name, double buy, double sell) {
        this.name = name;
        this.buy = buy;
        this.sell = sell;
    }

    public Pair() {
    }

    public double getBuy() {
        return buy;
    }

    public void setBuy(double buy) {
        this.buy = buy;
    }

    public double getSell() {
        return sell;
    }

    public void setSell(double sell) {
        this.sell = sell;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
