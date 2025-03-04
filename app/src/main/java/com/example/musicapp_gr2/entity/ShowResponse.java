package com.example.musicapp_gr2.entity;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ShowResponse {
    @SerializedName("shows")
    private List<Show> shows;

    // Constructor mặc định
    public ShowResponse() {
    }

    // Constructor đầy đủ
    public ShowResponse(List<Show> shows) {
        this.shows = shows;
    }

    // Getters và Setters
    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }
}