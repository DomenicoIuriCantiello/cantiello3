package com.example.esame_cantiello;

import android.content.Intent;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DettaglioDeiMenu extends AppCompatActivity {

    private TextView antipasto;
    private TextView primo;
    private TextView secondo;
    private TextView frutta;
    private TextView dolce;
    public static final String EXTRA_Antipasto =
            "com.example.esame_cantiello.EXTRA_Antipasto";
    public static final String EXTRA_Primo =
            "com.example.esame_cantiello.EXTRA_Primo";
    public static final String EXTRA_Secondo =
            "com.example.esame_cantiello.EXTRA_Secondo";
    public static final String EXTRA_Frutta =
            "com.example.esame_cantiello.EXTRA_Frutta";
    public static final String EXTRA_Dolce =
            "com.example.esame_cantiello.EXTRA_Dolce";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dettaglio_dei_menu);

        antipasto=findViewById(R.id.textAntipasto);
        primo=findViewById(R.id.textPrimo);
        secondo=findViewById(R.id.textSecondo);
        frutta=findViewById(R.id.textFrutta);
        dolce=findViewById(R.id.textDolce);

        Intent intent = getIntent();
        antipasto.setText(intent.getStringExtra(EXTRA_Antipasto));
        primo.setText(intent.getStringExtra(EXTRA_Primo));
        secondo.setText(intent.getStringExtra(EXTRA_Secondo));
        frutta.setText(intent.getStringExtra(EXTRA_Frutta));
        dolce.setText(intent.getStringExtra(EXTRA_Dolce));


    }
}
