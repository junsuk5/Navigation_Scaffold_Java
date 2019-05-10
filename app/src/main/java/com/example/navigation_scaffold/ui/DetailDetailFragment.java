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
public class DetailDetailFragment extends Fragment {


    public DetailDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_detail, container, false);
    }

}
