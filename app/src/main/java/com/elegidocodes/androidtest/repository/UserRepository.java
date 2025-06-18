package com.elegidocodes.androidtest.repository;

import android.content.Context;

import com.elegidocodes.androidtest.model.LoginResponseData;
import com.elegidocodes.androidtest.model.ServerResponse;
import com.elegidocodes.androidtest.app.MyAPI;
import com.elegidocodes.androidtest.app.MyRetrofit;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

import retrofit2.Call;
import retrofit2.Response;

public class UserRepository {

    final private Context context;
    final private MyAPI myAPI = MyRetrofit.getService();

    public UserRepository(Context context) {
        this.context = context;
    }

    public CompletableFuture<ServerResponse<LoginResponseData>> login(JsonObject jsonObject) {
        return CompletableFuture.supplyAsync(() -> {

            Call<ServerResponse<LoginResponseData>> call = myAPI.login(jsonObject);
            try {
                Response<ServerResponse<LoginResponseData>> response = call.execute();
                return response.body();
            } catch (IOException e) {
                throw new CompletionException(e);
            }

        });

    }

}
