package com.example.yashika.yombermusic;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class GridFragment extends Fragment {

    Toast toast;
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
    AudioManager.OnAudioFocusChangeListener changeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    public GridFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(changeListener);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_albumn_grid, container, false);

        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(getActivity(), "Welcome to the Yomber Albumn!", Toast.LENGTH_SHORT);
        toast.show();

        //Creating an ArrayList for Songs
        final ArrayList<Song> songs = new ArrayList<com.example.yashika.yombermusic.Song>();
        songs.add(new Song(getString(R.string.song1), getString(R.string.artist1), getString(R.string.time1), R.raw.helplessly));
        songs.add(new Song(getString(R.string.song2), getString(R.string.artist2), getString(R.string.time2), R.raw.friends));
        songs.add(new Song(getString(R.string.song3), getString(R.string.artist3), getString(R.string.time3), R.raw.thinkingboutyou));
        songs.add(new Song(getString(R.string.song4), getString(R.string.artist4), getString(R.string.time4), R.raw.somethinglikethis));
        songs.add(new Song(getString(R.string.song5), getString(R.string.artist5), getString(R.string.time5), R.raw.newrules));
        songs.add(new Song(getString(R.string.song6), getString(R.string.artist6), getString(R.string.time6), R.raw.look));
        songs.add(new Song(getString(R.string.song7), getString(R.string.artist7), getString(R.string.time7), R.raw.itaintme));
        songs.add(new Song(getString(R.string.song8), getString(R.string.artist8), getString(R.string.time8), R.raw.staylillonger));
        songs.add(new Song(getString(R.string.song9), getString(R.string.artist9), getString(R.string.time9), R.raw.openeyes));
        songs.add(new Song(getString(R.string.song10), getString(R.string.artist10), getString(R.string.time10), R.raw.wherewe));
        songs.add(new Song(getString(R.string.song11), getString(R.string.artist11), getString(R.string.time11), R.raw.justmissingyou));
        songs.add(new Song(getString(R.string.song12), getString(R.string.artist12), getString(R.string.time12), R.raw.whatneedtosay));
        songs.add(new Song(getString(R.string.song13), getString(R.string.artist13), getString(R.string.time13), R.raw.stay));
        songs.add(new Song(getString(R.string.song14), getString(R.string.artist14), getString(R.string.time14), R.raw.aurora));
        songs.add(new Song(getString(R.string.song15), getString(R.string.artist15), getString(R.string.time15), R.raw.uffyehnoor));
        songs.add(new Song(getString(R.string.song16), getString(R.string.artist16), getString(R.string.time16), R.raw.khojaanede));
        songs.add(new Song(getString(R.string.song17), getString(R.string.artist17), getString(R.string.time17), R.raw.humsafar));
        songs.add(new Song(getString(R.string.song18), getString(R.string.artist18), getString(R.string.time18), R.raw.tamma));
        songs.add(new Song(getString(R.string.song19), getString(R.string.artist19), getString(R.string.time19), R.raw.sukoonmila));
        songs.add(new Song(getString(R.string.song20), getString(R.string.artist20), getString(R.string.time20), R.raw.afeemi));
        songs.add(new Song(getString(R.string.song21), getString(R.string.artist21), getString(R.string.time21), R.raw.safar));
        songs.add(new Song(getString(R.string.song22), getString(R.string.artist22), getString(R.string.time22), R.raw.shayrana));

        GridAdapter adapter = new GridAdapter(getActivity(), songs);
        GridView gridView = (GridView) rootView.findViewById(R.id.grid);
        gridView.setAdapter(adapter);

        //Setting on item click listener to play same sound on clicking any grid item
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Song song = songs.get(position);

                releaseMediaPlayer();

                int result = mAudioManager.requestAudioFocus(changeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(getActivity(), song.getSongResourceId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
        return rootView;
    }

}
