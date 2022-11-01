package com.example.car_service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    private TextView home,myBookings,admin,reviews,share,delivery,payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        home = findViewById(R.id.menuHomeText);
        myBookings = findViewById(R.id.menuMyBookingsText);
        reviews = findViewById(R.id.menuReviewText);
        admin = findViewById(R.id.menuAdminText);
        share = findViewById(R.id.menuShareText);
        delivery = findViewById(R.id.menuDeliveryText);
        payment = findViewById(R.id.menuPaymentsText);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this,Description.class));
            }
        });

        myBookings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this,Service_Details_Tab.class));
            }
        });

        reviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this,Ratings.class));
            }
        });

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this,AdminLogin.class));
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFacebookPage("ColorPix.lk");
            }
        });

        delivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this,DeliveryActivity.class));
            }
        });

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this,MyCredits.class));
            }
        });

    }

    private void goToFacebookPage(String id){
        try{
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/" + id));
            startActivity(intent);
        }
        catch (ActivityNotFoundException e){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/" + id));
            startActivity(intent);
        }
    }
}