package com.example.car_service;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PageAdapter extends FragmentStatePagerAdapter {

    int tabCount;

    public PageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabCount = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0 : return new FragmentTab1();
            case 1 : return new FragmentTab2();
            case 2 : return new FragmentTab3();
            default : return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}