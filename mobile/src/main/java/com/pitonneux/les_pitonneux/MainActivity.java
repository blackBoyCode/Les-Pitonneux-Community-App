package com.pitonneux.les_pitonneux;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;



import static android.R.attr.id;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);// THIS IS A TEST

        getSupportActionBar().setTitle("$ news_feed█");
        //open the fragment NewsContent when first launching the activity
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new NewsFragment()).commit();


        //set the bottom navigation and find the view id from the layout
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        //set the navigation when an item is clicked
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








}
