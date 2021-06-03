package com.andrewsapp.employeeslist.pojo;

import com.andrewsapp.employeeslist.database.SkillsConverter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

@Entity(tableName = "employee_list")
public class Employee {
    @PrimaryKey(autoGenerate = true)
    public int id = 0;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("phone_number")
    @Expose
    public String phoneNumber;

    @SerializedName("skills")
    @Expose
    @TypeConverters({SkillsConverter.class})
    public List<String> skills = null;

    public String getName() {
        return name;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    public List<String> getSkills() {
        return skills;
    }
}
