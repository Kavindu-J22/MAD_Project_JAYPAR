package com.example.car_service;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Login_Activity extends AppCompatActivity {

    private EditText mEmail,mPass;
    private Button logBtn;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = (EditText)findViewById(R.id.logEmailEditText);
        mPass = (EditText)findViewById(R.id.logPasswordEditText);
        logBtn = (Button)findViewById(R.id.loginBtn);

        mAuth = FirebaseAuth.getInstance();

        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        TextView btn = findViewById(R.id.registerText);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_Activity.this,Register_Activity.class));
            }
        });
    }

    private void loginUser(){
        String email = mEmail.getText().toString();
        String pass = mPass.getText().toString();

        if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            if(!pass.isEmpty()){
                mAuth.signInWithEmailAndPassword(email,pass)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                new SweetAlertDialog(Login_Activity.this,SweetAlertDialog.SUCCESS_TYPE)
                                        .setTitleText("Message")
                                        .setContentText("Log In Successful")
                                        .setConfirmText("OK")
                                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                            @Override
                                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                                Intent intent = new Intent(Login_Activity.this,Description.class);
                                                startActivity(intent);

                                            }
                                        })
                                        .show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                new SweetAlertDialog(Login_Activity.this,SweetAlertDialog.ERROR_TYPE)
                                        .setTitleText("Message")
                                        .setContentText("Login Error")
                                        .setConfirmText("OK")
                                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                            @Override
                                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                                Intent intent = new Intent(Login_Activity.this,Login_Activity.class);
                                                startActivity(intent);

                                            }
                                        })
                                        .show();
                            }
                        });
            }
            else{
                mPass.setError("Empty Fields Not Allowed");
            }
        }
        else if(email.isEmpty()){
            mEmail.setError("Empty Fields Not Allowed");
        }
        else{
            mEmail.setError("Please Enter Valid Email");
        }

    }
}