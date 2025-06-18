package com.elegidocodes.androidtest.ui.fragment.library;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.elegidocodes.androidtest.model.LibraryItemResponseData;
import com.elegidocodes.androidtest.model.ServerResponse;
import com.elegidocodes.androidtest.repository.LibraryRepository;

import java.util.List;

public class LibraryItemViewModel extends AndroidViewModel {

    private final LibraryRepository libraryRepository;

    public LibraryItemViewModel(@NonNull Application application) {
        super(application);
        libraryRepository = new LibraryRepository(application);
    }

    public void getLibraryInfo(int libraryId, String authToken) {
        libraryRepository.getLibraryInfo(libraryId, authToken);
    }

    public LiveData<ServerResponse<List<LibraryItemResponseData>>> getLibraryItemResponseData() {
        return libraryRepository.getLibraryItemResponseData();
    }

}
