package com.example.cantiello3;


import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface DaoMenu {

    @Insert
    void insertMenu( Menu menu);
    @Update
    void updateMenu(Menu menu );
    @Delete
    void deleteMenu(Menu menu);


    @Query("DELETE FROM menù")
    void deleteAllMenu();

    @Query("SELECT * FROM menù")
    LiveData<List<Menu>> getAllMenu();

    @Query("SELECT * FROM menù WHERE nome= :nome")
     Menu getMenu(String nome);
}
