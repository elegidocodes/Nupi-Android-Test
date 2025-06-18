package com.elegidocodes.androidtest.repository;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.elegidocodes.androidtest.app.MyAPI;
import com.elegidocodes.androidtest.app.MyRetrofit;
import com.elegidocodes.androidtest.model.LibraryItemResponseData;
import com.elegidocodes.androidtest.model.LibraryResponseData;
import com.elegidocodes.androidtest.model.ServerResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LibraryRepository {

    private final static String TAG = "LIBRARY_REPOSITORY";

    private final Context context;
    private final MutableLiveData<ServerResponse<LibraryResponseData>> mLibraryResponseData = new MutableLiveData<>();
    private final MutableLiveData<ServerResponse<List<LibraryItemResponseData>>> mLibraryItemResponseData = new MutableLiveData<>();


    public LibraryRepository(Context context) {
        this.context = context;
    }

    public void searchInLibrary(String search, String authToken) {

        MyRetrofit.setAuthToken(authToken);
        MyAPI myAPI = MyRetrofit.getService();

        Call<ServerResponse<LibraryResponseData>> call = myAPI.searchInLibrary(search);

        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<ServerResponse<LibraryResponseData>> call,
                                   @NonNull Response<ServerResponse<LibraryResponseData>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    mLibraryResponseData.setValue(response.body());
                } else {
                    Log.e(TAG, response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<ServerResponse<LibraryResponseData>> call,
                                  @NonNull Throwable throwable) {
                Log.e(TAG, throwable.getMessage(), throwable);
            }
        });

    }

    public void getLibraryInfo(int libraryId, String authToken) {
        MyRetrofit.setAuthToken(authToken);
        MyAPI myAPI = MyRetrofit.getService();

        Call<ServerResponse<List<LibraryItemResponseData>>> call = myAPI.getLibraryInfo(libraryId);
        Log.d(TAG, call.request().url().toString());

        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<ServerResponse<List<LibraryItemResponseData>>> call,
                                   @NonNull Response<ServerResponse<List<LibraryItemResponseData>>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    mLibraryItemResponseData.setValue(response.body());
                } else {
                    Log.e(TAG, response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<ServerResponse<List<LibraryItemResponseData>>> call,
                                  @NonNull Throwable throwable) {
                Log.e(TAG, throwable.getMessage(), throwable);
            }
        });

    }

    public MutableLiveData<ServerResponse<LibraryResponseData>> getLibraryResponseData() {
        return mLibraryResponseData;
    }

    public MutableLiveData<ServerResponse<List<LibraryItemResponseData>>> getLibraryItemResponseData() {
        return mLibraryItemResponseData;
    }

}
