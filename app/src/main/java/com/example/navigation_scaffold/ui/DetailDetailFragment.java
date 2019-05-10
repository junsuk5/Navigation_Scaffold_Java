package com.example.navigation_scaffold.ui;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigation_scaffold.MainViewModel;
import com.example.navigation_scaffold.R;
import com.example.navigation_scaffold.databinding.ItemItemBinding;
import com.example.navigation_scaffold.repository.local.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DetailDetailFragment extends Fragment {
    private boolean isSwapped = false;
    private MainViewModel mMainViewModel;
    private ItemAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_detail, container, false);

        mMainViewModel = ViewModelProviders.of(requireActivity()).get(MainViewModel.class);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        mAdapter = new ItemAdapter();
        recyclerView.setAdapter(mAdapter);

        ItemTouchHelper touchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN, 0) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView,
                                  @NonNull RecyclerView.ViewHolder viewHolder,
                                  @NonNull RecyclerView.ViewHolder target) {
                Collections.swap(mAdapter.getItems(),
                        viewHolder.getAdapterPosition(),
                        target.getAdapterPosition());

                mAdapter.notifyItemMoved(viewHolder.getAdapterPosition(),
                        target.getAdapterPosition());

                isSwapped = true;

                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            }
        });
        touchHelper.attachToRecyclerView(recyclerView);
        mMainViewModel.getItems().observe(this, mAdapter::setItems);

        return view;
    }

    private static class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
        interface OnClickListener {
            void onItemClicked(Item model);
        }

        private OnClickListener mListener;

        private List<Item> mItems = new ArrayList<>();

        public ItemAdapter() {
        }

        public ItemAdapter(OnClickListener listener) {
            mListener = listener;
        }

        public void setItems(List<Item> items) {
            this.mItems = items;
            notifyDataSetChanged();
        }

        public Item getItem(int position) {
            return mItems.get(position);
        }

        public List<Item> getItems() {
            return mItems;
        }

        @NonNull
        @Override
        public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_item, parent, false);
            final ItemViewHolder viewHolder = new ItemViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        final Item item = mItems.get(viewHolder.getAdapterPosition());
                        mListener.onItemClicked(item);
                    }
                }
            });
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
            Item item = mItems.get(position);
            holder.binding.setItem(item);
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }

        public static class ItemViewHolder extends RecyclerView.ViewHolder {
            ItemItemBinding binding;

            public ItemViewHolder(@NonNull View itemView) {
                super(itemView);
                binding = ItemItemBinding.bind(itemView);
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        if (isSwapped) {
            mMainViewModel.update(mAdapter.getItems());
        }
    }
}
