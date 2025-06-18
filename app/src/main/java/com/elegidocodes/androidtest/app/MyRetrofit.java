package com.elegidocodes.androidtest.app;

import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetrofit {

    private static final String BASE_URL = "https://nupi.kreativeco.com/api/";
    private static Retrofit retrofit;

    private MyRetrofit() {

    }

    private static String authToken = null;

    public static void setAuthToken(String token) {
        authToken = token;
    }

    public static MyAPI getService() {

        if (retrofit == null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(59, TimeUnit.SECONDS)
                    .writeTimeout(59, TimeUnit.SECONDS)
                    .readTimeout(59, TimeUnit.SECONDS)
                    .addInterceptor(chain -> {
                        Request original = chain.request();

                        Request.Builder requestBuilder = original.newBuilder();
                        if (authToken != null && !authToken.isEmpty()) {
                            requestBuilder.addHeader("Authorization", "Bearer " + authToken);
                        }

                        return chain.proceed(requestBuilder.build());
                    })
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit.create(MyAPI.class);
    }

}
