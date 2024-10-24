package com.example.hospitalapp;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ViewPatients extends AppCompatActivity {
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_patients);
        dbHelper = new DatabaseHelper(this);
        TableLayout tableLayout = findViewById(R.id.t1);
        Cursor cursor = dbHelper.getAllPatients();

        while (cursor.moveToNext()){
            TableRow row = new TableRow(this);
            TextView idTextView = new TextView(this);
            TextView nameTextView = new TextView(this);
            TextView admissionTextView = new TextView(this);
            TextView ailmentTextView = new TextView(this);
            TextView doctorTextView = new TextView(this);
            TextView statusTextView = new TextView(this);

            idTextView.setText(cursor.getString(0));
            nameTextView.setText(cursor.getString(1));
            admissionTextView.setText(cursor.getString(2));
            ailmentTextView.setText(cursor.getString(3));
            doctorTextView.setText(cursor.getString(4));
            statusTextView.setText(cursor.getString(5));

            row.addView(idTextView);
            row.addView(nameTextView);
            row.addView(admissionTextView);
            row.addView(ailmentTextView);
            row.addView(doctorTextView);
            row.addView(statusTextView);

            tableLayout.addView(row);


        }
        cursor.close();


    }
}