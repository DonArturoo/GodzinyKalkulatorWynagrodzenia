package com.example.godzinykalkulator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    EditText dni;
    EditText stawka;
    EditText nadGodz;
    Switch plus_minus;
    Button przelicz;
    int godz = 0;
    int brutto = 0;
    int plus = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dni = findViewById(R.id.ileDni);
        stawka = findViewById(R.id.stawka);
        nadGodz = findViewById(R.id.nadgodziny);
        plus_minus = findViewById(R.id.plusMinus);
        przelicz = findViewById(R.id.przelicz);

        plus_minus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    plus = 1;
                }
                else{
                    plus = -1;
                }
            }
        });

        przelicz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                godz = Integer.parseInt(String.valueOf(dni.getText()))*8+(Integer.parseInt(String.valueOf(nadGodz.getText()))*plus);
                brutto = godz * Integer.parseInt(String.valueOf(stawka.getText()));

                Intent intent = new Intent(MainActivity.this, Wynagrodzenie.class);
                intent.putExtra("brutto", brutto);
                intent.putExtra("godziny",godz);
                startActivity(intent);
            }
        });
    }
}
