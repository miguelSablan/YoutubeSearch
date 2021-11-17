package com.example.youtubetest.models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    String videoId;
    String title;
    String thumbnail;

    public Movie(JSONObject jsonObject) throws JSONException {
        videoId = jsonObject.getJSONObject("id").getString("videoId");
        Log.i("Video ID", videoId);
        title = jsonObject.getJSONObject("snippet").getString("title");
        Log.i("Title", title);
        thumbnail = jsonObject.getJSONObject("snippet").getJSONObject("thumbnails").getJSONObject("medium").getString("url");
        Log.i("Thumbnail", thumbnail);
    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for(int i = 0; i < movieJsonArray.length(); i++){
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getVideoId() {
        return videoId;
    }

    public String getTitle() {
        return title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

}
