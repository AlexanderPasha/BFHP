package com.mannydev.bitfliphelper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mannydev.bitfliphelper.bitflip.Bitflip;
import com.mannydev.bitfliphelper.bitflip.Coin;
import com.mannydev.bitfliphelper.bitflip.Controller;
import com.mannydev.bitfliphelper.bitflip.Pair;
import com.mannydev.bitfliphelper.bitflip.Rates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.mannydev.bitfliphelper.MainActivity.bitflip;
import static com.mannydev.bitfliphelper.MainActivity.context;


public class MainActivity extends AppCompatActivity {
    //Константы
    private static final String APP_CACHE = "cache";
    public static final String RATES = "rates";
    public static final String USD = "usd";

    public static Bitflip bitflip;
    public static Context context;
    Controller controller;
    private SharedPreferences appCache;
    private InterstitialAd mInterstitialAd;
    int count;
    private PopupMenu popupMenu;

    //Views
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rvCoins)
    RecyclerView rvCoins;
    CoinViewAdapter adapter;
    ArrayList<Coin> coins;
    @BindView(R.id.btnRefresh)
    Button btnRefresh;
    @BindView(R.id.txtUsdRubBuy)
    TextView txtUsdRubBuy;
    @BindView(R.id.txtUsdRubSell)
    TextView txtUsdRubSell;
    @BindView(R.id.txtUsdRubSprd)
    TextView txtUsdRubSprd;
    @BindView(R.id.btnLogo)
    Button btnLogo;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;
    @BindView(R.id.linearLayout2)
    LinearLayout linearLayout2;
    @BindView(R.id.btnBag)
    Button btnBag;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bitflip = Bitflip.getInstanse();
        controller = new Controller(bitflip);
        appCache = getSharedPreferences(APP_CACHE, MODE_PRIVATE);
        count = 1;

        //Ads
        initAds();

        //RecycleView
        adapter = new CoinViewAdapter();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvCoins.setLayoutManager(mLayoutManager);

        if (appCache.contains(RATES) && appCache.contains(USD)) {
            getRatesFromCashe();
        } else {
            adapter.setData(coins);
            rvCoins.setAdapter(adapter);
        }
        refresh();

        //Меню
        addPopupMenu();
    }

    //Ads
    private void initAds() {
        MobileAds.initialize(this, "ca-app-pub-8078146669032188~1365926913");
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-8078146669032188/3620199943");
    }

    //Меню
    private void addPopupMenu() {
        popupMenu = new PopupMenu(this, btnLogo);
        MenuInflater menuInflater = popupMenu.getMenuInflater();
        menuInflater.inflate(R.menu.menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent;
                switch (item.getItemId()) {
                    case R.id.menu1:
                        intent = new Intent(getApplicationContext(), AboutActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.menu2:
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://bitflip.cc/?ref=13d2mocg9b8g"));
                        startActivity(intent);
                        break;
                    case R.id.menu3:
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("market://details?id=com.mannydev.bitfliphelper"));
                        startActivity(intent);
                        break;
                    case R.id.menu4:
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("market://details?id=com.mannydev.bitfliphelperpro"));
                        startActivity(intent);
                        break;
                    case R.id.menu5:
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("market://details?id=com.mannydev.exmohelper"));
                        startActivity(intent);
                        break;
                    case R.id.menu6:
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("market://details?id=com.mannydev.wexhelper"));
                        startActivity(intent);
                        break;
                }
                return true;
            }

        });
    }

    //Обновление данных
    void refresh() {
        if (hasConnection(MainActivity.this)) {
            RatesGetter rg = new RatesGetter();
            rg.execute();
            coins = controller.getCoins();

            if (!coins.isEmpty()) {
                Rates rates = new Rates();
                rates.setList(coins);
                objectToCache(rates, RATES);
                objectToCache(bitflip.getUsdRub(), USD);
                txtUsdRubBuy.setText(String.valueOf(bitflip.getUsdRub().getBuy()));
                txtUsdRubSell.setText(String.valueOf(bitflip.getUsdRub().getSell()));
                txtUsdRubSprd.setText(Coin.getSpread(bitflip.getUsdRub()));
                adapter.setData(coins);
                adapter.notifyDataSetChanged();
            }

        } else {
            getRatesFromCashe();
            Toast.makeText(MainActivity.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
    }

    //Объекты в кеш
    private void objectToCache(Object object, String label) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String s = gson.toJson(object);
        SharedPreferences.Editor editor = appCache.edit();
        editor.putString(label, s);
        editor.apply();
    }

    //Объекты из кеша
    private void getRatesFromCashe() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Rates rates = gson.fromJson(appCache.getString(RATES, null), Rates.class);
        coins = rates.getList();
        Pair usd = gson.fromJson(appCache.getString(USD, null), Pair.class);
        txtUsdRubBuy.setText(String.valueOf(usd.getBuy()));
        txtUsdRubSell.setText(String.valueOf(usd.getSell()));
        txtUsdRubSprd.setText(Coin.getSpread(usd));
        adapter.setData(coins);
        rvCoins.setAdapter(adapter);
    }

    //Проверка соединения
    private static boolean hasConnection(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiInfo != null && wifiInfo.isConnected()) {
            return true;
        }
        wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (wifiInfo != null && wifiInfo.isConnected()) {
            return true;
        }
        wifiInfo = cm.getActiveNetworkInfo();
        return wifiInfo != null && wifiInfo.isConnected();
    }

    @OnClick({R.id.btnLogo, R.id.btnRefresh, R.id.btnBag})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnLogo:
                popupMenu.show();
                break;
            case R.id.btnRefresh:
                if (count % 4 == 0) {showAd();}
                count++;
                refresh();
                break;
            case R.id.btnBag:
                refresh();
                Intent intent = new Intent(getApplicationContext(), BagActivity.class);
                startActivity(intent);
                break;
        }
    }

    //Показать рекламу
    private void showAd() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }
}

class RatesGetter extends AsyncTask<Void, Void, String> {

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);

    }

    @Override
    protected String doInBackground(Void... voids) {
        StringBuilder response = new StringBuilder();
        String sourceUrl = "https://api.bitflip.cc/method/market.getRates";
        try {
            URL url = new URL(sourceUrl);
            HttpURLConnection httpconn = (HttpURLConnection) url.openConnection();
            httpconn.addRequestProperty("User-Agent", "Mozilla/4.76");
            if (httpconn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader input;
                input = new BufferedReader(new InputStreamReader(httpconn.getInputStream()));
                String strLine;
                while ((strLine = input.readLine()) != null) {
                    response.append(strLine);
                }
                input.close();
            }
            httpconn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String json = response.toString();
        if (response.length() > 50) {
            json = json.substring(6);
            json = json.substring(0, json.length() - 1);
            return json;
        }
        return null;
    }

    @Override
    protected void onPostExecute(String json) {
        super.onPostExecute(json);
        if (json != null) {
            bitflip.refresh(json);
            System.out.println("Rates refreshed");
        } else Toast.makeText(context, "Bad connection", Toast.LENGTH_SHORT).show();
    }

}


