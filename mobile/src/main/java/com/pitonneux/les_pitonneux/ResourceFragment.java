package com.pitonneux.les_pitonneux;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        View rootView = inflater.inflate(R.layout.resource_fragment,container,false);


        //HERE WE SET THE VIEWPAGER AND THE TAB LAYOUT

       // ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.resource_view_pager);//TODO:this work

        //set the adapter here                                     ///TODO:this migth not work????
        ResourceAdapter resourceAdapter = new ResourceAdapter(getActivity(), getActivity().getSupportFragmentManager());

//        viewPager.setAdapter(resourceAdapter);


        //TabLayout tabLayout = (TabLayout) getActivity().findViewById(R.id.resource_tab_layout);
//        tabLayout.setupWithViewPager(viewPager);







        return rootView;
    }

}
