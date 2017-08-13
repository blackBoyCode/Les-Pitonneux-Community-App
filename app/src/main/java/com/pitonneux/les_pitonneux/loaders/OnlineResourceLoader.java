package com.pitonneux.les_pitonneux.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.pitonneux.les_pitonneux.ListItem;

import java.util.List;

/**
 * Created by androidweardev on 8/11/17.
 */

public class OnlineResourceLoader extends AsyncTaskLoader<List<ListItem>> {

    private String mUrl;

    public OnlineResourceLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    public List<ListItem> loadInBackground() {
        return null;
    }

    @Override
    protected void onStartLoading() {

        forceLoad();
    }


}
