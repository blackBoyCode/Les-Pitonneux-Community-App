package com.pitonneux.les_pitonneux;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 *
 * This fragment will contain the news from our bottom layout
 */
public class NewsFragment extends Fragment {


    public NewsFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View rootView = inflater.inflate(R.layout.navigation_list,container,false);

        ArrayList<ListItem> listItem = new ArrayList<ListItem>();

        //TODO: must replace this with real JSON value

        listItem.add(new ListItem("new Header","short description of the new list item fragment"));
        listItem.add(new ListItem("new Header2","short description2 of the new list item fragment"));

        ListItemAdapter listItemAdapter = new ListItemAdapter(getContext(),listItem);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(listItemAdapter);





        return rootView;
    }

}
