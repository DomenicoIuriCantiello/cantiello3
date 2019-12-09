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
    @ColumnInfo (name ="prezzo")
    private String prezzo ;
    @ColumnInfo (name ="categoria")
    private String categoria;
    @ColumnInfo (name ="data")
    private String data;
    @ColumnInfo (name = "posti_a_sedere")
    private String posti_a_sedere;
    @ColumnInfo(name="ospiti")
    private String ospiti;

    public Prenotazione (int id,String nome,String prezzo,String categoria,String data,String posti_a_sedere,String ospiti)
    {
        this.id=id;
        this.nome=nome;
        this.prezzo=prezzo;
        this.categoria=categoria;
        this.data=data;
        this.posti_a_sedere=posti_a_sedere;
        this.ospiti=ospiti;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(String prezzo) {
        this.prezzo = prezzo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPosti_a_sedere() {
        return posti_a_sedere;
    }

    public void setPosti_a_sedere(String posti_a_sedere) {
        this.posti_a_sedere = posti_a_sedere;
    }

    public String getOspiti() {
        return ospiti;
    }

    public void setOspiti(String ospiti) {
        this.ospiti = ospiti;
    }
}
