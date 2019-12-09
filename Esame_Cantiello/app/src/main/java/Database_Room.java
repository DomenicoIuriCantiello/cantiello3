import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;
import android.icu.util.Currency;
import java.math.BigDecimal;

import java.util.Date;
import android.content.*;
import android.os.AsyncTask;

import com.example.esame_cantiello.MainActivity;


@Database(entities = {Prenotazione.class},version = 1)
public abstract class Database_Room extends RoomDatabase {
    private static final String DB_NAME = "my_db";
    private static Database_Room instance;
    public abstract DaoPrenotazione daoPrenotazionea();

    public static synchronized Database_Room getInstance (Context context) {
        if (instance == null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext(),Database_Room.class,DB_NAME)
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();

        }
        return instance;

    }

    private static RoomDatabase.Callback roomCallback = new Database_Room().Callback()


    {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();

        }
    };


    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void> {
        private DaoPrenotazione daoPrenotazione;
        private PopulateDbAsyncTask(Database_Room db )
        {
            daoPrenotazione=db.daoPrenotazionea();
        }
        @Override
        protected Void doInBackground(Void... voids) {

            return null;
        }
    }


}

