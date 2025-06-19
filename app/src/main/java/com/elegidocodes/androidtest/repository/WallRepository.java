package com.elegidocodes.androidtest.repository;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.elegidocodes.androidtest.app.MyAPI;
import com.elegidocodes.androidtest.app.MyRetrofit;
import com.elegidocodes.androidtest.model.BlogItemResponseData;
import com.elegidocodes.androidtest.model.BlogResponseData;
import com.elegidocodes.androidtest.model.ServerResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WallRepository {

    private final static String TAG = "WALL_REPOSITORY";

    private final Context context;
    private final MutableLiveData<ServerResponse<BlogResponseData>> mBlogResponseData = new MutableLiveData<>();
    private final MutableLiveData<ServerResponse<List<BlogItemResponseData>>> mBlogItemResponseData = new MutableLiveData<>();

    public WallRepository(Context context) {
        this.context = context;
    }

    public void getWall(String authToken) {

        MyRetrofit.setAuthToken(authToken);
        MyAPI myAPI = MyRetrofit.getService();

        Call<ServerResponse<BlogResponseData>> call = myAPI.getWall();

        call.enqueue(new Callback<>() {

            @Override
            public void onResponse(@NonNull Call<ServerResponse<BlogResponseData>> call,
                                   @NonNull Response<ServerResponse<BlogResponseData>> response) {

                if (response.isSuccessful() && response.body() != null) {
                    mBlogResponseData.setValue(response.body());
                } else {
                    Log.e(TAG, response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<ServerResponse<BlogResponseData>> call,
                                  @NonNull Throwable throwable) {
                Log.e(TAG, throwable.getMessage(), throwable);
            }
        });

    }

    public void getWallInfo(int wallId, String authToken) {

        MyRetrofit.setAuthToken(authToken);
        MyAPI myAPI = MyRetrofit.getService();

        Call<ServerResponse<List<BlogItemResponseData>>> call = myAPI.getWallInfo(wallId);

        call.enqueue(new Callback<>() {

            @Override
            public void onResponse(@NonNull Call<ServerResponse<List<BlogItemResponseData>>> call,
                                   @NonNull Response<ServerResponse<List<BlogItemResponseData>>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    mBlogItemResponseData.setValue(response.body());
                } else {
                    Log.e(TAG, response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<ServerResponse<List<BlogItemResponseData>>> call,
                                  @NonNull Throwable throwable) {
                Log.e(TAG, throwable.getMessage(), throwable);
            }
        });

    }

    public MutableLiveData<ServerResponse<BlogResponseData>> getBlogResponseData() {
        return mBlogResponseData;
    }

    public MutableLiveData<ServerResponse<List<BlogItemResponseData>>> getBlogItemResponseData() {
        return mBlogItemResponseData;
    }

}
