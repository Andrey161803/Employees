package com.andrewsapp.employeeslist.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Employee implements Comparable<Employee>{
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("skills")
    @Expose
    private List<String> skills = null;

    public String getName() {
        return name;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    public List<String> getSkills() {
        return skills;
    }


    @Override
    public int compareTo(Employee o) {
        if(this.name == null){
            this.name = "Имя неизвестно";
            return 0;
        }
        if(o.name == null){
            this.name = "Имя неизвестно";
            return 0;
        }
        return this.name.compareTo(o.name);
    }
}
