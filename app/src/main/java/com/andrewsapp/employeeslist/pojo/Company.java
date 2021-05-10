package com.andrewsapp.employeeslist.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Company {

    @SerializedName("employees")
    @Expose
    private List<Employee> employees = null;

    public List<Employee> getEmployees() {
        return employees;
    }


}
