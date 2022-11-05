package com.example.car_service;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class AdminLogin extends AppCompatActivity {

    private EditText aEmail,aPass;
    private Button adminLogBtn;

    private FirebaseAuth aAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        aEmail = (EditText)findViewById(R.id.adminEmailEditText);
        aPass = (EditText)findViewById(R.id.adminPasswordEditText);
        adminLogBtn = (Button)findViewById(R.id.adminLoginBtn);

        aAuth = FirebaseAuth.getInstance();

        adminLogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logInAdmin();
            }
        });
    }

    private void logInAdmin(){
        String email = aEmail.getText().toString();
        String pass = aPass.getText().toString();

        if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            if(!pass.isEmpty()){
                aAuth.signInWithEmailAndPassword(email,pass)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                new SweetAlertDialog(AdminLogin.this,SweetAlertDialog.SUCCESS_TYPE)
                                        .setTitleText("Message")
                                        .setContentText("Log In Successful")
                                        .setConfirmText("OK")
                                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                            @Override
                                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                                Intent intent = new Intent(AdminLogin.this,AdminActivities.class);
                                                startActivity(intent);

                                            }
                                        })
                                        .show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                new SweetAlertDialog(AdminLogin.this,SweetAlertDialog.ERROR_TYPE)
                                        .setTitleText("Message")
                                        .setContentText("Login Error")
                                        .setConfirmText("OK")
                                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                            @Override
                                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                                Intent intent = new Intent(AdminLogin.this,AdminLogin.class);
                                                startActivity(intent);

                                            }
                                        })
                                        .show();
                            }
                        });
            }
            else{
                aPass.setError("Empty Fields Not Allowed");
            }
        }
        else if(email.isEmpty()){
            aEmail.setError("Empty Fields Not Allowed");
        }
        else{
            aEmail.setError("Please Enter Valid Email");
        }

    }

}
