package com.andrewsapp.employeeslist.database;

import com.andrewsapp.employeeslist.pojo.Employee;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
/*если телефонный номер сотрудника не будет null
  его можно использовать как PrimaryKey
  и перезаписывать только изминившиеся
  @Insert (onConflict = OnConflictStrategy.REPLACE),
  а так придётся удалять все записи и записывать снова.
  можно сравнивать, но в данном случае наверное это не нужно*/

@Dao
public interface EmployeesInfoDao {

    @Query("SELECT * FROM employee_list")
    LiveData<List<Employee>> getEmployees();

    @Insert
    void insertEmployees(List<Employee> employees);

    @Query("DELETE FROM employee_list")
    void deleteAllEmployees();
}
