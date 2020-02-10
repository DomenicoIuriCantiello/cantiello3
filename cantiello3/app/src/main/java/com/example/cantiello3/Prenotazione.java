package com.example.cantiello3;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "prenotazione")
public class Prenotazione {


    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name="nomecliente")
    private String nomecliente;
    @ColumnInfo(name="dataevento")
    private String dataevento;
    @ColumnInfo(name="tipo_di_festa")
    private String tipo_di_festa;
    @ColumnInfo(name="tipo_di_menu")
    private String tipo_di_menu;
    @ColumnInfo(name="ospiti")
    private String ospiti;

    public String getNomecliente() {
        return nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }

    public String getDataevento() {
        return dataevento;
    }

    public void setDataevento(String dataevento) {
        this.dataevento = dataevento;
    }

    public String getTipo_di_festa() {
        return tipo_di_festa;
    }

    public void setTipo_di_festa(String tipo_di_festa) {
        this.tipo_di_festa = tipo_di_festa;
    }

    public String getTipo_di_menu() {
        return tipo_di_menu;
    }

    public void setTipo_di_menu(String tipo_di_menu) {
        this.tipo_di_menu = tipo_di_menu;
    }

    public String getOspiti() {
        return ospiti;
    }

    public void setOspiti(String ospiti) {
        this.ospiti = ospiti;
    }

    public Prenotazione(String nomecliente, String dataevento, String tipo_di_festa, String tipo_di_menu, String ospiti) {
        this.nomecliente = nomecliente;
        this.dataevento = dataevento;
        this.tipo_di_festa = tipo_di_festa;
        this.tipo_di_menu = tipo_di_menu;
        this.ospiti = ospiti;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
