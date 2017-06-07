package com.pitonneux.les_pitonneux;

/**
 * Created by androidweardev on 6/2/17.
 */

public class ListItem {

    private String mHeader;
    private String mDescription;

    //this is for the calendar listView
    private String mMonth;
    private String mDay;


    //this is the image for local/Online Resource and User profile
    private int mImageResource = NO_IMAGE_PROVIDED;

    //TODO: need to review this and arrange it for month and day
    private static final int NO_IMAGE_PROVIDED = -1;

    private static final String NO_DATE_PROVIDED = null;




    /**
     * this constructor is for newsFeed listItem
     *
     * @param header
     * @param description
     */
    public ListItem(String header, String description) {
        this.mHeader = header;
        this.mDescription = description;

    }


    /**
     * this constructor is for
     * @param header
     * @param description
     * @param imageResource //TODO:profile image, image resource should change size for local/online resource
     */
    public ListItem(String header, String description, int imageResource) {

        this.mHeader = header;
        this.mDescription = description;
        this.mImageResource = imageResource;
    }


    /**
     * this is for date and the meetUp schedule
     * @param header
     * @param description
     * @param month
     * @param day
     */
    public ListItem(String header, String description, String month, String day) {
        this.mHeader = header;
        this.mDescription = description;
        this.mMonth = month;
        this.mDay = day;

    }



    public boolean hasImage(){

        return mImageResource != NO_IMAGE_PROVIDED;
    }

    public boolean hasDate(){
        //TODO: strange warning happening need more answer
        return mDay != NO_DATE_PROVIDED && mMonth != NO_DATE_PROVIDED;
    }














    public String getHeader() {
        return mHeader;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getMonth() {
        return mMonth;
    }

    public String getDay() {
        return mDay;
    }

    public int getImageResource() {
        return mImageResource;
    }



}
