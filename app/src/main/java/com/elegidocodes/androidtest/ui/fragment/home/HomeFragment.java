package com.elegidocodes.androidtest.ui.fragment.home;

import static com.elegidocodes.androidtest.utility.SharedPreferencesUtil.get;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.elegidocodes.androidtest.R;
import com.elegidocodes.androidtest.databinding.FragmentHomeBinding;
import com.elegidocodes.androidtest.model.Token;
import com.elegidocodes.androidtest.model.User;
import com.google.android.material.card.MaterialCardView;

public class HomeFragment extends Fragment {

    private final static String TAG = "HOME_FRAGMENT";
    private FragmentHomeBinding binding;

    private Context context;

    private NavController navController;

    private User user;
    private Token token;

    private MaterialCardView cardBlog;
    private MaterialCardView cardLibrary;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        context = requireContext();

        cardBlog = binding.cardBlog;
        cardLibrary = binding.cardLibrary;

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        user = get(context, "MyPrefs", "user", User.class);
        token = get(context, "MyPrefs", "token", Token.class);

        if (user != null) {
            Log.d(TAG, "Loading data for user: " + user.getName());
            Log.d(TAG, "Token: " + token.getAccessToken());
        }

        cardBlog.setOnClickListener(v -> {
        });

        cardLibrary.setOnClickListener(v -> navController.navigate(R.id.libraryFragment));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}