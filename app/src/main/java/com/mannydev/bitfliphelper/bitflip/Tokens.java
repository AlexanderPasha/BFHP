package com.mannydev.bitfliphelper.bitflip;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class Tokens {
    @SerializedName("tokens")
    @Expose
    private ArrayList<Token>tokens;

    public ArrayList<Token> getTokens() {
        return tokens;
    }

    public void setTokens(ArrayList<Token> tokens) {
        this.tokens = tokens;
    }
}
