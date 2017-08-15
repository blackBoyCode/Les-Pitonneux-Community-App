package com.pitonneux.les_pitonneux.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.pitonneux.les_pitonneux.ListItem;
import com.pitonneux.les_pitonneux.ListItemAdapter;
import com.pitonneux.les_pitonneux.QueryUtils;

import java.util.List;

/**
 * Created by androidweardev on 8/11/17.
 */

public class LocalResourceLoader extends AsyncTaskLoader<List<ListItem>>{

    private String mUrl;

    public LocalResourceLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<ListItem> loadInBackground() {
        return QueryUtils.fetchListItemData(mUrl);
    }
}
