package com.andrewsapp.employeeslist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.util.Log;

import com.andrewsapp.employeeslist.adaptor.EmployeesAdaptor;
import com.andrewsapp.employeeslist.api.ApiService;
import com.andrewsapp.employeeslist.pojo.DataModel;
import com.andrewsapp.employeeslist.pojo.Employee;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = "http://www.mocky.io/";
    RecyclerView mRecyclerView;

    private void init() {
        mRecyclerView = findViewById(R.id.rvEmployees);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<DataModel> mCompanyCall = apiService.getDataModel();

        mCompanyCall.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                Log.d("RetrofitCall", "Success!");

                ArrayList<Employee> employees = new ArrayList(response.body().getCompany().getEmployees());
                EmployeesAdaptor adaptor = new EmployeesAdaptor(employees);

                mRecyclerView.setAdapter(adaptor);
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {
                Log.d("RetrofitCall",  t.toString());
            }
        });
    }
}