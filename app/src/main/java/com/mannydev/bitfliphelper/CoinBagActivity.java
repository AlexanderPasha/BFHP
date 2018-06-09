package com.mannydev.bitfliphelper;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mannydev.bitfliphelper.bitflip.Bitflip;
import com.mannydev.bitfliphelper.bitflip.Controller;
import com.mannydev.bitfliphelper.bitflip.Token;
import com.mannydev.bitfliphelper.bitflip.Tokens;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.mannydev.bitfliphelper.MainActivity.RATES;


public class CoinBagActivity extends AppCompatActivity {

    @BindView(R.id.btnBack)
    Button btnBack;
    @BindView(R.id.txtUsd)
    TextView txtUsd;
    @BindView(R.id.txtBallance)
    TextView txtBallance;
    @BindView(R.id.btnAddCoin)
    Button btnAddCoin;
    @BindView(R.id.toolbar3)
    Toolbar toolbar3;
    @BindView(R.id.rvTokens)
    RecyclerView rvTokens;

    private static final String COINS = "coins";

    private SharedPreferences myTokens;
    private ArrayList<Token> tokens;
    public static Bitflip bitflip;
    Controller controller;
    Dialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_bag);
        ButterKnife.bind(this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvTokens.setLayoutManager(mLayoutManager);

        myTokens = getSharedPreferences(COINS, MODE_PRIVATE);

        bitflip = Bitflip.getInstanse();
        controller = new Controller(bitflip);


    }

    @OnClick({R.id.btnBack, R.id.btnAddCoin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnBack:
                finish();
                break;
            case R.id.btnAddCoin:
                dialog = new Dialog(CoinBagActivity.this);

                // Установите заголовок
                dialog.setTitle("Add tokens:");
                // Передайте ссылку на разметку
                dialog.setContentView(R.layout.dialog_add_coin_view);
                // Найдите элемент TextView внутри вашей разметки
                // и установите ему соответствующий текст
                //TextView text = (TextView) dialog.findViewById(R.id.dialogTextView);
                //text.setText("Текст в диалоговом окне. Вы любите котов?");
                dialog.show();
                break;
        }
    }

    private void objectToCache(Object object, String label) {
        Gson gson = new GsonBuilder().create();
        String s = gson.toJson(object);
        SharedPreferences.Editor editor = myTokens.edit();
        editor.putString(label, s);
        editor.apply();
    }

    private void getRatesFromCashe() {
        Gson gson = new GsonBuilder().create();
        Tokens myCoins = gson.fromJson(myTokens.getString(RATES, null), Tokens.class);
        tokens = myCoins.getTokens();
    }

    private void refresh() {

    }

}
