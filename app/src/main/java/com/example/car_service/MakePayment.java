package com.example.car_service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MakePayment extends AppCompatActivity {

    EditText bookingId,name,nic,mobile,address,cost;
    Button btnPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_payment);
        bookingId = (EditText) findViewById(R.id.bookingId);
        name= (EditText) findViewById(R.id.name);
        nic = (EditText) findViewById(R.id.nic);
        mobile= (EditText) findViewById(R.id.mobile);
        address = (EditText) findViewById(R.id.address);
        cost = (EditText) findViewById(R.id.cost);

        btnPay = (Button) findViewById(R.id.btnPay);


        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertPaymentData();
                clearAll();
            }

        });


    }

    private void insertPaymentData() {
        Map<String, Object> map = new HashMap<>();
        map.put("bookingId", bookingId.getText().toString());
        map.put("name", name.getText().toString());
        map.put("mobile",nic.getText().toString());
        map.put("nic", mobile.getText().toString());
        map.put("address", address.getText().toString());
        map.put("cost", cost.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("payment").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(MakePayment.this, "Successfully Saved Payment Details",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MakePayment.this,ChoosePayment.class));

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure( Exception e) {
                        Toast.makeText(MakePayment.this, "Can't Complete Payment Process ",Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void clearAll()
    {
        bookingId.setText("");
        name.setText("");
        nic.setText("");
        mobile.setText("");
        address.setText("");
        cost.setText("");
    }
}