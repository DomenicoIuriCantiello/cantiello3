package com.example.cantiello3;


import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface DaoPrenotazione {

    @Insert
    void insertPrenotazione( Prenotazione prenotazione);//inserisce una prenotazione
    @Update
    void updatePrenotazione(Prenotazione prenotazione );//modifica una prenotazione
    @Delete
    void deletePrenotazione(Prenotazione prenotazione);//elimina una prenotazione

    @Query("DELETE FROM prenotazione")
    void deleteAllPrenotazione();

    @Query("SELECT * FROM prenotazione")
    LiveData<List<Prenotazione>> getAllPrenotazione();

}
