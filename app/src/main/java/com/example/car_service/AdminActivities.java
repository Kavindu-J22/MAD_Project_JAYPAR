package com.example.car_service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AdminActivities extends AppCompatActivity {

    private TextView addService, approvedServices, clientView, issueBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_activities);

        addService = findViewById(R.id.adminAddServiceText);
        approvedServices = findViewById(R.id.adminApprovedText);
        clientView = findViewById(R.id.adminClientText);
        issueBill = findViewById(R.id.adminIssueBillText);

        addService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminActivities.this,add_Services.class));
            }
        });

        approvedServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminActivities.this,View_Approved_Bookings.class));
            }
        });

        clientView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminActivities.this,MenuActivity.class));
            }
        });

        issueBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminActivities.this,IssueBill.class));
            }
        });
    }

}
