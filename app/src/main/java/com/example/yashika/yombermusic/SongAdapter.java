package com.example.yashika.yombermusic;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {
    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param songs   A List of AndroidFlavor objects to display in a list
     */
    public SongAdapter(Activity context, ArrayList<Song> songs) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Check if the existing view is being reused, otherwise inflate the view

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_list, parent, false);
        }

        // Get the {@link Song} object located at this position in the list
        Song currentSong = getItem(position);

        // Find the TextView in the activity_list.xml layout with the ID list_title
        TextView titleTextView = (TextView) convertView.findViewById(R.id.list_title);
        // Get the title name from the current Song object and
        // set this text on the title TextView
        titleTextView.setText(currentSong.getSongTitle());

        // Find the TextView in the activity_list.xml layout with the ID list_artist
        TextView artistTextView = (TextView) convertView.findViewById(R.id.list_artist);
        // Get the artist name from the current Song object and
        // set this text on the artist TextView
        artistTextView.setText(currentSong.getSongArtist());


        // Find the TextView in the activity_list.xml layout with the ID list_time
        TextView timeTextView = (TextView) convertView.findViewById(R.id.list_time);
        // Get the time limit from the current Song object and
        // set this text on the time TextView
        timeTextView.setText(currentSong.getSongTime());


        // Return the whole list item layout (containing 3 TextViews and 1 ImageView)
        // so that it can be shown in the ListView
        return convertView;
    }

}
