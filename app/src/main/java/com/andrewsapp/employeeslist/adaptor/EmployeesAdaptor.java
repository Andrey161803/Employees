package com.andrewsapp.employeeslist.adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andrewsapp.employeeslist.R;
import com.andrewsapp.employeeslist.pojo.Employee;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EmployeesAdaptor extends RecyclerView.Adapter<EmployeesAdaptor.EmployeesViewHolder> {

    private List<Employee> employees;

    public EmployeesAdaptor(List<Employee> employees) {
        this.employees = employees;
    }

    public static class EmployeesViewHolder extends RecyclerView.ViewHolder {
        final private TextView tvNameEmployee;
        final private TextView tvPhoneNumber;
        final private TextView tvSkills;

        public void onBind(Employee employee) {
            tvNameEmployee.setText(employee.getName());
            tvPhoneNumber.setText(employee.getPhoneNumber());

            if (employee.getSkills() != null) {
                tvSkills.setText(employee.getSkills().toString());
            } else {
                tvSkills.setText(R.string.employees_adaptor_skills_unknow);
            }
        }

        public EmployeesViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNameEmployee = (TextView) itemView.findViewById(R.id.tvNameEmployee);
            tvPhoneNumber = (TextView) itemView.findViewById(R.id.tvPhoneNumber);
            tvSkills = (TextView) itemView.findViewById(R.id.tvSkills);
        }
    }


    @NonNull
    @Override
    public EmployeesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_row_item, parent, false);
        return new EmployeesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeesViewHolder viewHolder, int position) {
        viewHolder.onBind(employees.get(position));
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }
}
