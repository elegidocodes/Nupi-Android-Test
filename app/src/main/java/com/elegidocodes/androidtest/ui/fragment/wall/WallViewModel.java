package com.elegidocodes.androidtest.ui.fragment.wall;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.elegidocodes.androidtest.model.BlogResponseData;
import com.elegidocodes.androidtest.model.ServerResponse;
import com.elegidocodes.androidtest.repository.WallRepository;

import java.util.List;

public class WallViewModel extends AndroidViewModel {

    private final WallRepository repository;

    public WallViewModel(@NonNull Application application) {
        super(application);
        repository = new WallRepository(application);
    }

    public void getWall(String authToken) {
        repository.getWall(authToken);
    }

    public LiveData<ServerResponse<BlogResponseData>> getWallResponseData() {
        return repository.getBlogResponseData();
    }

}