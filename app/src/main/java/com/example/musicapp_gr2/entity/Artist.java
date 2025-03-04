package com.example.musicapp_gr2.entity;

import java.util.List;
import java.util.Map;
import com.google.gson.annotations.SerializedName;

public class Artist {
    private String id;
    private String name;
    @SerializedName("external_urls")
    private Map<String, String> externalUrls;
    @SerializedName("images")
    private List<Image> images;
    private int popularity;
    private List<String> genres;

    // Constructor mặc định (yêu cầu cho Gson)
    public Artist() {
    }

    // Constructor đầy đủ
    public Artist(String id, String name, Map<String, String> externalUrls, List<Image> images,
                  int popularity, List<String> genres) {
        this.id = id;
        this.name = name;
        this.externalUrls = externalUrls;
        this.images = images;
        this.popularity = popularity;
        this.genres = genres;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getImageUrl() { return images != null && !images.isEmpty() ? images.get(0).getUrl() : ""; }
    public int getPopularity() { return popularity; }
    public List<String> getGenres() { return genres; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setExternalUrls(Map<String, String> externalUrls) { this.externalUrls = externalUrls; }
    public void setImages(List<Image> images) { this.images = images; }
    public void setPopularity(int popularity) { this.popularity = popularity; }
    public void setGenres(List<String> genres) { this.genres = genres; }

    public static class Image {
        private String url;
        private int height;
        private int width;

        public String getUrl() { return url; }
        public void setUrl(String url) { this.url = url; }
        public int getHeight() { return height; }
        public void setHeight(int height) { this.height = height; }
        public int getWidth() { return width; }
        public void setWidth(int width) { this.width = width; }
    }
}