package com.example.esame_cantiello;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class MenuView extends AndroidViewModel {
    private RepositoryMenu repository;
    private LiveData<List<Menù>> allMenu;
    public MenuView(@NonNull Application application) {
        super(application);
        repository= new RepositoryMenu(application);
        allMenu=repository.getAllMenu();
    }
    public void insertMenu(Menù menù)
    {
        repository.insert(menù);
    }
    public void update(Menù menù)
    {
        repository.update(menù);
    }
    public void delete(Menù menù)
    {
        repository.delete(menù);
    }
    public void deleteAllMenu()
    {
        repository.deleteAllPrenotazione();
    }
    public LiveData<List<Menù>> getAllMenu()
    {
        return allMenu;
    }
}
