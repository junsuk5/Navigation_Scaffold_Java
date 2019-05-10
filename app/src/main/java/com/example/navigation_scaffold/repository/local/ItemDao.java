package com.example.navigation_scaffold.repository.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ItemDao {
    @Query("SELECT * FROM item ORDER BY `order`")
    LiveData<List<Item>> getAll();

    @Insert
    void insertItems(Item... items);

    @Insert
    void insertItems(List<Item> items);

    @Query("DELETE FROM item")
    void deleteAll();
}
