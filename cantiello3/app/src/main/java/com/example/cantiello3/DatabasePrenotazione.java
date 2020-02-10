package com.example.cantiello3;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


@Database(entities = {Prenotazione.class,Menu.class},version =  1)
public abstract class DatabasePrenotazione extends RoomDatabase {

    private static DatabasePrenotazione instance;

    public abstract DaoPrenotazione daoPrenotazione();
    public abstract DaoMenu daoMenu();

    public static synchronized DatabasePrenotazione getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), DatabasePrenotazione.class, "databasePrenotazione")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback =new RoomDatabase.Callback()
    {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>
    {
        private DaoPrenotazione daoPrenotazione;
        private DaoMenu daoMenu;
        private PopulateDbAsyncTask(DatabasePrenotazione db)
        {
            daoPrenotazione=db.daoPrenotazione();
            daoMenu=db.daoMenu();

        }
        @Override //questo potrebbe essere un database gia popolato
        protected Void doInBackground(Void... voids) {
            daoPrenotazione.insertPrenotazione(new Prenotazione("iuri","20/02/21","compleanno","Pesce","dj"));
            daoMenu.insertMenu(new Menu("Carne","prosciutto e mozzarella","gnocchi alla sorrentina","bauletto di manzo","macedonia","piccola pasticcieria"));
            daoMenu.insertMenu(new Menu("Pesce","trilogia di mare ","risotto alla pescatora","orata in cartoccio","macedonia","piccola pasticcieria"));
            daoMenu.insertMenu(new Menu("Buffet","finger food","assaggi di genovese e  gnocchi","misto salumi e formaggio","macedonia","piccola pasticcieria"));


            return null;
        }
    }
}
