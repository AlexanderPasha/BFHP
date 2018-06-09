package com.mannydev.bitfliphelper;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.mannydev.bitfliphelper.bitflip.Coin;
import com.squareup.picasso.Picasso;


public class CoinViewHolder extends RecyclerView.ViewHolder {
    TextView txtCoinName,txtUsdBuy,txtUsdSell,txtRubBuy,txtRubSell,txtUsdSpread,txtRubSpread,txtBrn,txtSrn;

    public CoinViewHolder(final View itemView) {
        super(itemView);
        txtCoinName = itemView.findViewById(R.id.txtCoinName);
        txtUsdBuy = itemView.findViewById(R.id.txtUsdBuy);
        txtUsdSell = itemView.findViewById(R.id.txtUsdSell);
        txtRubBuy = itemView.findViewById(R.id.txtRubBuy);
        txtRubSell = itemView.findViewById(R.id.txtRubSell);
        txtUsdSpread = itemView.findViewById(R.id.txtUsdSpread);
        txtRubSpread = itemView.findViewById(R.id.txtRubSpread);
        txtBrn = itemView.findViewById(R.id.txtBrn);
        txtSrn = itemView.findViewById(R.id.txtSrn);
    }



    public void onBindCoinHolder(Coin coin){
        txtCoinName.setText(coin.getName());
        txtUsdBuy.setText(String.valueOf(coin.getUsdBuy()));
        txtUsdSell.setText(String.valueOf(coin.getUsdSell()));
        txtRubBuy.setText(String.valueOf(coin.getRubBuy()));
        txtRubSell.setText(String.valueOf(coin.getRubSell()));
        txtUsdSpread.setText(coin.getUsdSpread());
        txtRubSpread.setText(coin.getRubSpread());
        txtBrn.setText(coin.getRightNowBuyProfit());
        txtSrn.setText(coin.getRightNowSellProfit());

        if(coin.isBestBuyUsd()){
            txtUsdBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.bestProfitColor));
            txtRubBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.text_color_white));
        }else{
            txtRubBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.bestProfitColor));
            txtUsdBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.text_color_white));
        }

        if(coin.isBestSellUsd()){
            txtUsdSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.bestProfitColor));
            txtRubSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.text_color_white));
        }else {
            txtRubSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.bestProfitColor));
            txtUsdSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.text_color_white));
        }

    }
}
