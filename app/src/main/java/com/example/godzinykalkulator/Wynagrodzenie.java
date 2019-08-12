package com.example.godzinykalkulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Wynagrodzenie extends AppCompatActivity {

    TextView netto;
    TextView brutto;
    String net;
    String bru;
    String rachunek;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wynagrodzenie);

        netto = findViewById(R.id.wynagnetto);
        brutto = findViewById(R.id.wynagbrutto);
        textView = findViewById(R.id.rachunek);

        net = netto.getText().toString() + " " + wynagrodzenie(getIntent().getIntExtra("brutto", 0));
        bru = brutto.getText().toString() + " " + getIntent().getIntExtra("brutto", 0);
        rachunek = "Godziny na rachunku to " + getIntent().getIntExtra("godziny", 0)/2 + "\nKwota na rachunku to " + getIntent().getIntExtra("brutto", 0)/2;

        netto.setText(net);
        brutto.setText(bru);
        textView.setText(rachunek);
    }
    private String wynagrodzenie(int i){
        int cal = i;
        double koszt = cal * 0.2;
        int podatkowa = cal - wartosc(koszt);
        double pit = podatkowa * 0.18;
        int zarobek = cal - wartosc(pit);
        String zysk = String.valueOf(zarobek);
        return zysk;
    }

    private int wartosc(double d){
        int a = (int)d;
        d-=a;
        if(d>=0.5){
            a+=1;
        }
        return a;
    }
}
