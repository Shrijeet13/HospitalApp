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

public class UpdateStatus extends AppCompatActivity {
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_status);
        dbHelper = new DatabaseHelper(this);
        EditText idInput = findViewById(R.id.e1);
        EditText statusInput = findViewById(R.id.e2);
        Button updateButton = findViewById(R.id.b1);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(idInput.getText().toString());
                String status = statusInput.getText().toString();
                dbHelper.updatePatientStatus(String.valueOf(id), status);
                Toast.makeText(UpdateStatus.this, "Status updated successfully", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}