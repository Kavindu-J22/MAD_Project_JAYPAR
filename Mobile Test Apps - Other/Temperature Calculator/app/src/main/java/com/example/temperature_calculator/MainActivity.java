package com.example.temperature_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Button tempBTN = findViewById(R.id.BTNtemp);
        tempBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalculateAnswer();
            }
        });
    }

    private void CalculateAnswer(){
        EditText TempText = findViewById(R.id.TBinputTemp);
        Calculations tempCalcs = new Calculations();
        RadioButton calCelci = findViewById(R.id.RB_celci);
        RadioButton calfrh = findViewById(R.id.RB_Frh);
        TextView DisAns = findViewById(R.id.LBLans);

        if(TempText.getText().toString().isEmpty())
            Toast.makeText(this,"Please add a value..!",Toast.LENGTH_LONG).show();
        else if(!calCelci.isChecked() && !calfrh.isChecked())
            Toast.makeText(this, "Please Select your Temperature Type", Toast.LENGTH_SHORT).show();

        else {
            if(calCelci.isChecked()) {
                DisAns.setText(String.valueOf(tempCalcs.convertCelciusToFahrenheit(Float.valueOf(TempText.getText().toString()))));
                Toast.makeText(this, TempText.getText().toString() + " value Converted to Fahrenheit", Toast.LENGTH_LONG).show();
            }
            else{
                DisAns.setText(String.valueOf(tempCalcs.convertFahrenheitToCelcius(Float.valueOf(TempText.getText().toString()))));
                Toast.makeText(this, TempText.getText().toString() +" value Converted to Celcius", Toast.LENGTH_LONG).show();
            }
        }

    }
}