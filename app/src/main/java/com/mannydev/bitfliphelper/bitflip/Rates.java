package com.mannydev.bitfliphelper.bitflip;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class Rates {
    @SerializedName("list")
    @Expose
    private ArrayList<Coin> list;

    public ArrayList<Coin> getList() {
        return list;
    }

    public void setList(ArrayList<Coin> list) {
        this.list = list;
    }
}
