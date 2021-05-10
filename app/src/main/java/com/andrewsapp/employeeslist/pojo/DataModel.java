package com.andrewsapp.employeeslist.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataModel {
    @SerializedName("company")
    @Expose
    private Company company = null;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company employees) {
        this.company = employees;
    }
}
