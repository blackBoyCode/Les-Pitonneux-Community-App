package com.pitonneux.les_pitonneux;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.resource;
import static android.R.attr.text;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * Created by androidweardev on 6/2/17.
 */

public class ListItemAdapter extends ArrayAdapter<ListItem>{


    public ListItemAdapter(Context context,ArrayList<ListItem> listItem) {
        super(context,0,listItem);
    }

    /**
     * overiide and get the listItem view as well as assign id
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        //GET THE ITEM FIRST
        ListItem currentListItem = getItem(position);


        //this is were we assign the list item with there id s
        TextView headerTextView = (TextView) listItemView.findViewById(R.id.header_text_view);
        headerTextView.setText(currentListItem.getHeader());



        TextView shortDescriptionTextView = (TextView) listItemView.findViewById(R.id.description_text_view);
        shortDescriptionTextView.setText(currentListItem.getDescription());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.main_image);


        TextView dayTextView = (TextView) listItemView.findViewById(R.id.day_text_view);


        TextView monthTextView = (TextView) listItemView.findViewById(R.id.month_text_view);


        if(currentListItem.hasDate()){

            dayTextView.setText(currentListItem.getDay());

            monthTextView.setText(currentListItem.getMonth());

            dayTextView.setVisibility(View.VISIBLE);
            monthTextView.setVisibility(View.VISIBLE);

        }else{

            dayTextView.setVisibility(View.GONE);
            monthTextView.setVisibility(View.GONE);

        }


        if(currentListItem.hasImage()){

            imageView.setImageResource(currentListItem.getImageResource());

            //since were recycling views we need to make sure that the next one use is visible
            imageView.setVisibility(View.VISIBLE);

        }else{

            //if the activity has no image that set it to  gone so that it will be invisible and won't take up space
            imageView.setVisibility(View.GONE);

        }





        return listItemView ;
    }
}
