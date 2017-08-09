package com.pitonneux.les_pitonneux;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.pitonneux.les_pitonneux.fragments.resource_sub_fragments.LocalResourceFragment;
import com.pitonneux.les_pitonneux.fragments.resource_sub_fragments.OnlineResourceFragment;


/**
 * Created by androidweardev on 5/27/17.
 *
 * this adapter manage sub Fragments of the View pager
 * (OnlineResource and LocalResouce)
 */

public class ResourceAdapter extends FragmentPagerAdapter {


    private Context context;
    private String[] tabTitle  = new String[] {"Local","Online"};

    public ResourceAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new LocalResourceFragment();
        }else{
            return new OnlineResourceFragment();
        }

    }

    @Override
    public int getCount() {
        //return the number of fragment (counting zero too)
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        //return tabTitle based off the element position
        return tabTitle[position];
    }
}
