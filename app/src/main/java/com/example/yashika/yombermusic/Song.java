package com.example.yashika.yombermusic;

public class Song {

    /**
     * Title for the song
     */
    private String mSongTitle;
    /**
     * Artist for the song
     */
    private String mSongArtist;
    /**
     * Time for the song
     */
    private String mSongTime;
    /**
     * Audio resource ID for the song
     */
    private int mSongResourceId;


    /**
     * Create a new Song object.
     *
     * @param songTitle      is the song name
     * @param songArtist     is the name of song artist
     * @param songTime       is the time of the song
     * @param songResourceId is the resource id of song
     */
    public Song(String songTitle, String songArtist, String songTime, int songResourceId) {
        mSongTitle = songTitle;
        mSongArtist = songArtist;
        mSongTime = songTime;
        mSongResourceId = songResourceId;
    }

    /**
     * Get the name of the song.
     */
    public String getSongTitle() {
        return mSongTitle;
    }

    /**
     * Get the artist name of the song.
     */
    public String getSongArtist() {
        return mSongArtist;
    }

    /**
     * Get the time of the song.
     */
    public String getSongTime() {
        return mSongTime;
    }

    /**
     * Get the resource id of the song
     */
    public int getSongResourceId() {
        return mSongResourceId;
    }

}
