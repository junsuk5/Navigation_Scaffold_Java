package com.example.navigation_scaffold.ui;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.navigation_scaffold.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Item01Fragment extends Fragment {


    public Item01Fragment() {
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item01, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.text_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation
                        .findNavController(requireActivity(),
                                R.id.nav_host_fragment);

                Bundle bundle = new Bundle();
                bundle.putString("name", "오준석");
                navController.navigate(R.id.action_bottomNavFragment_to_detailFragment, bundle);

            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.item01, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO : 메뉴 처리
        return super.onOptionsItemSelected(item);
    }
}
