package com.example.musicapp_gr2.api.Services;

import java.util.List;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ShowService {
    // Lấy một podcast theo ID
    @GET("api/spotify/podcast")
    Call<Map<String, Object>> getShow(@Query("PodCastId") String podCastId);

    // Lấy nhiều podcast cùng lúc
    @POST("api/spotify/MultiPodcast")
    Call<Map<String, Object>> getMultiplePodcasts(@Body List<String> podCastIds);
}