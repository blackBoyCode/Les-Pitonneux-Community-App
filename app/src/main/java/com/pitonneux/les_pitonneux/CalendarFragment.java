package com.pitonneux.les_pitonneux;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CalendarFragment extends Fragment {


    public CalendarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.navigation_list,container,false);

        ArrayList<ListItem> listItem = new ArrayList<ListItem>();

        //TODO: must replace this with real JSON value

        listItem.add(new ListItem("coffee and code ","it at 9h am ","June","6"));
        listItem.add(new ListItem("nigth coffee and code","it at 6h pm","June","7"));

        //getContext???
        ListItemAdapter listItemAdapter = new ListItemAdapter(getContext(),listItem);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(listItemAdapter);


        return rootView;
    }

}
