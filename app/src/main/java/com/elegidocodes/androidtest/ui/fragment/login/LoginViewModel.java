package com.elegidocodes.androidtest.ui.fragment.login;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.elegidocodes.androidtest.model.LoginResponseData;
import com.elegidocodes.androidtest.model.ServerResponse;
import com.elegidocodes.androidtest.repository.UserRepository;
import com.google.gson.JsonObject;

import java.util.concurrent.CompletableFuture;

public class LoginViewModel extends AndroidViewModel {

    private final UserRepository userRepository;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        this.userRepository = new UserRepository(application);
    }

    CompletableFuture<ServerResponse<LoginResponseData>> login(JsonObject jsonObject) {
        return userRepository.login(jsonObject);
    }

}