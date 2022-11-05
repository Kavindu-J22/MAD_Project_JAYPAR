package com.example.car_service;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;
import java.util.Map;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class CarDetails  extends AppCompatActivity {

    EditText category, brand, modelYear, ccAmount, mileage;
    Button btnAdd, btnBack;
    TextView menuIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);


        category = (EditText) findViewById(R.id.category);
        brand = (EditText) findViewById(R.id.brand);
        modelYear = (EditText) findViewById(R.id.modelYear);
        ccAmount = (EditText) findViewById(R.id.ccAmount);
        mileage = (EditText) findViewById(R.id.mileage);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnBack = (Button) findViewById(R.id.btnBack);

        menuIcon = (TextView) findViewById(R.id.menuIcon);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarDetails.this,MenuActivity.class);
                startActivity(intent);
            }
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
            }

        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CarDetails.this,Description.class);
                startActivity(intent);
            }

        });
    }

    private void insertData() {
        Map<String, Object> map = new HashMap<>();
        map.put("category", category.getText().toString());
        map.put("brand", brand.getText().toString());
        map.put("modelYear", modelYear.getText().toString());
        map.put("ccAmount", ccAmount.getText().toString());
        map.put("mileage", mileage.getText().toString());
        FirebaseDatabase.getInstance().getReference().child("car_details").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        new SweetAlertDialog(CarDetails.this,SweetAlertDialog.SUCCESS_TYPE)
                                .setTitleText("Message")
                                .setContentText("Data Inserted Successfully")
                                .setConfirmText("OK")
                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                                        Intent intent = new Intent(CarDetails.this,MakeBooking.class);
                                        startActivity(intent);

                                    }
                                })
                                .show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        new SweetAlertDialog(CarDetails.this,SweetAlertDialog.ERROR_TYPE)
                                .setTitleText("Message")
                                .setContentText("Error While Insertion")
                                .setConfirmText("OK")
                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                                        Intent intent = new Intent(CarDetails.this,CarDetails.class);
                                        startActivity(intent);

                                    }
                                })
                                .show();

                    }
                });
    }

}
