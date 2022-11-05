package com.example.car_service;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class IssueBill extends AppCompatActivity {

    EditText CarNo,BookingId,Date,OwnerName,DeCost,TotalCost,FullAmount;
    Button button6,button7;
    TextView amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue_bill);


        CarNo=(EditText)findViewById(R.id.editBikeNum);
        BookingId=(EditText)findViewById(R.id.editBookingID);
        OwnerName=(EditText)findViewById(R.id.editOwner);
        Date=(EditText)findViewById(R.id.editDate);

        DeCost=(EditText)findViewById(R.id.editDCost);
        TotalCost=(EditText)findViewById(R.id.editTCost);

        amount=(TextView)findViewById(R.id.textView12);

        button6=(Button)findViewById(R.id.button6);
        button7=(Button)findViewById(R.id.button7);

        button6.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                insertPaymentData();
            }
        });

        button7.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                finish();
            }
        });
    }


    private void insertPaymentData(){

        double num1=Double.parseDouble(TotalCost.getText().toString());
        double num2=Double.parseDouble(DeCost.getText().toString());


        double sum=num1+num2;

        amount.setText(Double.toString(sum));



        Map<String,Object> map =new HashMap<>();

        map.put("CarNo",CarNo.getText().toString());
        map.put("BookingId",BookingId.getText().toString());
        map.put("OwnerName",OwnerName.getText().toString());
        map.put("Date",Date.getText().toString());
        map.put("FullAmount",amount.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("my_credits").push().setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(IssueBill.this, "Data Insert SuccessFully",Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(IssueBill.this, "Error While Insertion", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void clearAll(){
        CarNo.setText("");
        BookingId.setText("");
        OwnerName.setText("");
        Date.setText("");

        TotalCost.setText("");
        DeCost.setText("");

    }

}
