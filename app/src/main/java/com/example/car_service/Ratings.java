package com.example.car_service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Ratings extends AppCompatActivity {

    Button button;
    RatingBar ratingStars;
    TextView menuIcon;
    float myRating=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratings);

        button =findViewById(R.id.button);
        ratingStars = findViewById(R.id.ratingBar);

        menuIcon = (TextView)findViewById(R.id.menuIcon);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ratings.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        ratingStars.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                int rating = (int) v;
                String message = null;
                myRating = (int) ratingBar.getRating();
                switch(rating){
                    case 1:
                        message = "Sorry to hear that";
                        break;
                    case 2:
                        message = "We always accept suggestions";
                        break;
                    case 3:
                        message = "Good enough!";
                        break;
                    case 4:
                        message = "Great! Thank You!";
                        break;
                    case 5:
                        message = "Awesome! You are the best!";
                        break;
                }
                Toast.makeText(Ratings.this, message,Toast.LENGTH_SHORT).show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SweetAlertDialog(
                        Ratings.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                        .setTitleText("Thank You")
                        .setContentText("Your Rating is "+myRating)
                        .setCustomImage(R.drawable.ic_favorite)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                Intent intent = new Intent(Ratings.this,Description.class);
                                startActivity(intent);

                            }
                        })
                        .show();
            }
        });
    }

}