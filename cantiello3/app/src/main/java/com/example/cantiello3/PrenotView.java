package com.example.cantiello3;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class PrenotView extends AndroidViewModel {

    private PrenotazioneRepository repository;
    private LiveData<List<Prenotazione>> allPrenotazione;

    public PrenotView(@NonNull Application application) {
        super(application);
        repository= new PrenotazioneRepository(application);
        allPrenotazione=repository.getAllPrenotazione();
    }
    public void insert(Prenotazione prenotazione)
    {
        repository.insert(prenotazione);
    }
    public void update(Prenotazione prenotazione)
    {
        repository.update(prenotazione);
    }
    public void delete(Prenotazione prenotazione)
    {
        repository.delete(prenotazione);
    }
    public void deleteAllPrenotazione()
    {
        repository.deleteAllPrennotazione();
    }
    public LiveData<List<Prenotazione>>getAllPrenotazione()
    {
        return allPrenotazione;
    }
}
