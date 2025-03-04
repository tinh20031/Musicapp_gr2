package com.example.musicapp_gr2.entity;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ArtistResponse {
    @SerializedName("artists")
    private List<Artist> artists;

    // Constructor mặc định
    public ArtistResponse() {
    }

    // Constructor đầy đủ
    public ArtistResponse(List<Artist> artists) {
        this.artists = artists;
    }

    // Getters và Setters
    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }
}