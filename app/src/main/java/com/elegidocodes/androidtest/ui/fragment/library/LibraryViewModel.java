package com.elegidocodes.androidtest.ui.fragment.library;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.elegidocodes.androidtest.model.LibraryResponseData;
import com.elegidocodes.androidtest.model.ServerResponse;
import com.elegidocodes.androidtest.repository.LibraryRepository;

public class LibraryViewModel extends AndroidViewModel {

    private final LibraryRepository libraryRepository;

    public LibraryViewModel(@NonNull Application application) {
        super(application);
        libraryRepository = new LibraryRepository(application.getApplicationContext());
    }

    public void searchInLibrary(String query, String token) {
        libraryRepository.searchInLibrary(query, token);
    }

    public LiveData<ServerResponse<LibraryResponseData>> getLibraryResponseData() {
        return libraryRepository.getLibraryResponseData();
    }

}