package com.pitonneux.les_pitonneux;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

        //here we put the list item text and value
        ArrayList<ListItem> localResourceList = new ArrayList<ListItem>();
        localResourceList.add(new ListItem("DigiLabs-MTL", "IoT workshops for everyone!, come and engage the engine in yourself.",R.drawable.digi_lab));
        localResourceList.add(new ListItem("PyLadiesMTL", "A group of women developers in Montreal who love the Python programming language.",R.drawable.pylady_geek_full_standard));

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // To see the listItem view these two line of code must be initialize
        ListItemAdapter  listItemAdapter = new ListItemAdapter(getActivity(), localResourceList);

        //set the adapter that will display the info
        listView.setAdapter(listItemAdapter);


        //TODO:must set the on ItemClickListener on the other fragment

        //handle the click event of a list item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //TODO:this is dummy code for now much change in the future
                if(position == 0){

                    Intent I = new Intent(getActivity(),DetailActivity.class);
                    startActivity(I);
                }else{

                    Intent I = new Intent(getActivity(),DetailActivity2ToErase.class);
                    startActivity(I);

                }


            }
        });









        return rootView;
    }




}
