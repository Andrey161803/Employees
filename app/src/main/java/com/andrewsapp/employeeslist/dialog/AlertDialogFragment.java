package com.andrewsapp.employeeslist.dialog;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.andrewsapp.employeeslist.R;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import static android.provider.Settings.ACTION_SETTINGS;

public class AlertDialogFragment extends DialogFragment {
    AlertDialog.Builder builder;
    View alertDialogLayout;
    Button btnOk;
    Button btnCancel;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        builder = new AlertDialog.Builder(getActivity());
        alertDialogLayout = LayoutInflater.from(getActivity()).inflate(R.layout.alert_dialog_layout, null);
        builder.setView(alertDialogLayout);

        btnOk = alertDialogLayout.findViewById(R.id.btnOk);
        btnCancel = alertDialogLayout.findViewById(R.id.btnCancel);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                Intent intent = new Intent(ACTION_SETTINGS);
                startActivity(intent);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return builder.create();
    }
}
