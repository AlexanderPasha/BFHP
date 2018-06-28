package com.mannydev.bitfliphelper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mannydev.bitfliphelper.bitflip.Token;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

import static com.mannydev.bitfliphelper.MainActivity.bitflip;



public class MyTokensListViewAdapter extends BaseAdapter {
    private LayoutInflater lInflater;
    TextView txtTokenName, txtTokenBalance, txtUsd, txtProfit;
    ArrayList<Token>list;
    Map<String,String>coinsLogos;

    public MyTokensListViewAdapter(ArrayList<Token>list) {
        this.list = list;
        coinsLogos = new HashMap<String, String>();
        coinsLogos.put("BTC","https://s2.coinmarketcap.com/static/img/coins/32x32/1.png");
        coinsLogos.put("LTC","https://s2.coinmarketcap.com/static/img/coins/32x32/2.png");
        coinsLogos.put("ETH","https://s2.coinmarketcap.com/static/img/coins/32x32/1027.png");
        coinsLogos.put("XRP","https://s2.coinmarketcap.com/static/img/coins/32x32/52.png");
        coinsLogos.put("TRX","https://s2.coinmarketcap.com/static/img/coins/32x32/1958.png");
        coinsLogos.put("FLIP","https://bitflip.cc/img/S.svg");
        coinsLogos.put("DASH","https://s2.coinmarketcap.com/static/img/coins/32x32/131.png");
        coinsLogos.put("DOGE","https://s2.coinmarketcap.com/static/img/coins/32x32/74.png");
        coinsLogos.put("BCH","https://s2.coinmarketcap.com/static/img/coins/32x32/1831.png");
        coinsLogos.put("R","https://s2.coinmarketcap.com/static/img/coins/32x32/2135.png");
        coinsLogos.put("RMC","https://s2.coinmarketcap.com/static/img/coins/32x32/2125.png");
        coinsLogos.put("BTG","https://s2.coinmarketcap.com/static/img/coins/32x32/2083.png");
        coinsLogos.put("XRB","https://cryptocash.guru/wp-content/uploads/2018/01/Raiblocks-e1515532746199.png");
        coinsLogos.put("FOOD","https://pbs.twimg.com/profile_images/933964866565615616/TV8E8ssQ_400x400.jpg");
        coinsLogos.put("REAL","https://s2.coinmarketcap.com/static/img/coins/32x32/2030.png");
        coinsLogos.put("EOS","https://s2.coinmarketcap.com/static/img/coins/32x32/1765.png");
        coinsLogos.put("BTW","https://s2.coinmarketcap.com/static/img/coins/32x32/2489.png");
        coinsLogos.put("LINDA","https://s2.coinmarketcap.com/static/img/coins/32x32/1814.png");
        coinsLogos.put("BEN","https://pbs.twimg.com/profile_images/966035484513308672/xI-Lg2u8_400x400.jpg");
        coinsLogos.put("CSC","https://s2.coinmarketcap.com/static/img/coins/32x32/45.png");


    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View view = convertView;

        lInflater = (LayoutInflater) parent.getContext()
                .getApplicationContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null) {
            view = lInflater.inflate(R.layout.coin_bag_view1, parent, false);
        }




        txtTokenName = view.findViewById(R.id.txtTokenName);
        txtTokenBalance = view.findViewById(R.id.txtTokenBalance);
        txtUsd = view.findViewById(R.id.txtTokenUsdBalance);
        txtProfit = view.findViewById(R.id.txtTokenProfit);

        txtTokenName.setTextColor(view.getContext().getResources().getColor(R.color.text_color_dark));
        txtTokenBalance.setTextColor(view.getContext().getResources().getColor(R.color.text_color_dark));
        txtUsd.setTextColor(view.getContext().getResources().getColor(R.color.text_color_dark));
        txtProfit.setTextColor(view.getContext().getResources().getColor(R.color.text_color_dark));

        Token token = (Token) getItem(i);

        Picasso.with(view.getContext())
                .load(coinsLogos.get(token.getName()))
                .resize(32,32)
                .transform(new CropCircleTransformation())
                .centerCrop()
                .into((ImageView) view.findViewById(R.id.ivTokenLogo));

        txtTokenName.setText(token.getName());
        txtTokenBalance.setText(roundResult1(token.getBallance()));
        double usd = 0.0;

        if(token.getName().equals("BTC")){
            usd = bitflip.getBtcUsd().getBuy()*token.getBallance();
            txtProfit.setText(calcProfit(bitflip.getBtcUsd().getBuy(),token.getPrice()));
        }
        if(token.getName().equals("LTC")){
            usd = bitflip.getLtcUsd().getBuy()*token.getBallance();
            txtProfit.setText(calcProfit(bitflip.getLtcUsd().getBuy(),token.getPrice()));
        }
        if(token.getName().equals("ETH")){
            usd = bitflip.getEthUsd().getBuy()*token.getBallance();
            txtProfit.setText(calcProfit(bitflip.getEthUsd().getBuy(),token.getPrice()));
        }
        if(token.getName().equals("XRP")){
            usd = bitflip.getXrpUsd().getBuy()*token.getBallance();
            txtProfit.setText(calcProfit(bitflip.getXrpUsd().getBuy(),token.getPrice()));
        }
        if(token.getName().equals("TRX")){
            usd = bitflip.getTrxUsd().getBuy()*token.getBallance();
            txtProfit.setText(calcProfit(bitflip.getTrxUsd().getBuy(),token.getPrice()));
        }
        if(token.getName().equals("FLIP")){
            usd = bitflip.getFlipUsd().getBuy()*token.getBallance();
            txtProfit.setText(calcProfit(bitflip.getFlipUsd().getBuy(),token.getPrice()));
        }
        if(token.getName().equals("DASH")){
            usd = bitflip.getDashUsd().getBuy()*token.getBallance();
            txtProfit.setText(calcProfit(bitflip.getDashUsd().getBuy(),token.getPrice()));
        }
        if(token.getName().equals("DOGE")){
            usd = bitflip.getDogeUsd().getBuy()*token.getBallance();
            txtProfit.setText(calcProfit(bitflip.getDogeUsd().getBuy(),token.getPrice()));
        }
        if(token.getName().equals("BCH")){
            usd = bitflip.getBchUsd().getBuy()*token.getBallance();
            txtProfit.setText(calcProfit(bitflip.getBchUsd().getBuy(),token.getPrice()));
        }
        if(token.getName().equals("R")){
            usd = bitflip.getrUsd().getBuy()*token.getBallance();
            txtProfit.setText(calcProfit(bitflip.getrUsd().getBuy(),token.getPrice()));
        }
        if(token.getName().equals("RMC")){
            usd = bitflip.getRmcUsd().getBuy()*token.getBallance();
            txtProfit.setText(calcProfit(bitflip.getRmcUsd().getBuy(),token.getPrice()));
        }
        if(token.getName().equals("BTG")){
            usd = bitflip.getBtgUsd().getBuy()*token.getBallance();
            txtProfit.setText(calcProfit(bitflip.getBtgUsd().getBuy(),token.getPrice()));
        }
        if(token.getName().equals("NANO")){
            usd = bitflip.getNanoUsd().getBuy()*token.getBallance();
            txtProfit.setText(calcProfit(bitflip.getNanoUsd().getBuy(),token.getPrice()));
        }
        if(token.getName().equals("FOOD")){
            usd = bitflip.getFoodUsd().getBuy()*token.getBallance();
            txtProfit.setText(calcProfit(bitflip.getFoodUsd().getBuy(),token.getPrice()));
        }
        if(token.getName().equals("REAL")){
            usd = bitflip.getRealUsd().getBuy()*token.getBallance();
            txtProfit.setText(calcProfit(bitflip.getRealUsd().getBuy(),token.getPrice()));
        }
        if(token.getName().equals("EOS")){
            usd = bitflip.getEosUsd().getBuy()*token.getBallance();
            txtProfit.setText(calcProfit(bitflip.getEosUsd().getBuy(),token.getPrice()));
        }
        if(token.getName().equals("BTW")){
            usd = bitflip.getBtwUsd().getBuy()*token.getBallance();
            txtProfit.setText(calcProfit(bitflip.getBtwUsd().getBuy(),token.getPrice()));
        }
        if(token.getName().equals("LINDA")){
            usd = bitflip.getLindaUsd().getBuy()*token.getBallance();
            txtProfit.setText(calcProfit(bitflip.getLindaUsd().getBuy(),token.getPrice()));
        }
        if(token.getName().equals("BEN")){
            usd = bitflip.getBenUsd().getBuy()*token.getBallance();
            txtProfit.setText(calcProfit(bitflip.getBenUsd().getBuy(),token.getPrice()));
        }
        if(token.getName().equals("CSC")){
            usd = bitflip.getCscUsd().getBuy()*token.getBallance();
            txtProfit.setText(calcProfit(bitflip.getCscUsd().getBuy(),token.getPrice()));
        }
        txtUsd.setText(roundResult(usd));
        return view;
    }

    private String calcProfit(double buyNew, double myBuy) {
        double profit;
        if (buyNew>myBuy){
            profit = buyNew*100/myBuy-100;
            return "+"+roundResult(profit)+"%";
        }
        if (buyNew<myBuy){
            profit = buyNew*100/myBuy-100;
            return roundResult(profit)+"%";
        }
        return "0%";
    }

    String roundResult(double d) {
        return String.format("%.2f", d);
    }
    String roundResult1(double d) {
        return String.format("%.4f", d);
    }
}
