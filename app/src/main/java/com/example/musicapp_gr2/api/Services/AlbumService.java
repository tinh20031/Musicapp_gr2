package com.example.musicapp_gr2.api.Services;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AlbumService {

    @GET("api/Api_Album/album")
    Call<Map<String, Object>> getAlbum(@Query("albumId") String albumId);

    @GET("api/Api_Album/album/new release")
    Call<Map<String, Object>> getNewReleases();
}
