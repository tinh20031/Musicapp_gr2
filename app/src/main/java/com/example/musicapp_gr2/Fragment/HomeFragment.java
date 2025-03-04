package com.example.musicapp_gr2.Fragment;



import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp_gr2.R;
import com.example.musicapp_gr2.api.RetrofitClient;
import com.example.musicapp_gr2.api.Services.AlbumService;
import com.example.musicapp_gr2.api.Services.ArtistService;
import com.example.musicapp_gr2.api.Services.ShowService;
import com.example.musicapp_gr2.api.adapter.AlbumAdapter;
import com.example.musicapp_gr2.api.adapter.ArtistAdapter;
import com.example.musicapp_gr2.api.adapter.ShowAdapter;
import com.example.musicapp_gr2.entity.Album;
import com.example.musicapp_gr2.entity.AlbumResponse;
import com.example.musicapp_gr2.entity.Artist;
import com.example.musicapp_gr2.entity.ArtistResponse;
import com.example.musicapp_gr2.entity.Show;
import com.example.musicapp_gr2.entity.ShowResponse;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private RecyclerView albumRecyclerView;
    private RecyclerView artistRecyclerView;
    private RecyclerView showRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Khởi tạo RecyclerView
        albumRecyclerView = view.findViewById(R.id.albumRecyclerView);
        albumRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        artistRecyclerView = view.findViewById(R.id.artistRecyclerView);
        artistRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        showRecyclerView = view.findViewById(R.id.showRecyclerView);
        showRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        fetchData();
    }

    private void fetchData() {
        AlbumService albumService = RetrofitClient.getClient("https://10.0.2.2:7110/")
                .create(AlbumService.class);
        ArtistService artistService = RetrofitClient.getClient("https://10.0.2.2:7110/")
                .create(ArtistService.class);
        ShowService showService = RetrofitClient.getClient("https://10.0.2.2:7110/")
                .create(ShowService.class);

        // Lấy album mới phát hành
        albumService.getNewReleases().enqueue(new Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
                Log.d("API_DEBUG", "Calling: " + call.request().url());
                if (response.isSuccessful() && response.body() != null) {
                    Gson gson = new Gson();
                    String jsonString = gson.toJson(response.body());
                    AlbumResponse albumResponse = gson.fromJson(jsonString, AlbumResponse.class);

                    if (albumResponse != null && albumResponse.getAlbums() != null &&
                            albumResponse.getAlbums().getItems() != null) {
                        List<AlbumResponse.AlbumItem> albumItems = albumResponse.getAlbums().getItems();
                        List<Album> albums = new ArrayList<>();
                        for (AlbumResponse.AlbumItem item : albumItems) {
                            albums.add(new Album(
                                    item.getName(),
                                    item.getReleaseDate(),
                                    item.getArtist(),
                                    item.getTotalTracks(),
                                    item.getImageUrl(),
                                    item.getSpotifyUrl(),
                                    item.getId()
                            ));
                        }
                        AlbumAdapter albumAdapter = new AlbumAdapter();
                        albumAdapter.updateData(albums);
                        albumRecyclerView.setAdapter(albumAdapter);
                    } else {
                        Log.e("API_ERROR", "No albums found in response");
                    }
                } else {
                    Log.e("API_ERROR", "Response not successful: " + response.code() + " - " + response.message());
                }
            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                Log.e("API_ERROR", "Error: " + t.getMessage());
            }
        });

        // Lấy danh sách nghệ sĩ
        List<String> artistIds = new ArrayList<>();
        artistIds.add("2CIMQHirSU0MQqyYHq0eOx");
        artistIds.add("57dN52uHvrHOxijzpIgu3E");

        artistService.getMultipleArtists(artistIds).enqueue(new Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
                Log.d("API_DEBUG", "Calling: " + call.request().url());
                if (response.isSuccessful() && response.body() != null) {
                    Gson gson = new Gson();
                    String jsonString = gson.toJson(response.body());
                    ArtistResponse artistResponse = gson.fromJson(jsonString, ArtistResponse.class);

                    if (artistResponse != null && artistResponse.getArtists() != null) {
                        List<Artist> artists = artistResponse.getArtists();
                        ArtistAdapter artistAdapter = new ArtistAdapter();
                        artistAdapter.updateData(artists);
                        artistRecyclerView.setAdapter(artistAdapter);
                    } else {
                        Log.e("API_ERROR", "No artists found in response");
                    }
                } else {
                    Log.e("API_ERROR", "Response not successful: " + response.code() + " - " + response.message());
                }
            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                Log.e("API_ERROR", "Error: " + t.getMessage());
            }
        });

        // Lấy danh sách podcast
        List<String> showIds = new ArrayList<>();
        showIds.add("1p2OWJdy28dspUJd1ORPBj");

        showService.getMultiplePodcasts(showIds).enqueue(new Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
                Log.d("API_DEBUG", "Calling: " + call.request().url());
                if (response.isSuccessful() && response.body() != null) {
                    Gson gson = new Gson();
                    String jsonString = gson.toJson(response.body());
                    ShowResponse showResponse = gson.fromJson(jsonString, ShowResponse.class);

                    if (showResponse != null && showResponse.getShows() != null) {
                        List<Show> shows = showResponse.getShows();
                        ShowAdapter showAdapter = new ShowAdapter();
                        showAdapter.updateData(shows);
                        showRecyclerView.setAdapter(showAdapter);
                    } else {
                        Log.e("API_ERROR", "No shows found in response");
                    }
                } else {
                    Log.e("API_ERROR", "Response not successful: " + response.code() + " - " + response.message());
                }
            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                Log.e("API_ERROR", "Error: " + t.getMessage());
            }
        });
    }
}