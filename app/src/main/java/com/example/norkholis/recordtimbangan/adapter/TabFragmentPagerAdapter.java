package com.example.norkholis.recordtimbangan.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.norkholis.recordtimbangan.fragment.AddNewRecord;
import com.example.norkholis.recordtimbangan.fragment.ViewRecord;

public class TabFragmentPagerAdapter extends FragmentPagerAdapter {

    String[] title = new String[]{
            "AddNewRecord", "ViewRecord"
    };

    public TabFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch(position){
            case 0:
                fragment = new AddNewRecord();
                break;
            case 1:
                fragment = new ViewRecord();
                break;
            default:
                fragment = null;
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    @Override
    public int getCount() {
        return title.length;
    }
}
