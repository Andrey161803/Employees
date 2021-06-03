package com.andrewsapp.employeeslist.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiFactory {

    private static final String BASE_URL = "http://www.mocky.io/";

    private static Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build();


    public static ApiService apiService = retrofit.create(ApiService.class);
}
