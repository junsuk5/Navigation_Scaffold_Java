package com.example.navigation_scaffold.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DetailViewModel extends ViewModel {
    MutableLiveData<Integer> counter = new MutableLiveData<>();

    public DetailViewModel() {
        counter.setValue(0);
    }

    public void addCounter() {
        counter.setValue(counter.getValue() + 1);
    }
}
