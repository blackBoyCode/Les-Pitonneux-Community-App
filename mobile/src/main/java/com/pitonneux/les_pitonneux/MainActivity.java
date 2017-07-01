package com.pitonneux.les_pitonneux;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private ActionBarDrawerToggle toggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //TODO:THIS IS FOR GOING ON THE CATEGORY ACTIVITY FIRST INSTEAD OF PASSING IN THE SIGN IN PART
        setContentView(R.layout.activity_test);// THIS IS A TEST //TODO: build a new activity for this part

        //TODO:I should add a custom toolbar to support older version of android
        setUpActionBar();

        //TODO: is there a more elegant way for not repeating this line of code?
        getSupportActionBar().setTitle("$ news_feed█");
        //open the fragment NewsContent when first launching the activity
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new NewsFragment()).commit();


        //set the bottom navigation and find the view id from the layout
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.removeShiftMode(bottomNavigationView);

        //TODO: animate action bar title maybe the use of TextSwitcher


        //???
        bottomNavigationView.setSelectedItemId(R.id.action_news_feeds);

        //set the navigation category when an item is clicked
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_news_feeds:
                        // do something here
                        getSupportActionBar().setTitle("$ news_feed█");
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new NewsFragment()).commit();
                        return true;
                    case R.id.action_calendar:
                        // do something here
                        getSupportActionBar().setTitle("$ calendar█");
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new CalendarFragment()).commit();
                        return true;
                    case R.id.action_code_support:
                        // do something here
                        getSupportActionBar().setTitle("$ code_support█");
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new CodeHelpFragment()).commit();
                        return true;
                    default:
                        // do something here
                        getSupportActionBar().setTitle("$ resources█");
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new ResourceFragment()).commit();
                        return true;
                }
            }
        });

    }


    /**
     * this method setup the drawer icon
     */
    private void setUpActionBar() {

        //SET THE HAMBURGER ICON TO BE VISIBLE
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);


        toggle = new ActionBarDrawerToggle(this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

            private CharSequence saveTitle = "";

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(saveTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                saveTitle = getSupportActionBar().getTitle();
                getSupportActionBar().setTitle("$ profile█");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }


        };

        drawer.addDrawerListener(toggle);///TODO:  drawer.setDrawerListener(toggle); same but works WHY?
        //THIS IS IMPORTANT TO NOTIFY THE DRAWER OF ANY CHANGE
        toggle.syncState();


//
//        //SET ITEM LISTENER FOR DRAWER ITEMS
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);


    }


    ///TODO:this is important //Need to understand this code better ?
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //this handle the back pressed button with the drawer action
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    /**
     * TODO: this is a test method for adding a custom view to the actionBar....
     */
    public void SetupCustomActionBarTitle() {

        TextView x = new TextView(this);
        x.setTextSize(20);


        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setCustomView(x);
        getSupportActionBar().setDisplayShowCustomEnabled(true);


    }


}
