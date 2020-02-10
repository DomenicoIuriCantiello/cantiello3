package com.example.cantiello3;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "menù")
public class Menu {


    @PrimaryKey(autoGenerate = true)
    protected int id;
    @ColumnInfo(name ="nome")
    protected String nome;
    @ColumnInfo(name ="antipasto")
    protected String antipasto;
    @ColumnInfo (name ="primoPiatto")
    protected String primoPiatto ;
    @ColumnInfo (name ="secondoPiatto")
    protected String secondoPiatto;
    @ColumnInfo (name ="frutta")
    protected String frutta;
    @ColumnInfo (name = "dolce")
    protected String dolce;

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getAntipasto() {
        return antipasto;
    }

    public String getPrimoPiatto() {
        return primoPiatto;
    }

    public String getSecondoPiatto() {
        return secondoPiatto;
    }

    public String getFrutta() {
        return frutta;
    }

    public String getDolce() {
        return dolce;
    }

    public Menu(String nome, String antipasto, String primoPiatto, String secondoPiatto, String frutta, String dolce) {
        this.nome = nome;
        this.antipasto = antipasto;
        this.primoPiatto = primoPiatto;
        this.secondoPiatto = secondoPiatto;
        this.frutta = frutta;
        this.dolce = dolce;
    }
}
