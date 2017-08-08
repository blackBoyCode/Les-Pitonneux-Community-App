package com.pitonneux.les_pitonneux;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import static android.R.attr.x;

public class DetailActivity2ToErase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);



        //set the toolbar
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //TODO: must fix the theme color to that is apply to this line of code
        //TODO: BUG TO FIX BUTTON DOESN'T WORK
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("$ Pyladies█");


        //set the title on the CollapsingToolBarLayout instead of the Toolbar.
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        //collapsingToolbar.setTitle("DigiLabs");


        ImageView logoImage = (ImageView) findViewById(R.id.logo_image);
        logoImage.setImageResource(R.drawable.pyladies);

        //set the description cardView
        TextView cardDescription = (TextView) findViewById(R.id.description);
        cardDescription.setText("We are an international mentorship group with a focus on helping more women become active participants and leaders in the Python open-source community. Our mission is to promote, educate and advance a diverse Python community through outreach, education, conferences, events and social gatherings.\n" +
                "\n" +
                "PyLadies also aims to provide a friendly support network for women and a bridge to the larger Python world. Anyone with an interest in Python is encouraged to participate!");

        // TextView cardContact = (TextView) findViewById(R.id.contact);

        //set the contact cardView content
        TextView locationLink = (TextView) findViewById(R.id.location);
        locationLink.setText("The location is shown only to members. Join our meetup!");

        TextView meetupLink = (TextView) findViewById(R.id.meetup);
        meetupLink.setText("https://www.meetup.com/PyLadiesMTL/");

        TextView emailLink = (TextView) findViewById(R.id.email);
        emailLink.setText("montreal@pyladies.com");

        TextView facebookLink = (TextView) findViewById(R.id.facebook);
        facebookLink.setText("https://www.facebook.com/pyladies/");

        TextView twitterLink = (TextView) findViewById(R.id.twitter);
        twitterLink.setText("https://twitter.com/pyladiesmtl");

        TextView slackLink = (TextView) findViewById(R.id.slack);
        slackLink.setText("https://slackin.pyladies.com/");

        //set the message cardView
        TextView cardMessages = (TextView) findViewById(R.id.message);
        cardMessages.setText("Developers and aspiring developers only, please. (Beginners are always welcome!) Men are welcome as the guest (+1) of a woman attendee.");


    }
}
