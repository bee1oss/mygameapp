package com.example.mygameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    TextView daycount;//gunsayaci
    TextView komurfiyat;//komurfiyati
    TextView moneyview;//parayi gormek icin olan textbox
    TextView levelview;//leveli gormek icin olan textbox
    TextView needformoney;//parayi gormek icin olan textbox
    TextView elseneed;//level atlamak icin parayetersiz oldugunda cikan uyari
    TextView komurmin;//kazdigimiz komuru goruyoruz;
    private double money;//para
    private double komur = 0;//kazilan komur sayisini tutar
    private double stronglvl = 1;//guc leveli
    private double payforlvl = 100;//level icin odemesi gereken para
    private int levelbelirleyici = 1;//hangi levelde oldugunu belirlemek icin
    private int day = 1;//gun sayaci

    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        needformoney = findViewById(R.id.needformoney);
        elseneed = findViewById(R.id.elseneed);
        daycount = findViewById(R.id.deycount);
        levelview = findViewById(R.id.levelview);
        moneyview = findViewById(R.id.moneyview);
        komurfiyat = findViewById(R.id.komurfiyat);
        komurmin = findViewById(R.id.komurmin);
        gostergeler();
        komurfiyat.setText("Fyt:" + komurfiyatrandom());

    }
    public void gostergeler(){
        levelview.setText("Lvl:" + levelbelirleyici);
        needformoney.setText(payforlvl + "$");
        fiyatduzenleyici();
        daycount.setText("Day:" + day);
        komurmin.setText("Coal:" + komur);

    }
    public void komurtopara(View view){
        money = money + (komur / komurfiyatrandom());
        gostergeler();
    }
    public void mineclick(View view){
        komur=komur+stronglvl;
        gostergeler();
    }
    public void levelminingstrong(View view){

        if(money >= payforlvl){
            money = money - payforlvl;
            stronglvl=stronglvl*2;
            payforlvl=payforlvl*3/2;
            levelbelirleyici++;
            gostergeler();
        }
        else {
            elseneed.setText("not enaugth money!" + payforlvl);
        }
        levelview.setText("Lvl:" + levelbelirleyici);
        gostergeler();
    }
    public void endday(View view){
        day = day + 1;

        komurfiyat.setText("Fyt:" + komurfiyatrandom());
    }
    public double komurfiyatrandom(){
        double komurfiyatrandom = (rand.nextFloat()*2)+3;
        Double d = (double) (Math.round(komurfiyatrandom*10.0)/10.0);
        return d;
    }

    public void fiyatduzenleyici(){
        ;
        moneyview.setText("Mon:" + fiyatduzenle(money));
    }
    public double fiyatduzenle(double a){
        Double d = (double) (Math.round(a*10.0)/10.0);
        return d;
    }
}

//komur bozdurma olayi