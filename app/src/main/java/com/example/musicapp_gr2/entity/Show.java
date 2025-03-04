package com.example.musicapp_gr2.entity;

import java.util.List;
import java.util.Map;
import com.google.gson.annotations.SerializedName;

public class Show {
    private String id;
    private String name;
    @SerializedName("external_urls")
    private Map<String, String> externalUrls;
    @SerializedName("images")
    private List<Image> images;
    private String description;
    private boolean explicit;
    private List<String> languages;
    private String publisher;
    private int total_episodes;

    // Constructor mặc định (yêu cầu cho Gson)
    public Show() {
    }

    // Constructor đầy đủ
    public Show(String id, String name, Map<String, String> externalUrls, List<Image> images,
                String description, boolean explicit, List<String> languages, String publisher,
                int total_episodes) {
        this.id = id;
        this.name = name;
        this.externalUrls = externalUrls;
        this.images = images;
        this.description = description;
        this.explicit = explicit;
        this.languages = languages;
        this.publisher = publisher;
        this.total_episodes = total_episodes;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getImageUrl() { return images != null && !images.isEmpty() ? images.get(0).getUrl() : ""; }
    public String getDescription() { return description; }
    public boolean isExplicit() { return explicit; }
    public List<String> getLanguages() { return languages; }
    public String getPublisher() { return publisher; }
    public int getTotalEpisodes() { return total_episodes; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setExternalUrls(Map<String, String> externalUrls) { this.externalUrls = externalUrls; }
    public void setImages(List<Image> images) { this.images = images; }
    public void setDescription(String description) { this.description = description; }
    public void setExplicit(boolean explicit) { this.explicit = explicit; }
    public void setLanguages(List<String> languages) { this.languages = languages; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
    public void setTotalEpisodes(int total_episodes) { this.total_episodes = total_episodes; }

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