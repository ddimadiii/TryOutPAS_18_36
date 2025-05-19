package com.example.tryoutpas_18_36.data.network;

import com.example.tryoutpas_18_36.data.model.DataModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("search_all_teams.php?l=English%20Premier%20League")
    Call<DataModel> getEnglishLeague();
}
