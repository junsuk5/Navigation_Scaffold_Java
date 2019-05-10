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
import com.example.navigation_scaffold.repository.local.AppDatabase;
import com.example.navigation_scaffold.repository.local.Item;

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
        switch (item.getItemId()) {
            case R.id.action_add_data:
                AppDatabase.getInstance(requireContext()).itemDao().insertItems(
                        new Item("아이템 1", 1),
                        new Item("아이템 2", 2),
                        new Item("아이템 3", 3),
                        new Item("아이템 4", 4),
                        new Item("아이템 5", 5),
                        new Item("아이템 6", 6)
                );
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
