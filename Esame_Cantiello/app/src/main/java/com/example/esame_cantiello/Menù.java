package com.example.esame_cantiello;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

    @Entity(tableName = "menù")
    public class Menù {
        @PrimaryKey(autoGenerate = true)
        private int id;
        @ColumnInfo(name ="antipasto")
        private String antipasto;
        @ColumnInfo (name ="primoPiatto")
        private String primoPiatto ;
        @ColumnInfo (name ="secondoPiatto")
        private String secondoPiatto;
        @ColumnInfo (name ="frutta")
        private String frutta;
        @ColumnInfo (name = "dolce")
        private String dolce;
        @ColumnInfo(name ="nome")
        private String nome;


        public Menù( String antipasto, String primoPiatto, String secondoPiatto, String frutta, String dolce,String nome) {

            this.antipasto = antipasto;
            this.primoPiatto = primoPiatto;
            this.secondoPiatto = secondoPiatto;
            this.frutta = frutta;
            this.dolce = dolce;
            this.nome=nome;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAntipasto() {
            return antipasto;
        }

        public void setAntipasto(String antipasto) {
            this.antipasto = antipasto;
        }

        public String getPrimoPiatto() {
            return primoPiatto;
        }

        public void setPrimoPiatto(String primoPiatto) {
            this.primoPiatto = primoPiatto;
        }

        public String getSecondoPiatto() {
            return secondoPiatto;
        }

        public void setSecondoPiatto(String secondoPiatto) {
            this.secondoPiatto = secondoPiatto;
        }

        public String getFrutta() {
            return frutta;
        }

        public void setFrutta(String frutta) {
            this.frutta = frutta;
        }

        public String getDolce() {
            return dolce;
        }

        public void setDolce(String dolce) {
            this.dolce = dolce;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
    }
