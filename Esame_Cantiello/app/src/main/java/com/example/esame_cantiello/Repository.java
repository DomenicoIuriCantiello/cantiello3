package com.example.esame_cantiello;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;
public class Repository  {
    private DaoPrenotazione daoPrenotazione;
    private LiveData<List<Prenotazione>> allPrenotazione;
    public Repository(Application application)
    {
        Database_Room db = Database_Room.getInstance(application);
        daoPrenotazione= db.daoPrenotazione();

    }
    public void  insert(Prenotazione prenotazione)
    {
        new InsertPrenotazioneAsyncTask(daoPrenotazione).execute(prenotazione);

    }
    public void  update(Prenotazione prenotazione)
    {
        new UpdatePrenotazioneAsyncTask(daoPrenotazione).execute(prenotazione);
    }
    public void  delete(Prenotazione prenotazione)
    {
        new DeletePrenotazioneAsyncTask(daoPrenotazione).execute(prenotazione);
    }
    public void  deleteAllPrenotazione()
    {
        new DeleteAllPrenotazioneAsyncTask(daoPrenotazione).execute();

    }
    public LiveData<List<Prenotazione>> getAllPrenotazione(){

        return allPrenotazione;
    }


    private static class InsertPrenotazioneAsyncTask extends AsyncTask <Prenotazione, Void, Void>
    {
        private DaoPrenotazione daoPrenotazione;
        private InsertPrenotazioneAsyncTask(DaoPrenotazione daoPrenotazioneao)
        {
            this.daoPrenotazione=daoPrenotazione;
        }
        @Override
        protected Void doInBackground(Prenotazione... prenotazioni) {
            daoPrenotazione.insertPrenotazione(prenotazioni[0]);
            return null;
        }
    }
    private static class UpdatePrenotazioneAsyncTask extends AsyncTask <Prenotazione, Void, Void>
    {
        private DaoPrenotazione daoPrenotazione;
        private UpdatePrenotazioneAsyncTask(DaoPrenotazione daoPrenotazione)
        {
            this.daoPrenotazione=daoPrenotazione;
        }
        @Override
        protected Void doInBackground(Prenotazione... prenotazioni) {
            daoPrenotazione.updatePrenotazione(prenotazioni[0]);
            return null;
        }
    }
    private static class DeletePrenotazioneAsyncTask extends AsyncTask <Prenotazione, Void, Void>
    {
        private DaoPrenotazione daoPrenotazione;
        private DeletePrenotazioneAsyncTask(DaoPrenotazione daoPrenotazione)
        {
            this.daoPrenotazione=daoPrenotazione;
        }
        @Override
        protected Void doInBackground(Prenotazione... prenotazioni) {
            daoPrenotazione.deletePrenotazione(prenotazioni[0]);
            return null;
        }
    }
    private static class DeleteAllPrenotazioneAsyncTask extends AsyncTask <Void, Void, Void>
    {
        private DaoPrenotazione daoPrenotazione;
        private DeleteAllPrenotazioneAsyncTask(DaoPrenotazione daoPrenotazione)
        {
            this.daoPrenotazione=daoPrenotazione;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            daoPrenotazione.deleteAllPrenotazione();
            return null;
        }
    }


}

