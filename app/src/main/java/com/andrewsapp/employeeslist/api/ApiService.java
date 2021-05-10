package com.andrewsapp.employeeslist.api;

import com.andrewsapp.employeeslist.pojo.DataModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("v2/5ddcd3673400005800eae483")
    Call<DataModel> getDataModel();
}
