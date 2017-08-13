package com.pitonneux.les_pitonneux.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.pitonneux.les_pitonneux.ListItem;

import java.util.List;


/**
 * this class will be the loader for the dates of meetup or subscribed ones.
 */
//TODO this class will be
public class CalendarEventsLoader extends AsyncTaskLoader<List<ListItem>>{
    private String meetupUrl;

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    public CalendarEventsLoader(Context context, String url) {
        super(context);

        meetupUrl = url;

    }

    @Override
    public List<ListItem> loadInBackground() {
        return null;
    }
}
