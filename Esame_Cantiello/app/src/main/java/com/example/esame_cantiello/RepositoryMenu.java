package com.example.esame_cantiello;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class RepositoryMenu {
    private DaoMenù daoMenù;
    private LiveData<List<Menù>> allMenu;
    public RepositoryMenu(Application application)
    {
        Database_Room db = Database_Room.getInstance(application);
        daoMenù= db.daoMenù();

    }
    public void  insert(Menù menù)
    {
        new RepositoryMenu.InsertMenuAsyncTask(daoMenù).execute(menù);

    }
    public void  update(Menù menù)
    {
        new RepositoryMenu.UpdateMenuAsyncTask(daoMenù).execute(menù);
    }
    public void  delete(Menù menù)
        {
        new RepositoryMenu.DeleteMenuAsyncTask(daoMenù).execute(menù);
    }
    public void  deleteAllPrenotazione()
    {
        new RepositoryMenu.DeleteAllMenuAsyncTask(daoMenù).execute();

    }
    public LiveData<List<Menù>> getAllMenu(){

        return allMenu;
    }


    private static class InsertMenuAsyncTask extends AsyncTask<Menù, Void, Void>
    {
        private DaoMenù daoMenù;
        private InsertMenuAsyncTask(DaoMenù daoMenu)
        {
            this.daoMenù=daoMenu;
        }
        @Override
        protected Void doInBackground(Menù... menues) {
            daoMenù.insertMenù(menues[0]);
            return null;
        }
    }
    private static class UpdateMenuAsyncTask extends AsyncTask <Menù, Void, Void>
    {
        private DaoMenù daoMenù;
        private UpdateMenuAsyncTask(DaoMenù daoMenu)
        {
            this.daoMenù=daoMenù;
        }
        @Override
        protected Void doInBackground(Menù... menues) {
            daoMenù.updateMenù(menues[0]);
            return null;
        }
    }
    private static class DeleteMenuAsyncTask extends AsyncTask <Menù, Void, Void>
    {
        private DaoMenù daoMenù;
        private DeleteMenuAsyncTask(DaoMenù daoMenu)
        {
            this.daoMenù=daoMenu;
    }
        @Override
        protected Void doInBackground(Menù... menues) {
            daoMenù.deleteMenù(menues[0]);
            return null;
        }
    }
    private static class DeleteAllMenuAsyncTask extends AsyncTask <Void, Void, Void>
    {
        private DaoMenù daoMenù;
        private DeleteAllMenuAsyncTask(DaoMenù daoMenù)
        {
            this.daoMenù=daoMenù;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            daoMenù.deleteAllMenù();
            return null;
        }
    }

}
