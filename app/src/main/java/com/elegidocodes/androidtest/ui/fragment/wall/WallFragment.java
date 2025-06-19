package com.elegidocodes.androidtest.ui.fragment.wall;

import static com.elegidocodes.androidtest.utility.SharedPreferencesUtil.get;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.elegidocodes.androidtest.R;
import com.elegidocodes.androidtest.adapter.WallItemAdapter;
import com.elegidocodes.androidtest.databinding.FragmentWallBinding;
import com.elegidocodes.androidtest.model.BlogResponseDatum;
import com.elegidocodes.androidtest.model.Token;
import com.elegidocodes.androidtest.model.User;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class WallFragment extends Fragment {

    private static final String TAG = "WALL_FRAGMENT";

    private final List<BlogResponseDatum> blogs = new ArrayList<>();

    private FragmentWallBinding binding;
    private WallViewModel viewModel;
    private Context context;
    private RecyclerView recyclerView;
    private WallItemAdapter wallItemAdapter;
    private TextInputLayout wallTextInputLayout;
    private TextInputEditText wallInputEditText;
    private User user;
    private Token token;

    public static WallFragment newInstance() {
        return new WallFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_wall, container, false);
        viewModel = new ViewModelProvider(this).get(WallViewModel.class);

        context = requireContext();

        wallTextInputLayout = binding.wallTextInputLayout;
        wallInputEditText = binding.wallInputEditText;

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        user = get(context, "MyPrefs", "user", User.class);
        token = get(context, "MyPrefs", "token", Token.class);

        if (user == null || token == null) {
            Log.d(TAG, "User or token is null");
            wallInputEditText.setEnabled(false);
        }

        recyclerView = binding.recyclerView;

        wallItemAdapter = new WallItemAdapter(context, new ArrayList<>());
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(wallItemAdapter);

        viewModel.getWall(token.getAccessToken());

        viewModel.getWallResponseData().observe(getViewLifecycleOwner(), serverResponse -> {
            if (serverResponse.getData() != null && serverResponse.getData().getData() != null) {

                blogs.addAll(serverResponse.getData().getData());
                wallItemAdapter.refresh(blogs);
            }
        });

        wallInputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (s != null) {
                    String searchQuery = s.toString();
                    if (!searchQuery.isEmpty()) {
                        wallItemAdapter.filter(searchQuery);
                    } else {
                        wallItemAdapter.refresh(new ArrayList<>());
                    }
                }

            }
        });


    }

}