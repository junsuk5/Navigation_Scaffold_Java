package com.example.navigation_scaffold.ui;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.navigation_scaffold.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Item03Fragment extends Fragment {


    public Item03Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item03, container, false);
    }

}
