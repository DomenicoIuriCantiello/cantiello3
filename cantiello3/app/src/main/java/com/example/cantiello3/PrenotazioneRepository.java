package com.example.cantiello3;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Update;

public class PrenotazioneRepository {
    private DaoPrenotazione prenotazioneDao;
    private LiveData<List<Prenotazione>> allPrenotazione;

    public PrenotazioneRepository(Application application)
    {
        DatabasePrenotazione database = DatabasePrenotazione.getInstance(application);
        prenotazioneDao=database.daoPrenotazione();
        allPrenotazione=prenotazioneDao.getAllPrenotazione();
    }

    public  void insert(Prenotazione prenotazione)
    {
        new InsertPrenotazioneAsyncTask(prenotazioneDao).execute(prenotazione);

    }

    public void update(Prenotazione prenotazione)
    {
        new UpdatePrenotazioneAsyncTask(prenotazioneDao).execute(prenotazione);
    }

    public void delete(Prenotazione prenotazione)
    {
        new DeletePrenotazioneAsyncTask(prenotazioneDao).execute(prenotazione);
    }
    public  void deleteAllPrennotazione()
    {
        new DeleteAllPrenotazioneAsyncTask(prenotazioneDao).execute();
    }

    public LiveData<List<Prenotazione>> getAllPrenotazione()
    {
        return allPrenotazione;
    }

    private static class InsertPrenotazioneAsyncTask extends AsyncTask<Prenotazione,Void,Void>
    {
        private DaoPrenotazione prenotazioneDao;

        private InsertPrenotazioneAsyncTask(DaoPrenotazione prenotazioneDao)
        {
            this.prenotazioneDao=prenotazioneDao;
        }
        @Override
        protected Void doInBackground(Prenotazione... prenotaziones) {
            prenotazioneDao.insertPrenotazione(prenotaziones[0]);
            return null;
        }

    }

    private static class UpdatePrenotazioneAsyncTask extends AsyncTask<Prenotazione,Void,Void>
    {
        private DaoPrenotazione prenotazioneDao;

        private UpdatePrenotazioneAsyncTask(DaoPrenotazione prenotazioneDao)
        {
            this.prenotazioneDao=prenotazioneDao;
        }
        @Override
        protected Void doInBackground(Prenotazione... prenotaziones) {
            prenotazioneDao.updatePrenotazione(prenotaziones[0]);
            return null;
        }

    }
    private static class DeletePrenotazioneAsyncTask extends AsyncTask<Prenotazione,Void,Void>
    {
        private DaoPrenotazione prenotazioneDao;

        private DeletePrenotazioneAsyncTask(DaoPrenotazione prenotazioneDao)
        {
            this.prenotazioneDao=prenotazioneDao;
        }
        @Override
        protected Void doInBackground(Prenotazione... prenotaziones) {
            prenotazioneDao.deletePrenotazione(prenotaziones[0]);
            return null;
        }

    }

    private static class DeleteAllPrenotazioneAsyncTask extends AsyncTask<Void,Void,Void>
    {
        private DaoPrenotazione prenotazioneDao;

        private DeleteAllPrenotazioneAsyncTask(DaoPrenotazione prenotazioneDao)
        {
            this.prenotazioneDao=prenotazioneDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            prenotazioneDao.deleteAllPrenotazione();
            return null;
        }

    }

}
