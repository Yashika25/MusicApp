package com.example.yashika.yombermusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class YomberSongs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yomber_songs);

        Button songs_list = (Button) findViewById(R.id.goto_list);
        songs_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Create a new intent to open the {@link ListActivity} layout file
                Intent songsIntent = new Intent(YomberSongs.this, MainActivity.class);

                //Start the new activity
                startActivity(songsIntent);
                finish();
            }

        });
    }
}
