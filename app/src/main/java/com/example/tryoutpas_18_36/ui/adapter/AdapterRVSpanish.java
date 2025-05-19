package com.example.tryoutpas_18_36.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tryoutpas_18_36.R;
import com.example.tryoutpas_18_36.data.model.DataModel;

import java.util.List;

public class AdapterRVSpanish extends RecyclerView.Adapter<AdapterRVSpanish.AdapterHolder> {
    private List<DataModel.Teams> team;

    public AdapterRVSpanish(List<DataModel.Teams> team) {
        this.team = team;
    }

    @NonNull
    @Override
    public AdapterRVSpanish.AdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.spanish_league_item, parent, false);
        return new AdapterRVSpanish.AdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRVSpanish.AdapterHolder holder, int position) {
        DataModel.Teams teams = team.get(position);
        holder.tvStrTeam.setText(teams.getStrTeam());
        Glide.with(holder.imgStrBadge.getContext())
                .load(teams.getStrBadge())
                .into(holder.imgStrBadge);
    }

    @Override
    public int getItemCount() {
        return team.size();
    }

    public class AdapterHolder extends RecyclerView.ViewHolder {
        TextView tvStrTeam;
        ImageView imgStrBadge;
        public AdapterHolder(@NonNull View itemView) {
            super(itemView);
            tvStrTeam = itemView.findViewById(R.id.tvStrTeam);
            imgStrBadge = itemView.findViewById(R.id.imgStrBadge);
        }
    }

}
