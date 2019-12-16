package com.example.esame_cantiello;

import android.content.Context;
import android.content.Intent;

import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.esame_cantiello.DettaglioDeiMenu.EXTRA_Antipasto;
import static com.example.esame_cantiello.DettaglioDeiMenu.EXTRA_Dolce;
import static com.example.esame_cantiello.DettaglioDeiMenu.EXTRA_Frutta;
import static com.example.esame_cantiello.DettaglioDeiMenu.EXTRA_Primo;
import static com.example.esame_cantiello.DettaglioDeiMenu.EXTRA_Secondo;

public class ListaMenu extends AppCompatActivity {
    private MenuView menuView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aggiungi_menu);
        RecyclerView recyclerView = findViewById(R.id.recyler_menu);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final AdapterMenù adapter = new AdapterMenù();
        adapter.setContext(this);
        recyclerView.setAdapter(adapter);
       /* menuView = ViewModelProviders.of(this).get(MenuView.class);
        menuView.getAllMenu().observe(this, new Observer<List<Menù>>() {

            @Override
            public void onChanged(@Nullable List<Menù> menues) {
                adapter.setLista_menu(menues);

            }
        });*/




        adapter.setOnItemClickListener(new AdapterMenù.Toccosingolo() {

            @Override
            public void onItemClick(Menù menù) {
                Intent intent = new Intent (ListaMenu.this,DettaglioDeiMenu.class);
                intent.putExtra(EXTRA_Antipasto,menù.getAntipasto());
                intent.putExtra(EXTRA_Primo,menù.getPrimoPiatto());
                intent.putExtra(EXTRA_Secondo,menù.getSecondoPiatto());
                intent.putExtra(EXTRA_Frutta,menù.getFrutta());
                intent.putExtra(EXTRA_Dolce,menù.getDolce());
                startActivity(intent);

            }

        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }



}


