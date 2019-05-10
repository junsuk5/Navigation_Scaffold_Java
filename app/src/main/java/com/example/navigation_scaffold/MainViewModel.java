package com.example.navigation_scaffold;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.navigation_scaffold.repository.local.AppDatabase;
import com.example.navigation_scaffold.repository.local.Item;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private AppDatabase db;

    public MainViewModel(@NonNull Application application) {
        super(application);
        db = AppDatabase.getInstance(application);
    }

    public LiveData<List<Item>> getItems() {
        return db.itemDao().getAll();
    }

    public void update(List<Item> items) {
        for (int i = 0; i < items.size(); i++) {
            items.get(i).setOrder(i);
        }
        db.itemDao().deleteAll();
        db.itemDao().insertItems(items);
    }
}
