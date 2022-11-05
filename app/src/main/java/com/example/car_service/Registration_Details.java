package com.example.car_service;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Registration_Details extends AppCompatActivity {

    private EditText name,email,phone;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_details);

        name = (EditText)findViewById(R.id.registrationNameText);
        email = (EditText)findViewById(R.id.registrationEmailText);
        phone = (EditText)findViewById(R.id.registrationPhoneText);

        btnSave = (Button)findViewById(R.id.registrationSaveBtn);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });
    }

    private void insertData(){

        Map<String,Object> map = new HashMap<>();
        map.put("Name",name.getText().toString());
        map.put("Email",email.getText().toString());
        map.put("Phone",phone.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("user_details").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        new SweetAlertDialog(Registration_Details.this,SweetAlertDialog.SUCCESS_TYPE)
                                .setTitleText("Message")
                                .setContentText("Registration Completed")
                                .setConfirmText("OK")
                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                                        Intent intent = new Intent(Registration_Details.this,Login_Activity.class);
                                        startActivity(intent);

                                    }
                                })
                                .show();
                    }
                })

                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        new SweetAlertDialog(Registration_Details.this,SweetAlertDialog.ERROR_TYPE)
                                .setTitleText("Message")
                                .setContentText("Error While Registration")
                                .setConfirmText("OK")
                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                                        Intent intent = new Intent(Registration_Details.this,Registration_Details.class);
                                        startActivity(intent);

                                    }
                                })
                                .show();

                    }
                });

    }
}