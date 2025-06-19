package com.elegidocodes.androidtest.app;

import com.elegidocodes.androidtest.model.LibraryItemResponseData;
import com.elegidocodes.androidtest.model.LibraryResponseData;
import com.elegidocodes.androidtest.model.LoginResponseData;
import com.elegidocodes.androidtest.model.ServerResponse;
import com.google.gson.JsonObject;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MyAPI {

    @POST("auth/login")
    Call<ServerResponse<LoginResponseData>> login(@Body JsonObject jsonObject);

    @POST("auth/logout")
    Call<ServerResponse<String>> logout();

    @GET("library")
    Call<ServerResponse<LibraryResponseData>> searchInLibrary(@Query("search") String search);

    @GET("library/{id}")
    Call<ServerResponse<List<LibraryItemResponseData>>> getLibraryInfo(@Path("id") int libraryId);

    @Multipart
    @POST("users/profileUpdate")
    Call<ServerResponse<String>> updateProfile(
            @Part("name") RequestBody firstName,
            @Part("last_name") RequestBody lastName,
            @Part("email") RequestBody email
    );

    @Multipart
    @POST("users/profilePicture")
    Call<ServerResponse<String>> updateProfilePicture(@Part MultipartBody.Part file);

}
