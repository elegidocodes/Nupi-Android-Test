package com.elegidocodes.androidtest.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.elegidocodes.androidtest.R;
import com.elegidocodes.androidtest.databinding.ItemWallBinding;
import com.elegidocodes.androidtest.model.BlogResponseDatum;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class WallItemAdapter extends RecyclerView.Adapter<WallItemAdapter.ViewHolder> {

    private final Context context;
    private final List<BlogResponseDatum> blogs;
    private final List<BlogResponseDatum> blogsFiltered;

    public WallItemAdapter(Context context, List<BlogResponseDatum> blogs) {
        this.context = context;
        this.blogs = new ArrayList<>(blogs);
        this.blogsFiltered = new ArrayList<>(blogs);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemWallBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_wall, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BlogResponseDatum libraryItem = blogsFiltered.get(position);
        holder.bind(libraryItem);
    }

    @Override
    public int getItemCount() {
        return blogsFiltered.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void filter(String query) {
        blogsFiltered.clear();

        if (query == null || query.trim().isEmpty()) {
            blogsFiltered.addAll(blogs);
        } else {
            String lowerQuery = query.toLowerCase(Locale.ROOT);
            for (BlogResponseDatum blog : blogs) {
                String title = blog.getTitle() != null ? blog.getTitle().toLowerCase(Locale.ROOT) : "";
                String author = blog.getCreatedBy().getName() != null ? blog.getCreatedBy().getName().toLowerCase(Locale.ROOT) : "";

                if (title.contains(lowerQuery) || author.contains(lowerQuery)) {
                    blogsFiltered.add(blog);
                }
            }
        }

        notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void refresh(List<BlogResponseDatum> blogs) {
        this.blogs.clear();
        this.blogs.addAll(blogs);

        this.blogsFiltered.clear();
        this.blogsFiltered.addAll(blogs);

        this.blogs.addAll(blogs);
        this.blogsFiltered.addAll(blogs);

        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final ItemWallBinding binding;
        private Context context;
        private ImageView profilePicture;
        private ImageView imagePreview;

        public ViewHolder(ItemWallBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            this.context = binding.getRoot().getContext();
            this.profilePicture = binding.profilePicture;
            this.imagePreview = binding.imagePreview;
        }

        public void bind(BlogResponseDatum libraryItem) {
            binding.setLibraryItem(libraryItem);

            Glide.with(context)
                    .load(libraryItem.getCreatedBy().getProfilePicture())
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(profilePicture);

            Glide.with(context)
                    .load(libraryItem.getImagePreview())
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(imagePreview);
        }

    }

}
