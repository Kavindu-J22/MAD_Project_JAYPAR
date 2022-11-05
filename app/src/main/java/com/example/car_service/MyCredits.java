package com.example.car_service;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.SearchView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class MyCredits extends AppCompatActivity {

    TextView menuIcon;
    PaymentAdapter paymentAdapter;
    RecyclerView recyclerView;
    Button makePaymentBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_credits);

        recyclerView=(RecyclerView)findViewById(R.id.rv123);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        FirebaseRecyclerOptions<PaymentModel> options =
                new FirebaseRecyclerOptions.Builder<PaymentModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("my_credits"), PaymentModel.class)
                        .build();

        paymentAdapter=new PaymentAdapter(options);
        recyclerView.setAdapter(paymentAdapter);

        menuIcon = findViewById(R.id.menuIcon);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyCredits.this,MenuActivity.class));
            }
        });

        makePaymentBtn = findViewById(R.id.makePaymentBtn);

        makePaymentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyCredits.this,MakePayment.class));
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        paymentAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        paymentAdapter.stopListening();
    }

}