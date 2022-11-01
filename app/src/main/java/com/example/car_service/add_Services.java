package com.example.car_service;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class add_Services extends AppCompatActivity {

    EditText bookingId,carNo,problem,repairCost,serviceCost,date;
    TextView result,menuIcon;
    Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_services);

        bookingId = (EditText)findViewById(R.id.editTextBookingId);
        carNo = (EditText)findViewById(R.id.editTextCarNumber);
        problem = (EditText)findViewById(R.id.editTextProblem);
        repairCost = (EditText)findViewById(R.id.editTextRepairCost);
        serviceCost = (EditText)findViewById(R.id.editTextServiceCost);
        date = (EditText)findViewById(R.id.editTextServiceDate);
        buttonSave = (Button) findViewById(R.id.addServiceSaveBtn);
        result = (TextView) findViewById(R.id.calculatedResult);

        menuIcon = (TextView) findViewById(R.id.menuIcon);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(add_Services.this, AdminActivities.class);
                startActivity(intent);
            }
        });


        buttonSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                insertData();

            }
        });
    }


    private void insertData(){

        double num1 = Double.parseDouble(repairCost.getText().toString());
        double num2 = Double.parseDouble(serviceCost.getText().toString());

        double num;
        num = num1 + num2;

        result.setText(String.valueOf(num));

        Map<String,Object> map = new HashMap<>();
        map.put("BookingId",bookingId.getText().toString());
        map.put("CarNo",carNo.getText().toString());
        map.put("Problem",problem.getText().toString());
        map.put("TotalCost",result.getText().toString());
        map.put("Date",date.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("services").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        new SweetAlertDialog(add_Services.this,SweetAlertDialog.SUCCESS_TYPE)
                                .setTitleText("Message")
                                .setContentText("Data Inserted Successfully")
                                .setConfirmText("OK")
                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                                        Intent intent = new Intent(add_Services.this,Service_Details_Tab.class);
                                        startActivity(intent);

                                    }
                                })
                                .show();
                    }
                })

                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        new SweetAlertDialog(add_Services.this,SweetAlertDialog.ERROR_TYPE)
                                .setTitleText("Message")
                                .setContentText("Error While Insertion")
                                .setConfirmText("OK")
                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                                        Intent intent = new Intent(add_Services.this,add_Services.class);
                                        startActivity(intent);

                                    }
                                })
                                .show();

                    }
                });
    }
}