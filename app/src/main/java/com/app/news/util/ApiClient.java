package com.app.news.util;

import static com.app.news.model.Contants.BASE_URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public static ApiResponse getApiService() {
        return getRetrofitInstance().create(ApiResponse.class);
    }
}
