package com.elegidocodes.androidtest.repository;

import android.content.Context;
import android.util.Log;

import com.elegidocodes.androidtest.app.MyAPI;
import com.elegidocodes.androidtest.app.MyRetrofit;
import com.elegidocodes.androidtest.model.LoginResponseData;
import com.elegidocodes.androidtest.model.ServerResponse;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;

public class UserRepository {

    private static final String TAG = "USER_REPOSITORY";
    private final Context context;
    private MyAPI myAPI = MyRetrofit.getService();

    public UserRepository(Context context) {
        this.context = context;
    }

    public CompletableFuture<ServerResponse<LoginResponseData>> login(JsonObject jsonObject) {
        return CompletableFuture.supplyAsync(() -> {

            Call<ServerResponse<LoginResponseData>> call = myAPI.login(jsonObject);
            try {
                Response<ServerResponse<LoginResponseData>> response = call.execute();
                Log.d(TAG, "Response: " + response.body());
                return response.body();
            } catch (IOException e) {
                throw new CompletionException(e);
            }

        });

    }

    public CompletableFuture<ServerResponse<String>> logout(String authToken) {

        Log.d(TAG, "authToken: " + authToken);

        MyRetrofit.setAuthToken(authToken);
        myAPI = MyRetrofit.getService();

        return CompletableFuture.supplyAsync(() -> {

            Call<ServerResponse<String>> call = myAPI.logout();

            try {
                Response<ServerResponse<String>> response = call.execute();
                Log.d(TAG, "Response: " + response.body());
                return response.body();
            } catch (IOException e) {
                throw new CompletionException(e);
            }

        });

    }

    public CompletableFuture<ServerResponse<String>> updateProfile(String firstName, String lastName, String email, String authToken) {

        MyRetrofit.setAuthToken(authToken);
        myAPI = MyRetrofit.getService();

        return CompletableFuture.supplyAsync(() -> {
            RequestBody firstNameBody = RequestBody.create(firstName, MediaType.parse("text/plain"));
            RequestBody lastNameBody = RequestBody.create(lastName, MediaType.parse("text/plain"));
            RequestBody emailBody = RequestBody.create(email, MediaType.parse("text/plain"));

            Call<ServerResponse<String>> call = myAPI.updateProfile(firstNameBody, lastNameBody, emailBody);

            try {
                Response<ServerResponse<String>> response = call.execute();
                Log.d(TAG, "Response: " + response.body());
                return response.body();
            } catch (IOException e) {
                throw new CompletionException(e);
            }
        });
    }

    public CompletableFuture<ServerResponse<String>> updateProfilePicture(File file, String authToken) {
        MyRetrofit.setAuthToken(authToken);
        myAPI = MyRetrofit.getService();

        return CompletableFuture.supplyAsync(() -> {

            RequestBody fileRequestBody = RequestBody.create(file, MediaType.parse("image/*"));
            MultipartBody.Part filePart = MultipartBody.Part.createFormData("image", file.getName(), fileRequestBody);

            Call<ServerResponse<String>> call = myAPI.updateProfilePicture(filePart);

            try {
                Response<ServerResponse<String>> response = call.execute();
                Log.d(TAG, "Response: " + response.body());
                return response.body();
            } catch (IOException e) {
                throw new CompletionException(e);
            }
        });
    }

}
