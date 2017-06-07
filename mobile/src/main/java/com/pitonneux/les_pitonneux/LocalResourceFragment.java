package com.pitonneux.les_pitonneux;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocalResourceFragment extends Fragment {


    public LocalResourceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.navigation_list,container,false);


        ArrayList<ListItem> localResourceList = new ArrayList<ListItem>();
        localResourceList.add(new ListItem("blabla", "blabla Description",R.mipmap.ic_launcher));

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // To see the listItem view these two line of code must be initialize
        ListItemAdapter  listItemAdapter = new ListItemAdapter(getActivity(), localResourceList);

        listView.setAdapter(listItemAdapter);







        return rootView;
    }

}
