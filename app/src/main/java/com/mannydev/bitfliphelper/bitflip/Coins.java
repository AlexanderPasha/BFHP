package com.mannydev.bitfliphelper.bitflip;

import java.util.ArrayList;

/**
 * Created by manny on 17.05.18.
 */

public class Coins {
    private static ArrayList<String> coins;
    static{
        coins.add("BTC");
        coins.add("LTC");
        coins.add("ETH");
        coins.add("XRP");
        coins.add("TRX");
        coins.add("FLIP");
        coins.add("DASH");
        coins.add("DOGE");
        coins.add("BCH");
        coins.add("R");
        coins.add("RMC");
        coins.add("BTG");
        coins.add("XRB");
        coins.add("FOOD");
        coins.add("REAL");
        coins.add("EOS");
        coins.add("BTW");
        coins.add("LINDA");
        coins.add("BEN");
        coins.add("CSC");
    }

    public static ArrayList<String> getCoinsNames() {
        return coins;
    }
}
