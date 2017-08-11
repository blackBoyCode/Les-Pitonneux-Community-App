package com.pitonneux.les_pitonneux.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pitonneux.les_pitonneux.R;
import com.pitonneux.les_pitonneux.ResourceAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResourceFragment extends Fragment {



    public ResourceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //TODO: need to add a rootView
        //Fragment we always need to inflate view and return it
        View rootView = inflater.inflate(R.layout.resource_fragment, container, false);


        //HERE WE SET THE VIEWPAGER AND THE TAB LAYOUT


        ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.resource_view_pager);

        //set the adapter here
        ResourceAdapter resourceAdapter = new ResourceAdapter(getActivity(),getChildFragmentManager());


        viewPager.setAdapter(resourceAdapter);

        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.resource_tab_layout);
        tabLayout.setupWithViewPager(viewPager);



        return rootView;
    }

}
