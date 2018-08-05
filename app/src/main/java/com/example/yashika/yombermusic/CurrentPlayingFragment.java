package com.example.yashika.yombermusic;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentPlayingFragment extends Fragment {

    Toast toast;

    public CurrentPlayingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_current_playing, container, false);

        int getAudioResource;

        final Button playButton = (Button) rootView.findViewById(R.id.play_view);

        if (toast != null) {
            toast.cancel();
        }

        toast = Toast.makeText(getActivity(), "Playing your song!", Toast.LENGTH_SHORT);
        toast.show();
        playButton.setText(getString(R.string.pause));

        //Set a click listener on the view
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (toast != null) {
                    toast.cancel();
                }
                if (playButton.getText() == getString(R.string.play)) {
                    toast = Toast.makeText(getActivity(), "Playing your song!", Toast.LENGTH_SHORT);
                    toast.show();
                    playButton.setText(getString(R.string.pause));
                } else if (playButton.getText() == getString(R.string.pause)) {
                    toast = Toast.makeText(getActivity(), "Paused your song!", Toast.LENGTH_SHORT);
                    toast.show();
                    playButton.setText(getString(R.string.play));
                }
            }
        });

        Button previousButton = (Button) rootView.findViewById(R.id.previous_view);

        //Set a click listener on the view
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toast != null) {
                    toast.cancel();
                }
                toast = Toast.makeText(getActivity(), "Playing previous song!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        Button nextButton = (Button) rootView.findViewById(R.id.next_view);

        //Set a click listener on the view
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toast != null) {
                    toast.cancel();
                }
                toast = Toast.makeText(getActivity(), "Playing next song!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        return rootView;
    }

}
