package com.andrewsapp.employeeslist.database;

import android.os.Build;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import androidx.annotation.RequiresApi;
import androidx.room.TypeConverter;

public class SkillsConverter {
    @RequiresApi(api = Build.VERSION_CODES.N)
    @TypeConverter
    public String fromSkils(List<String> skills) {
        if (skills == null) {
            return "";
        }
        return skills.stream().collect(Collectors.joining(","));
    }

    @TypeConverter
    public List<String> toSkills(String data) {
        if (data == null) {
            return (null);
        }
        return Arrays.asList(data.split(","));
    }
}
