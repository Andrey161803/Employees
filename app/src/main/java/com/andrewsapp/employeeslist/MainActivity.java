package com.andrewsapp.employeeslist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import com.andrewsapp.employeeslist.adaptor.EmployeesAdaptor;
import com.andrewsapp.employeeslist.databinding.ActivityMainBinding;
import com.andrewsapp.employeeslist.dialog.AlertDialogFragment;
import com.andrewsapp.employeeslist.pojo.Employee;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    EmployeesAdaptor adapter = new EmployeesAdaptor();
    MainViewModel model;
    ActivityMainBinding viewBinding;
    ConnectivityManager connectivityManager;
    NetworkInfo networkInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());

        model = new ViewModelProvider(this).get(MainViewModel.class);

        if (!model.isCalledAlertDialog()) {
            if (internetIsConnected()) {
                AlertDialogFragment alertDialog = new AlertDialogFragment();
                alertDialog.show(getSupportFragmentManager(), "AlertDialog");
                alertDialog.setCancelable(false);
                model.setCalledAlertDialog(true);
            }
        }

        model.getEmployees().observe(this, new Observer<List<Employee>>() {
                    @Override
                    public void onChanged(List<Employee> employee) {
                        if (employee != null) {
                            adapter.setEmployees(employee);
                            viewBinding.rvEmployees.setAdapter(adapter);
                        }
                    }
                }
        );
    }

    boolean internetIsConnected() {
        connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        networkInfo = connectivityManager.getActiveNetworkInfo();

        return (networkInfo == null || !networkInfo.isConnected() || !networkInfo.isAvailable());
    }
}
