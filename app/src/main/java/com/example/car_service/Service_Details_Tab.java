package com.example.car_service;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Service_Details_Tab extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem tabItem1,tabItem2,tabItem3;
    ViewPager viewPager;
    PageAdapter pageAdapter;
    TextView menuIcon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_details_tab);

        tabLayout = (TabLayout)findViewById(R.id.tabLayout1);
        tabItem1 = (TabItem)findViewById(R.id.tab1);
        tabItem2 = (TabItem)findViewById(R.id.tab2);
        tabItem3 = (TabItem)findViewById(R.id.tab3);
        viewPager = (ViewPager)findViewById(R.id.viewPager);

        menuIcon = (TextView)findViewById(R.id.menuIcon);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Service_Details_Tab.this, MenuActivity.class);
                startActivity(intent);
            }
        });


        pageAdapter = new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                if(tab.getPosition()==0 || tab.getPosition()==1 || tab.getPosition()==2)
                    pageAdapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}