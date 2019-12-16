package com.example.esame_cantiello;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;



    @Dao
    public interface DaoMenù {
        @Insert
        void insertMenù( Menù menù);//inserisce un muenù
        @Update
        void updateMenù(Menù menù);//modifica menù
        @Delete
        void  deleteMenù(Menù menù);//elimina menù
        @Query("DELETE FROM menù")
        void deleteAllMenù();
        @Query("SELECT * FROM menù")
        LiveData<List<Menù>> getAllMenù();

    }
