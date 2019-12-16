package com.example.esame_cantiello;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Currency;
import android.icu.util.Currency.CurrencyUsage;
import java.util.Date;

@Entity(tableName = "prenotazione")
public class Prenotazione {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo (name ="nome")
    private String nome;
    @ColumnInfo (name ="tipo_menu")
    private String tipo_menu;
    @ColumnInfo (name ="data")
    private String data;
    @ColumnInfo(name="ospiti")
    private String ospiti;

    public Prenotazione (String nome,String tipo_menu,String data,String ospiti)
    {

        this.nome=nome;
        this.tipo_menu=tipo_menu;
        this.data=data;
        this.ospiti=ospiti;
    }


    public String getNome() {
        return nome;
    }

    public String getTipo_menu() {
        return tipo_menu;
    }

    public void setTipo_menu(String tipo_menu) {
        this.tipo_menu = tipo_menu;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOspiti() {
        return ospiti;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOspiti(String ospiti) {
        this.ospiti = ospiti;
    }
}

