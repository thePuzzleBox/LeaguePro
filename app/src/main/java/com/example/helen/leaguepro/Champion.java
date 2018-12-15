package com.example.helen.leaguepro;

import android.media.MediaPlayer;
import android.widget.Toast;

public class Champion {
    private final String name;
    private final String alias;
    private final String bio;
    private final String url;
    private boolean isFavorite = false;
    private final int imageResource;
    private final int background;
    private final int lineResource;


    public Champion(String name, String alias, String url, int imageResource, int background, int lineResource, String bio) {
        this.name = name;
        this.alias = alias;
        this.url = url;
        this.imageResource = imageResource;
        this.background = background;
        this.lineResource = lineResource;
        this.bio = bio;

    }


    public String getName() {
        return name;
    }

    public String getAlias(){
        return alias;
    }

    public String getBio() {
        return bio;
    }

    public String getLink() {
        return url;
    }

    public boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public void toggleFavorite() {
        isFavorite = !isFavorite;
    }

    public int getImageResource() {
        return imageResource;
    }

    public int getLineResource() {
        return lineResource;
    }

    public int getBackground() {
        return background;
    }
}
