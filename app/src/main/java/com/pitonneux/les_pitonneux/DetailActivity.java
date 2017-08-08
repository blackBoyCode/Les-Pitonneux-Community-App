package com.pitonneux.les_pitonneux;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;



public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //TODO will need an intent to pass in information from the JSON


        //set the toolbar
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //TODO: must fix the theme color to that is apply to this line of code
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("$ DigiLabs-MTL█");


        //set the title on the CollapsingToolBarLayout instead of the Toolbar.
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        //collapsingToolbar.setTitle("DigiLabs");

        ImageView logoImage = (ImageView) findViewById(R.id.logo_image);
        logoImage.setImageResource(R.drawable.digi_lab);

        //set the description cardView
        TextView cardDescription = (TextView) findViewById(R.id.description);
        cardDescription.setText("From cellphones to coffee makers, almost any electronic device with an on/off switch can be connected to the Internet. The Internet of Things (IoT) hands-on workshop is an amazing opportunity to learn how to build your own IoT device accessible through the cloud, coded in the Arduino programming language.");

       // TextView cardContact = (TextView) findViewById(R.id.contact);

        //set the contact cardView content
        TextView locationLink = (TextView) findViewById(R.id.location);
        locationLink.setText("51 Sherbrooke st. West, suite #5\n" +
                "Montreal, Quebec H2X 1X2");

        TextView meetupLink = (TextView) findViewById(R.id.meetup);
        meetupLink.setText("https://www.meetup.com/fr-FR/FPGA-Academy/");

        TextView emailLink = (TextView) findViewById(R.id.email);
        emailLink.setText("digilabsmtl.iotws@gmail.com");

        TextView facebookLink = (TextView) findViewById(R.id.facebook);
        facebookLink.setText("https://www.facebook.com/pages/DigiLabs-MTL/135945533603038");

        //set the message cardView
        TextView cardMessages = (TextView) findViewById(R.id.message);
        cardMessages.setText("Come share your experiences and learn FPGA design in a collaborative climate.");

        TextView twitterLink = (TextView) findViewById(R.id.twitter);
        twitterLink.setText("twitter.com/?");

        TextView slackLink = (TextView) findViewById(R.id.slack);
        slackLink.setText("digilabs-mtl.slack.com");
    }


}
