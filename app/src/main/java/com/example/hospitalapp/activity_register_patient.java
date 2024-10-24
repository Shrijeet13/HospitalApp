package com.example.hospitalapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class activity_register_patient extends AppCompatActivity {
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_patient);

        dbHelper = new DatabaseHelper(this);
        EditText nameInput = findViewById(R.id.e1);
        EditText admissionInput = findViewById(R.id.e2);
        EditText ailmentInput = findViewById(R.id.e3);
        EditText doctorInput = findViewById(R.id.e4);
        Button registerButton = findViewById(R.id.b1);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameInput.getText().toString();
                String admission = admissionInput.getText().toString();
                String ailment = ailmentInput.getText().toString();
                String doctor = doctorInput.getText().toString();
                dbHelper.addPatient(name, admission, ailment, doctor);
                Toast.makeText(activity_register_patient.this, "Patient registered successfully", Toast.LENGTH_SHORT).show();
            }
        });


    }
}