import android.provider.ContactsContract;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import static androidx.room.OnConflictStrategy.REPLACE;



    @Dao
    public interface DaoPrenotazione {
        @Insert
        void insertPrenotazione( Prenotazione prenotazione);//inserisce una prenotazione
        @Update
        void updatePrenotazione(Prenotazione prenotazione );//modifica una prenotazione
        @Delete
        void  delatePrenotazione(Prenotazione prenotazione);//elimina una prenotazione

        //  MI SERVIRANNO LE QUERY


    }
