package com.example.car_service;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class View_Approved_Bookings extends AppCompatActivity {

    RecyclerView recyclerView;
    ApprovedBookingAdapter approvedBookingAdapter;
    TextView menuIcon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_approved_bookings);

        recyclerView = (RecyclerView)findViewById(R.id.approvedBookingsRv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<ApprovedBookingModel> options =
                new FirebaseRecyclerOptions.Builder<ApprovedBookingModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("approved_services"), ApprovedBookingModel.class)
                        .build();

        approvedBookingAdapter = new ApprovedBookingAdapter(options);
        recyclerView.setAdapter(approvedBookingAdapter);

        menuIcon = (TextView) findViewById(R.id.menuIcon);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(View_Approved_Bookings.this, AdminActivities.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart(){
        super.onStart();
        approvedBookingAdapter.startListening();
    }

    @Override
    protected void onStop(){
        super.onStop();
        approvedBookingAdapter.stopListening();
    }

}