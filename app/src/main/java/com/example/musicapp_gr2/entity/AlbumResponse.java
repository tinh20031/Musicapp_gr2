package com.example.musicapp_gr2.entity;

import java.util.List;
import java.util.Map;
import com.google.gson.annotations.SerializedName;

public class AlbumResponse {
    @SerializedName("albums")
    private Albums albums;

    public Albums getAlbums() {
        return albums;
    }

    public void setAlbums(Albums albums) {
        this.albums = albums;
    }

    public static class Albums {
        @SerializedName("items")
        private List<AlbumItem> items;

        public List<AlbumItem> getItems() {
            return items;
        }

        public void setItems(List<AlbumItem> items) {
            this.items = items;
        }
    }

    public static class AlbumItem {
        private String id; // Đảm bảo có trường id
        private String name;
        private String release_date;
        private int total_tracks;
        @SerializedName("external_urls")
        private Map<String, String> externalUrls;
        @SerializedName("images")
        private List<Image> images;
        @SerializedName("artists")
        private List<Artist> artists;

        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        public String getName() { return name; }
        public String getReleaseDate() { return release_date; }
        public int getTotalTracks() { return total_tracks; }
        public String getSpotifyUrl() { return externalUrls.get("spotify"); }
        public String getImageUrl() { return images != null && !images.isEmpty() ? images.get(0).getUrl() : ""; }
        public String getArtist() { return artists != null && !artists.isEmpty() ? artists.get(0).getName() : ""; }

        public static class Image {
            private String url;
            public String getUrl() { return url; }
        }

        public static class Artist {
            private String name;
            public String getName() { return name; }
        }
    }
}