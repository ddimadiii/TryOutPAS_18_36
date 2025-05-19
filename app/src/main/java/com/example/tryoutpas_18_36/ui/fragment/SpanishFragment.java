package com.example.tryoutpas_18_36.ui.fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tryoutpas_18_36.R;
import com.example.tryoutpas_18_36.data.model.DataModel;
import com.example.tryoutpas_18_36.data.network.APIService;
import com.example.tryoutpas_18_36.ui.adapter.AdapterRVSpanish;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SpanishFragment extends Fragment {
    RecyclerView rvSpanishLeague;
    AdapterRVSpanish adapter;
    private static final String BASE_URL = "https://www.thesportsdb.com/api/v1/json/3/";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_spanish, container, false);
        rvSpanishLeague = view.findViewById(R.id.rvSpanishLeague);
        rvSpanishLeague.setLayoutManager(new LinearLayoutManager(getContext()));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIService apiService = retrofit.create(APIService.class);

        Call<DataModel> call = apiService.getSpanishLeague();

        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                if (response.isSuccessful()) {
                    List<DataModel.Teams> teams = response.body().getTeams();
                    adapter = new AdapterRVSpanish(teams);
                    rvSpanishLeague.setAdapter(adapter);
                } else {
                    Log.e("Dashboard", response.message());
                }
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {
                Log.e("Dashboard",t.getMessage());
            }
        });
        return view;
    }
}
