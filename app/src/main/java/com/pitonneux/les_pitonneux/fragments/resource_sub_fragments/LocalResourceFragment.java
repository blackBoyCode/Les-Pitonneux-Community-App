package com.pitonneux.les_pitonneux.fragments.resource_sub_fragments;


import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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

import com.pitonneux.les_pitonneux.DetailActivity;
import com.pitonneux.les_pitonneux.DetailActivity2ToErase;
import com.pitonneux.les_pitonneux.ListItem;
import com.pitonneux.les_pitonneux.ListItemAdapter;
import com.pitonneux.les_pitonneux.R;
import com.pitonneux.les_pitonneux.loaders.LocalResourceLoader;

import java.util.ArrayList;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocalResourceFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<ListItem>>{

    //set this String to public to verify witch link on QueryUtils
    public static final String LOCAL_RESOURCE_REQUEST = "https://androidtestproject-d2b4d.firebaseio.com/localResources.json";

    private static final int LOCAL_RESOURCE_LOADER_ID = 2;

    private ListItemAdapter mAdapter;

    private TextView mEmptyStateTextView;

    private View loadingIndicator;


    public LocalResourceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.navigation_list,container,false);

        mEmptyStateTextView = (TextView) rootView.findViewById(R.id.empty_view);

        loadingIndicator = rootView.findViewById(R.id.loading_indicator);

        mAdapter = new ListItemAdapter(getContext(),new ArrayList<ListItem>());

//        //here we put the list item text and value
//        ArrayList<ListItem> localResourceList = new ArrayList<ListItem>();
//        localResourceList.add(new ListItem("DigiLabs-MTL", "IoT workshops for everyone!, come and engage the engine in yourself.",R.drawable.digi_lab));
//        localResourceList.add(new ListItem("PyLadiesMTL", "A group of women developers in Montreal who love the Python programming language.",R.drawable.pylady_geek_full_standard));

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setEmptyView(mEmptyStateTextView);

//        // To see the listItem view these two line of code must be initialize
//        ListItemAdapter listItemAdapter = new ListItemAdapter(getActivity(), localResourceList);

        //set the adapter that will display the info
        listView.setAdapter(mAdapter);



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



        // check internet connectivity
        ConnectivityManager connMgr = (ConnectivityManager)
                getContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        // Get details on the currently active default data network
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        // If there is a network connection, fetch data
        // if networkInfo is not empty and network is connected then perform step...
        if (networkInfo != null && networkInfo.isConnected()) {

            //TODO why get activity
            LoaderManager loaderManager = getActivity().getLoaderManager();//there also getSupportLoaderManager();
            // initialize the loader and specify an id for reuse
            loaderManager.initLoader(LOCAL_RESOURCE_LOADER_ID, null, this);


        } else {
            //set the loading indicator to gone if we have no connection
            //so that it will not overlap the view when showing "no internet connection"
            View loadingIndicator = rootView.findViewById(R.id.loading_indicator);
            loadingIndicator.setVisibility(View.GONE);

            mEmptyStateTextView.setText("no internet connection");
        }






        return rootView;
    }


    @Override
    public Loader<List<ListItem>> onCreateLoader(int id, Bundle args) {
        return new LocalResourceLoader(getContext(),LOCAL_RESOURCE_REQUEST);
    }

    @Override
    public void onLoadFinished(Loader<List<ListItem>> loader, List<ListItem> data) {


        loadingIndicator.setVisibility(View.GONE);// I had to put it as a global variable for the bug where the app crash


        mEmptyStateTextView.setText("No Local Information Found");

        mAdapter.clear();

        if(data != null && !data.isEmpty()){


            mAdapter.addAll(data);
        }

    }

    @Override
    public void onLoaderReset(Loader<List<ListItem>> loader) {

        mAdapter.clear();
    }
}
