package com.example.cantiello3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class PrenoDettaglio extends AppCompatActivity {
TextView cliente;
TextView data;
Menu nomeMenu;
    TextView primo;
    TextView secondo;
    TextView frutta;
    TextView antipasto;
    TextView dolce;
TextView ospiti;
TextView categoria;
DaoMenu menuletto;
    public static final String EXTRA_NOME_CLIENTE =
            "com.example.cantiello3.EXTRA_NOME_CLIENTE";
    public static final String EXTRA_SELECT_MENU =
            "com.example.cantiello3.EXTRA_SELECT_MENU";
    public static final String EXTRA_SELECT_OPZIONE =
            "com.example.cantiello3.EXTRA_SELECT_OPZIONE";
    public static final String EXTRA_DATAEVENTO =
            "com.example.cantiello3.EXTRA_DATAEVENTO";
    public static final String EXTRA_TIPO_FESTA =
            "com.example.cantiello3.EXTRA_TIPO_FESTA";
    public static final String EXTRA_OSPITI =
            "com.example.cantiello3.EXTRA_OSPITI";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preno_dettaglio);
        cliente = findViewById(R.id.leggonome);
        primo= findViewById(R.id.primo_p);
        secondo= findViewById(R.id.secondo_p);
        frutta=findViewById(R.id.frutta);
        dolce=findViewById(R.id.dolce);
        antipasto=findViewById(R.id.antipasto);
        ospiti=findViewById(R.id.ospiti);
        categoria = findViewById(R.id.leggocategoria);
        data = findViewById(R.id.leggodata);
        final Intent intent = getIntent();

        // Leggo il nome del menu dall'extra
        // Leggo il menu dal database

        DatabasePrenotazione db = DatabasePrenotazione.getInstance(this);
        menuletto=db.daoMenu();

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                String menu = intent.getStringExtra(EXTRA_SELECT_MENU);
                nomeMenu = menuletto.getMenu(menu);
                antipasto.setText(nomeMenu.getAntipasto());
                primo.setText(nomeMenu.getPrimoPiatto());
                secondo.setText(nomeMenu.getSecondoPiatto());
                frutta.setText(nomeMenu.getFrutta());
                dolce.setText(nomeMenu.getDolce());
                cliente.setText(intent.getStringExtra(EXTRA_NOME_CLIENTE));
                ospiti.setText(intent.getStringExtra(EXTRA_OSPITI));
                categoria.setText(intent.getStringExtra(EXTRA_TIPO_FESTA));
                data.setText(intent.getStringExtra(EXTRA_DATAEVENTO));
            }
        });


        setTitle("Informazioni prenotazione:");












    }
}
