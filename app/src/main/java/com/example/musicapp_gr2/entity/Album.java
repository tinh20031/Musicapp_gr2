package com.example.musicapp_gr2.entity;

public class Album {
    private String name;
    private String releaseDate;
    private String artist;
    private int totalTracks;
    private String imageUrl;
    private String spotifyUrl;
    private String id;

    // Constructor
    public Album(String name, String releaseDate, String artist, int totalTracks,
                 String imageUrl, String spotifyUrl, String id) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.artist = artist;
        this.totalTracks = totalTracks;
        this.imageUrl = imageUrl;
        this.spotifyUrl = spotifyUrl;
        this.id = id;
    }

    // Getters
    public String getName() { return name; }
    public String getReleaseDate() { return releaseDate; }
    public String getArtist() { return artist; }
    public int getTotalTracks() { return totalTracks; }
    public String getImageUrl() { return imageUrl; }
    public String getSpotifyUrl() { return spotifyUrl; }
    public String getId() { return id; } // Thêm getter cho ID

    // Setters
    public void setName(String name) { this.name = name; }
    public void setReleaseDate(String releaseDate) { this.releaseDate = releaseDate; }
    public void setArtist(String artist) { this.artist = artist; }
    public void setTotalTracks(int totalTracks) { this.totalTracks = totalTracks; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public void setSpotifyUrl(String spotifyUrl) { this.spotifyUrl = spotifyUrl; }
    public void setId(String id) { this.id = id; } // Thêm setter cho ID
}