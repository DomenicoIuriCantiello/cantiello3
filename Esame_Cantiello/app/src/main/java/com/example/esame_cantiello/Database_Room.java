package com.example.esame_cantiello;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.content.*;
import android.os.AsyncTask;


@Database(entities = {Prenotazione.class,Menù.class},version = 1)
public abstract class Database_Room extends RoomDatabase {
    private static final String DB_NAME = "my_db";
    private static Database_Room instance;
    public abstract DaoPrenotazione daoPrenotazione();
    public abstract DaoMenù daoMenù();

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

    private static RoomDatabase.Callback roomCallback = new Database_Room.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();

        }
    };



    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void> {
        private DaoPrenotazione daoPrenotazione;
        private DaoMenù daoMenù;
        private PopulateDbAsyncTask(Database_Room db )
        {
            daoPrenotazione=db.daoPrenotazione();
            daoMenù=db.daoMenù();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            daoMenù.insertMenù(new Menù("salumi e formaggi","gnocchi alla sorrentina","bauletto maialino casertano ","macedonia", "piccola pasticcieria","TERRA"));
            daoMenù.insertMenù(new Menù("insalata di mare","risotto alla pescatora ","orata al cartoccio ","macedonia", "piccola pasticcieria","PESCE"));
            daoMenù.insertMenù(new Menù("misto frittura","scarpariello","orata al cartoccio ","macedonia", "piccola pasticcieria","BUFFET"));
           daoPrenotazione.insertPrenotazione(new Prenotazione("Di Guida","pesce","15/10/2109","dj"));
            return null;
        }
    }


}

