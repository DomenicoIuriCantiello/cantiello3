package com.example.cantiello3;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class MenuRepository {

    private DaoMenu menuDao;
    private LiveData<List<Menu>> allMenu;
    public MenuRepository(Application application)
    {
        DatabasePrenotazione database = DatabasePrenotazione.getInstance(application);
        menuDao=database.daoMenu();
        allMenu=menuDao.getAllMenu();
    }
    public  void insert(Menu menu)
    {
        new MenuRepository.InsertMenuAsyncTask(menuDao).execute(menu);

    }

    public void update( Menu menu)
    {
        new MenuRepository.UpdateMenuAsyncTask(menuDao).execute(menu);
    }

    public void delete(Menu menu)
    {
        new MenuRepository.DeleteMenuAsyncTask(menuDao).execute(menu);
    }
    public  void deleteAllMenu()
    {
        new MenuRepository.DeleteAllMenuAsyncTask(menuDao).execute();
    }


    public LiveData<List<Menu>> getAllMenu()
    {
        return allMenu;
    }

    private static class InsertMenuAsyncTask extends AsyncTask<Menu,Void,Void>
    {
        private DaoMenu menuDao;

        private InsertMenuAsyncTask(DaoMenu menuDao)
        {
            this.menuDao=menuDao;
        }

        @Override
        protected Void doInBackground(Menu... menus) {
            menuDao.insertMenu(menus[0]);
            return null;
        }
    }

    private static class UpdateMenuAsyncTask extends AsyncTask<Menu,Void,Void>
    {
        private DaoMenu menuDao;

        private UpdateMenuAsyncTask(DaoMenu menuDao)
        {
            this.menuDao=menuDao;
        }

        @Override
        protected Void doInBackground(Menu... menus) {
            menuDao.updateMenu(menus[0]);
            return null;
        }
    }
    private static class DeleteMenuAsyncTask extends AsyncTask<Menu,Void,Void>
    {
        private DaoMenu menuDao;

        private DeleteMenuAsyncTask(DaoMenu menuDao)
        {
            this.menuDao=menuDao;
        }

        @Override
        protected Void doInBackground(Menu... menus) {
            menuDao.deleteMenu(menus[0]);
            return null;
        }
    }

    private static class DeleteAllMenuAsyncTask extends AsyncTask<Void,Void,Void>
    {
        private DaoMenu menuDao;

        private DeleteAllMenuAsyncTask(DaoMenu menuDao)
        {
            this.menuDao=menuDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            menuDao.deleteAllMenu();
            return null;
        }
    }


}
