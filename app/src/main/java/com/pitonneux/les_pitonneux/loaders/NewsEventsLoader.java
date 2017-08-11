package com.pitonneux.les_pitonneux.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.pitonneux.les_pitonneux.ListItem;
import com.pitonneux.les_pitonneux.QueryUtils;

import java.util.List;

/**
 * Created by androidweardev on 8/9/17.
 */

public class NewsEventsLoader extends AsyncTaskLoader<List<ListItem>> {

    private String mUrl;

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    public NewsEventsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    public List<ListItem> loadInBackground() {

        if(mUrl == null){
            return null;
        }

        return QueryUtils.fetchListItemData(mUrl);
    }
}
