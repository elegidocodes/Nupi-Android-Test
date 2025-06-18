package com.elegidocodes.androidtest.ui.fragment.user;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.elegidocodes.androidtest.model.ServerResponse;
import com.elegidocodes.androidtest.repository.UserRepository;

import java.util.concurrent.CompletableFuture;

public class UserProfileViewModel extends AndroidViewModel {

    private final UserRepository userRepository;

    public UserProfileViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
    }

    public CompletableFuture<ServerResponse<String>> updateProfile(String firstName, String lastName, String email, String authToken) {
        return userRepository.updateProfile(firstName, lastName, email, authToken);
    }

}