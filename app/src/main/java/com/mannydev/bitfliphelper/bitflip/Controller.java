/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mannydev.bitfliphelper.bitflip;

import java.util.*;

/**
 *
 * @author manny
 */
public class Controller implements Observer {

    private Pair usdRub, btcUsd, btcRub, ltcUsd, ltcRub,
            ethUsd, ethRub, xrpUsd, xrpRub, trxUsd, trxRub, flipUsd, flipRub,
            dashUsd, dashRub, dogeUsd, dogeRub, bchUsd, bchRub, rUsd, rRub,
            rmcUsd, rmcRub, btgUsd, btgRub, nanoUsd, nanoRub, foodUsd, foodRub, realUsd, realRub,
            eosUsd,eosRub,btwUsd,btwRub,lindaUsd,lindaRub, benUsd, benRub, cscUsd, cscRub;

    private Coin btc, ltc, eth, xrp, trx, flip,
            dash, doge, bch, r, rmc, btg, nano, food, real, eos, btw,linda, ben, csc;

    Observable observable;
    ArrayList<Coin> coins;

    public Controller(Observable observable) {
        this.observable = observable;
        this.observable.addObserver(this);
        this.coins = new ArrayList<>();
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Bitflip) {
            Bitflip bitflip = (Bitflip) o;
            updatePairs(bitflip);
            updateCoins();
        }
    }

    private void updatePairs(Bitflip b) {
        this.usdRub = b.getUsdRub();
        this.btcUsd = b.getBtcUsd();
        this.btcRub = b.getBtcRub();
        this.ltcUsd = b.getLtcUsd();
        this.ltcRub = b.getLtcRub();
        this.ethUsd = b.getEthUsd();
        this.ethRub = b.getEthRub();
        this.xrpUsd = b.getXrpUsd();
        this.xrpRub = b.getXrpRub();
        this.trxUsd = b.getTrxUsd();
        this.trxRub = b.getTrxRub();
        this.flipUsd = b.getFlipUsd();
        this.flipRub = b.getFlipRub();
        this.dashUsd = b.getDashUsd();
        this.dashRub = b.getDashRub();
        this.dogeUsd = b.getDogeUsd();
        this.dogeRub = b.getDogeRub();
        this.bchUsd = b.getBchUsd();
        this.bchRub = b.getBchRub();
        this.rUsd = b.getrUsd();
        this.rRub = b.getrRub();
        this.rmcUsd = b.getRmcUsd();
        this.rmcRub = b.getRmcRub();
        this.btgUsd = b.getBtgUsd();
        this.btgRub = b.getBtgRub();
        this.nanoUsd = b.getNanoUsd();
        this.nanoRub = b.getNanoRub();
        this.foodUsd = b.getFoodUsd();
        this.foodRub = b.getFoodRub();
        this.realUsd = b.getRealUsd();
        this.realRub = b.getRealRub();
        this.eosUsd = b.getEosUsd();
        this.eosRub = b.getEosRub();
        this.btwUsd = b.getBtwUsd();
        this.btwRub = b.getBtwRub();
        this.lindaUsd = b.getLindaUsd();
        this.lindaRub = b.getLindaRub();
        this.benUsd = b.getBenUsd();
        this.benRub = b.getBenRub();
        this.cscUsd = b.getCscUsd();
        this.cscRub = b.getCscRub();
    }

    private void updateCoins() {
        this.btc = new Coin("BTC", btcUsd, btcRub, usdRub);
        this.ltc = new Coin("LTC", ltcUsd, ltcRub, usdRub);
        this.eth = new Coin("ETH", ethUsd, ethRub, usdRub);
        this.xrp = new Coin("XRP", xrpUsd, xrpRub, usdRub);
        this.trx = new Coin("TRX", trxUsd, trxRub, usdRub);
        this.flip = new Coin("FLIP", flipUsd, flipRub, usdRub);
        this.dash = new Coin("DASH", dashUsd, dashRub, usdRub);
        this.doge = new Coin("DOGE", dogeUsd, dogeRub, usdRub);
        this.bch = new Coin("BCH", bchUsd, bchRub, usdRub);
        this.r = new Coin("R", rUsd, rRub, usdRub);
        this.rmc = new Coin("RMC", rmcUsd, rmcRub, usdRub);
        this.btg = new Coin("BTG", btgUsd, btgRub, usdRub);
        this.nano = new Coin("NANO", nanoUsd, nanoRub, usdRub);
        this.food = new Coin("FOOD", foodUsd, foodRub, usdRub);
        this.real = new Coin("REAL", realUsd, realRub, usdRub);
        this.eos = new Coin("EOS", eosUsd, eosRub, usdRub);
        this.btw = new Coin("BTW", btwUsd, btwRub, usdRub);
        this.linda = new Coin("LINDA", lindaUsd, lindaRub, usdRub);
        this.ben = new Coin("BEN",benUsd,benRub,usdRub);
        this.csc = new Coin("CSC",cscUsd,cscRub,usdRub);
        addCoinsToList();
    }

    private void addCoinsToList() {
        coins = new ArrayList<>();
        coins.add(btc);
        coins.add(ltc);
        coins.add(eth);
        coins.add(xrp);
        coins.add(trx);
        coins.add(flip);
        coins.add(dash);
        coins.add(doge);
        coins.add(bch);
        coins.add(r);
        coins.add(rmc);
        coins.add(btg);
        coins.add(nano);
        coins.add(food);
        coins.add(real);
        coins.add(eos);
        coins.add(btw);
        coins.add(linda);
        coins.add(ben);
        coins.add(csc);
    }

    public ArrayList getCoins() {
        return coins;
    }

}
