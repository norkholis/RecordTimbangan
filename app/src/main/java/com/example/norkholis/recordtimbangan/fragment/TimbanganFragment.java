package com.example.norkholis.recordtimbangan.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.norkholis.recordtimbangan.R;
import com.example.norkholis.recordtimbangan.adapter.TabFragmentPagerAdapter;
import com.example.norkholis.recordtimbangan.util.SharedPrefManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimbanganFragment extends Fragment {

    SharedPrefManager sharedPrefManager;
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

        TextView infoBr = (TextView)view.findViewById(R.id.infoBr);
        TextView dateBr = (TextView)view.findViewById(R.id.dateBr);
        TextView infoWeight = (TextView)view.findViewById(R.id.infoWeight);
        TextView dateWeight = (TextView)view.findViewById(R.id.dateWeight);

        sharedPrefManager = new SharedPrefManager(getContext());

        float viewInfoBmr = sharedPrefManager.getSpBmr();
        float viewInfoWeight = sharedPrefManager.getSpBeratBadan();
        String viewDate = sharedPrefManager.getSpLastDate();

        String stringViewInfoBmr = Float.toString(viewInfoBmr);
        String stringViewInfoWeight = Float.toString(viewInfoWeight);

        infoBr.setText(stringViewInfoBmr);
        infoWeight.setText(stringViewInfoWeight);
        dateBr.setText(viewDate);
        dateWeight.setText(viewDate);

        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        getActivity().getActionBar().setTitle("Timbangan");
    }
}
