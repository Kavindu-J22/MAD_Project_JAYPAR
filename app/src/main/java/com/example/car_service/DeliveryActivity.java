package com.example.car_service;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DeliveryActivity extends AppCompatActivity {

    private EditText etSource,etDestination,kmInput,chargeInput;
    private Button trackBtn,calculateBtn;
    private TextView calculatedCharge,menuIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        etSource = findViewById(R.id.et_source);
        etDestination = findViewById(R.id.et_destination);
        trackBtn = findViewById(R.id.trackBtn);
        menuIcon = findViewById(R.id.menuIcon);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeliveryActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        trackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sSource = etSource.getText().toString().trim();
                String sDestination = etDestination.getText().toString().trim();

                if (sSource.equals("") && sDestination.equals("")){
                    Toast.makeText(getApplicationContext(), "Enter both locations", Toast.LENGTH_SHORT).show();
                }
                else{
                    displayTrack(sSource,sDestination);
                }

            }
        });

        kmInput = findViewById(R.id.kmInput);
        chargeInput = findViewById(R.id.chargeInput);
        calculatedCharge = findViewById(R.id.calculatedCharge);
        calculateBtn = findViewById(R.id.calculateBtn);

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateCharge();
            }
        });

    }

    private void displayTrack(String sSource, String sDestination){
        try{
            Uri uri = Uri.parse("https://www.google.co.in/maps/dir/" + sSource + "/" + sDestination);

            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            intent.setPackage("com.google.android.apps.maps");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        catch (ActivityNotFoundException e){
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    private void calculateCharge(){
        double num1 = Double.parseDouble(kmInput.getText().toString());
        double num2 = Double.parseDouble(chargeInput.getText().toString());

        double num;
        num = num1 * num2;

        calculatedCharge.setText(String.valueOf(num));
    }

}
