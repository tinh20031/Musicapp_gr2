package com.example.musicapp_gr2.api.Services;

import java.util.Map;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ArtistService {
    // Lấy thông tin nghệ sĩ theo ID
    @GET("api/Api_Artist/artist")
    Call<Map<String, Object>> getArtist(@Query("artistId") String artistId);

    // Lấy bài hát hay nhất của nghệ sĩ theo ID
    @GET("api/Api_Artist/top-tracks")
    Call<Map<String, Object>> getArtistTopTracks(@Query("artistId") String artistId, @Query("market") String market);

    // Lấy nhiều nghệ sĩ cùng lúc (sử dụng POST)
    @POST("api/spotify/MultiArtist") // Khớp với endpoint C#
    Call<Map<String, Object>> getMultipleArtists(@Body List<String> artistIds);
}