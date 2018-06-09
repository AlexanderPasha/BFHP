package com.mannydev.bitfliphelper;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mannydev.bitfliphelper.bitflip.Coin;

import java.util.ArrayList;

/**
 * Created by manny on 16.01.18.
 */

public class CoinViewAdapter extends RecyclerView.Adapter<CoinViewHolder> {
    ArrayList<Coin>list;

    public CoinViewAdapter() {

    }

    public void setData(ArrayList<Coin> list){
        this.list = list;
    }

    @Override
    public CoinViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.coin_view, parent, false);
        return new CoinViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CoinViewHolder holder, int position) {
        final Coin coin = list.get(position);
        holder.onBindCoinHolder(coin);
    }

    @Override
    public int getItemCount() {
        if (list == null)
            return 0;
        return list.size();
    }
}
