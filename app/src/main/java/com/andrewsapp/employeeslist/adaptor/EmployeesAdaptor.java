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
        final TextView tvNameEmployee, tvPhoneNumber, tvSkills;

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

        viewHolder.tvNameEmployee.setText(employees.get(position).getName());
        viewHolder.tvPhoneNumber.setText(employees.get(position).getPhoneNumber());
        if (employees.get(position).getSkills() != null) {
            viewHolder.tvSkills.setText(employees.get(position).getSkills().toString());
        } else {
            viewHolder.tvSkills.setText("Навыки не известны");
        }
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }
}
