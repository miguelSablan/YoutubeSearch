package com.example.youtubetest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youtubetest.adapters.recyclerAdapter;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;

public class MainActivity extends YouTubeBaseActivity {
    private ArrayList<Music> musicList;
    private RecyclerView recyclerView;
    private ImageButton searchBtn;

    String api_key = "AIzaSyDdovNZk5iCKc_lOSvk3mpiEi6Lf0qANbk";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        musicList = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.musicPlaylist);

        searchBtn = (ImageButton) findViewById(R.id.searchBtn);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSearchActivity();
            }
        });

        // Get reference to the view of Video player
        YouTubePlayerView ytPlayer = (YouTubePlayerView)findViewById(R.id.ytPlayer);

        ytPlayer.initialize(api_key, new YouTubePlayer.OnInitializedListener() {
            // Implement two methods by clicking on red
            // error bulb inside onInitializationSuccess
            // method add the video link or the playlist
            // link that you want to play In here we
            // also handle the play and pause
            // functionality
            @Override
            public void onInitializationSuccess(
                    YouTubePlayer.Provider provider,
                    YouTubePlayer youTubePlayer, boolean b)
            {
                youTubePlayer.loadVideo(getVideoNumber());
                youTubePlayer.play();
            }
            // Inside onInitializationFailure
            // implement the failure functionality
            // Here we will show toast
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                        Toast.makeText(getApplicationContext(), "Video player Failed", Toast.LENGTH_SHORT).show();
            }

            public String getVideoNumber(){
                //ArrayList

                return "8OkpRK2_gVs";
            };
        });

        setMusicInfo();
        setAdapter();
    }

    private void setAdapter() {
        recyclerAdapter adapter = new recyclerAdapter(musicList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setMusicInfo() {
        musicList.add(new Music("Dillon Francis: Follow me"));
        musicList.add(new Music("Bad Bunny: Dikiti"));
        musicList.add(new Music("Kanye: Yeezy"));
    }

    public void openSearchActivity(){
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }
}