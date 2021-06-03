package com.andrewsapp.employeeslist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {


    RecyclerView mRecyclerView;

    private void init() {
        mRecyclerView = findViewById(R.id.rvEmployees);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();




    }
}