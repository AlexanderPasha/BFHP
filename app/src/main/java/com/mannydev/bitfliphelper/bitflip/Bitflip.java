/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mannydev.bitfliphelper.bitflip;

import java.util.Observable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Bitflip extends Observable {

    private static Bitflip bitflip;

    private Pair usdRub;
    private Pair btcUsd;
    private Pair btcRub;
    private Pair ltcUsd;
    private Pair ltcRub;
    private Pair ethUsd;
    private Pair ethRub;
    private Pair xrpUsd;
    private Pair xrpRub;
    private Pair trxUsd;
    private Pair trxRub;
    private Pair flipUsd;
    private Pair flipRub;
    private Pair dashUsd;
    private Pair dashRub;
    private Pair dogeUsd;
    private Pair dogeRub;
    private Pair bchUsd;
    private Pair bchRub;
    private Pair rUsd;
    private Pair rRub;
    private Pair rmcUsd;
    private Pair rmcRub;
    private Pair btgUsd;
    private Pair btgRub;
    private Pair nanoUsd;
    private Pair nanoRub;
    private Pair foodUsd;
    private Pair foodRub;
    private Pair realUsd;
    private Pair realRub;
    private Pair eosUsd;
    private Pair eosRub;
    private Pair btwUsd;
    private Pair btwRub;

    private Pair lindaUsd;
    private Pair lindaRub;

    private Pair benUsd;
    private Pair benRub;

    private Pair cscUsd;
    private Pair cscRub;

    private Bitflip() {
        initPairs();
    }

    public static Bitflip getInstanse(){
        if (bitflip==null){
            bitflip = new Bitflip();
            System.out.println("Bitflip создан!");
            return bitflip;
        }else{
            return bitflip;
        }
    }

    private void ratesChanged() {
        setChanged();
        notifyObservers();
    }

    private void initPairs() {
        usdRub = new Pair();
        btcUsd = new Pair();
        btcRub = new Pair();
        ltcUsd = new Pair();
        ltcRub = new Pair();
        ethUsd = new Pair();
        ethRub = new Pair();
        xrpUsd = new Pair();
        xrpRub = new Pair();
        trxUsd = new Pair();
        trxRub = new Pair();
        flipUsd = new Pair();
        flipRub = new Pair();
        dashUsd = new Pair();
        dashRub = new Pair();
        dogeUsd = new Pair();
        dogeRub = new Pair();
        bchUsd = new Pair();
        bchRub = new Pair();
        rUsd = new Pair();
        rRub = new Pair();
        rmcUsd = new Pair();
        rmcRub = new Pair();
        btgUsd = new Pair();
        btgRub = new Pair();
        nanoUsd = new Pair();
        nanoRub = new Pair();
        foodUsd = new Pair();
        foodRub = new Pair();
        realUsd = new Pair();
        realRub = new Pair();
        eosUsd = new Pair();
        eosRub = new Pair();
        btwUsd = new Pair();
        btwRub = new Pair();

        lindaUsd = new Pair();
        lindaRub = new Pair();

        benUsd = new Pair();
        benRub = new Pair();

        cscUsd = new Pair();
        cscRub = new Pair();
    }

    public void refresh(String rates) {
        JSONArray array = null;
        try {
            array = new JSONArray(rates);


        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);

            if (object.get("pair").equals("USD:RUB")) {
                this.usdRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("LTC:USD")) {
                this.ltcUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("LTC:RUB")) {
                this.ltcRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }
            if (object.get("pair").equals("BTC:USD")) {
                this.btcUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }
            if (object.get("pair").equals("BTC:RUB")) {
                this.btcRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }
            if (object.get("pair").equals("ETH:USD")) {
                this.ethUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("ETH:RUB")) {
                this.ethRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }
            if (object.get("pair").equals("XRP:USD")) {
                this.xrpUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("XRP:RUB")) {
                this.xrpRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }
            if (object.get("pair").equals("TRX:USD")) {
                this.trxUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("TRX:RUB")) {
                this.trxRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }
            if (object.get("pair").equals("FLIP:USD")) {
                this.flipUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("FLIP:RUB")) {
                this.flipRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("DASH:USD")) {
                this.dashUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("DASH:RUB")) {
                this.dashRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("DOGE:USD")) {
                this.dogeUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("DOGE:RUB")) {
                this.dogeRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("BCH:USD")) {
                this.bchUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("BCH:RUB")) {
                this.bchRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("R:USD")) {
                this.rUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("R:RUB")) {
                this.rRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("RMC:USD")) {
                this.rmcUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("RMC:RUB")) {
                this.rmcRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("BTG:USD")) {
                this.btgUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("BTG:RUB")) {
                this.btgRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("NANO:USD")) {
                this.nanoUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("NANO:RUB")) {
                this.nanoRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("FOOD:USD")) {
                this.foodUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("FOOD:RUB")) {
                this.foodRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }
            if (object.get("pair").equals("REAL:USD")) {
                this.realUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("REAL:RUB")) {
                this.realRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }
            if (object.get("pair").equals("EOS:USD")) {
                this.eosUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("EOS:RUB")) {
                this.eosRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }
            if (object.get("pair").equals("BTW:USD")) {
                this.btwUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("BTW:RUB")) {
                this.btwRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("LINDA:USD")) {
                this.lindaUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("LINDA:RUB")) {
                this.lindaRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("BEN:USD")) {
                this.benUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("BEN:RUB")) {
                this.benRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("CSC:USD")) {
                this.cscUsd = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }

            if (object.get("pair").equals("CSC:RUB")) {
                this.cscRub = new Pair((String) object.get("pair"),
                        object.getDouble("buy"),
                        object.getDouble("sell"));
            }
        }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ratesChanged();
    }

    public Pair getUsdRub() {
        return usdRub;
    }

    public Pair getBtcUsd() {
        return btcUsd;
    }

    public Pair getBtcRub() {
        return btcRub;
    }

    public Pair getLtcUsd() {
        return ltcUsd;
    }

    public Pair getLtcRub() {
        return ltcRub;
    }

    public Pair getEthUsd() {
        return ethUsd;
    }

    public Pair getEthRub() {
        return ethRub;
    }

    public Pair getXrpUsd() {
        return xrpUsd;
    }

    public Pair getXrpRub() {
        return xrpRub;
    }

    public Pair getTrxUsd() {
        return trxUsd;
    }

    public Pair getTrxRub() {
        return trxRub;
    }

    public Pair getFlipUsd() {
        return flipUsd;
    }

    public Pair getFlipRub() {
        return flipRub;
    }

    public Pair getDashUsd() {
        return dashUsd;
    }

    public Pair getDashRub() {
        return dashRub;
    }

    public Pair getDogeUsd() {
        return dogeUsd;
    }

    public Pair getDogeRub() {
        return dogeRub;
    }

    public Pair getBchUsd() {
        return bchUsd;
    }

    public Pair getBchRub() {
        return bchRub;
    }

    public Pair getrUsd() {
        return rUsd;
    }

    public Pair getrRub() {
        return rRub;
    }

    public Pair getRmcUsd() {
        return rmcUsd;
    }

    public Pair getRmcRub() {
        return rmcRub;
    }

    public Pair getBtgUsd() {
        return btgUsd;
    }

    public Pair getBtgRub() {
        return btgRub;
    }

    public Pair getNanoUsd() {
        return nanoUsd;
    }

    public Pair getNanoRub() {
        return nanoRub;
    }

    public Pair getFoodUsd() {
        return foodUsd;
    }

    public Pair getFoodRub() {
        return foodRub;
    }

    public Pair getRealUsd() {
        return realUsd;
    }

    public Pair getRealRub() {
        return realRub;
    }

    public Pair getEosUsd() {
        return eosUsd;
    }

    public Pair getEosRub() {
        return eosRub;
    }

    public Pair getBtwUsd() {
        return btwUsd;
    }

    public Pair getBtwRub() {
        return btwRub;
    }

    public Pair getLindaUsd() {
        return lindaUsd;
    }

    public Pair getLindaRub() {
        return lindaRub;
    }

    public Pair getBenUsd() {
        return benUsd;
    }

    public Pair getBenRub() {
        return benRub;
    }

    public Pair getCscUsd() {
        return cscUsd;
    }

    public Pair getCscRub() {
        return cscRub;
    }
}


