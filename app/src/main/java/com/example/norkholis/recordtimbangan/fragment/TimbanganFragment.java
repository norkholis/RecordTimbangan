package com.example.norkholis.recordtimbangan.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.norkholis.recordtimbangan.R;
import com.example.norkholis.recordtimbangan.adapter.TabFragmentPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimbanganFragment extends Fragment {

    private static final String TAG = TimbanganFragment.class.getSimpleName();
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public TimbanganFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_timbangan, container, false);
        tabLayout = (TabLayout)view.findViewById(R.id.tabs);
        viewPager = (ViewPager)view.findViewById(R.id.viewPager);
        viewPager.setAdapter(new TabFragmentPagerAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

}
