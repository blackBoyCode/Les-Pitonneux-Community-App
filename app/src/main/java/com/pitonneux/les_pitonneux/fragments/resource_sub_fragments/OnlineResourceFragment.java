package com.pitonneux.les_pitonneux.fragments.resource_sub_fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.pitonneux.les_pitonneux.ListItem;
import com.pitonneux.les_pitonneux.ListItemAdapter;
import com.pitonneux.les_pitonneux.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class OnlineResourceFragment extends Fragment {

    public static final String ONLINE_FRAGMENT_REQUEST = "https://androidtestproject-d2b4d.firebaseio.com/onlineResources.json" ;

    public OnlineResourceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.navigation_list,container,false);


        //TODO: this is dummy code and must be  replace with  JSON value
        ArrayList<ListItem> localResourceList = new ArrayList<ListItem>();
        localResourceList.add(new ListItem("blabla2", "blabla Description2",R.mipmap.ic_launcher));
        localResourceList.add(new ListItem("blablabllablablab", "blabla blelaksbla", R.mipmap.ic_launcher));


        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // To see the listItem view these two line of code must be initialize
        ListItemAdapter listItemAdapter = new ListItemAdapter(getActivity(), localResourceList);

        listView.setAdapter(listItemAdapter);

        return rootView;
    }

}
