package com.elegidocodes.androidtest.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.elegidocodes.androidtest.R;
import com.elegidocodes.androidtest.databinding.ItemLibraryBinding;
import com.elegidocodes.androidtest.model.LibraryResponseDatum;
import com.elegidocodes.androidtest.ui.fragment.library.LibraryFragment;

import java.util.ArrayList;
import java.util.List;

public class LibraryItemAdapter extends RecyclerView.Adapter<LibraryItemAdapter.ViewHolder> {

    private final Context context;
    private final List<LibraryResponseDatum> items;
    private final LibraryFragment fragment;

    public LibraryItemAdapter(Context context, List<LibraryResponseDatum> items, LibraryFragment fragment) {
        this.context = context;
        this.items = new ArrayList<>(items);
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ItemLibraryBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_library, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LibraryResponseDatum item = items.get(position);
        holder.binding.setLibraryItem(item);
        holder.bind(item);
        holder.binding.btnOpenLibrary.setOnClickListener(v -> fragment.goToLibraryItemFragment(item.getId()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void refresh(List<LibraryResponseDatum> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final ItemLibraryBinding binding;

        public ViewHolder(ItemLibraryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        private void bind(LibraryResponseDatum item) {
            binding.setLibraryItem(item);
            Glide.with(binding.getRoot().getContext())
                    .load(item.getImagePreview())
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(binding.imageView);

        }

    }

}
