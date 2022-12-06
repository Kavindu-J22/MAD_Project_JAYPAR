package com.example.agecallculator01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText BirthYear;
    TextView ShowAns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BirthYear = findViewById(R.id.TBinputNumber);
        ShowAns = findViewById(R.id.LBLans);
    }

    public void CalcAge(View view){
        Integer YearOfBirth = Integer.valueOf(BirthYear.getText().toString());
        Integer currentYear = Calendar.getInstance().get(Calendar.YEAR);
        String ans = String.valueOf(currentYear - YearOfBirth);

        ShowAns.setText("Your age is "+ans+" Years old..!");
    }
}