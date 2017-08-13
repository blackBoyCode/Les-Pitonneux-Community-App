package com.pitonneux.les_pitonneux.fragments;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.app.LoaderManager;
import android.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.pitonneux.les_pitonneux.ListItem;
import com.pitonneux.les_pitonneux.ListItemAdapter;
import com.pitonneux.les_pitonneux.R;
import com.pitonneux.les_pitonneux.loaders.NewsEventsLoader;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;
import static android.os.Build.VERSION_CODES.N;
import static android.support.v7.widget.AppCompatDrawableManager.get;

/**
 * A simple {@link Fragment} subclass.
 *
 * This fragment will contain the news from our bottom layout
 */
public class NewsFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<ListItem>> {


    // set this String to public to verify witch link on QueryUtils
    public static final String NEWS_EVENTS_REQUEST_URL = "https://androidtestproject-d2b4d.firebaseio.com/newsEvents.json";

    private static final int NEWS_LOADER_ID = 1;

    private ListItemAdapter mAdapter;

    private TextView mEmptyStateTextView;

    private View loadingIndicator;

    public NewsFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //REMEMBER TO ALWAYS USE rootView  WHEN LINKING VIEW IN FRAGMENTS
        View rootView = inflater.inflate(R.layout.navigation_list,container,false);

        mEmptyStateTextView = (TextView) rootView.findViewById(R.id.empty_view);

        loadingIndicator = rootView.findViewById(R.id.loading_indicator);




//        listItem.add(new ListItem("new Header","short description of the new list item fragment"));
//        listItem.add(new ListItem("new Header2","short description2 of the new list item fragment"));

        mAdapter = new ListItemAdapter(getContext(),new ArrayList<ListItem>());

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setEmptyView(mEmptyStateTextView);

        listView.setAdapter(mAdapter);



        //TODO must set the onItemClickListener


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
            loaderManager.initLoader(NEWS_LOADER_ID, null, this);


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
        return new NewsEventsLoader(getContext(),NEWS_EVENTS_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<ListItem>> loader, List<ListItem> data) {
                            //the get activity here is the FragmentActivity

        //TODO need to understand why this line of code crash my app
        //View loadingIndicator = getActivity.findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);// I had to put it as a global variable for the bug


        mEmptyStateTextView.setText("No News Found");

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
