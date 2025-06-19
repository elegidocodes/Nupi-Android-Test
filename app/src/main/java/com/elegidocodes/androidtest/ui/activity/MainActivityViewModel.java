package com.elegidocodes.androidtest.ui.activity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.elegidocodes.androidtest.model.ServerResponse;
import com.elegidocodes.androidtest.repository.UserRepository;

import java.util.concurrent.CompletableFuture;

public class MainActivityViewModel extends AndroidViewModel {

    private static final String TAG = "MAIN_ACTIVITY_VIEW_MODEL";

    private final UserRepository userRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
    }

    public CompletableFuture<ServerResponse<String>> logout(String authToken) {
        return userRepository.logout(authToken);
    }

}
