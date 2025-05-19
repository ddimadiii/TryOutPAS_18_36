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

public class AdapterRVEnglish extends RecyclerView.Adapter<AdapterRVEnglish.AdapterHolder> {
    private List<DataModel.Teams> team;

    public AdapterRVEnglish(List<DataModel.Teams> team) {
        this.team = team;
    }

    @NonNull
    @Override
    public AdapterRVEnglish.AdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.english_league_item, parent, false);
        return new AdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRVEnglish.AdapterHolder holder, int position) {
        DataModel.Teams teams = team.get(position);
        holder.tvStrTeamm.setText(teams.getStrTeam());
        Glide.with(holder.imgStrBadge.getContext())
                .load(teams.getStrBadge())
                .into(holder.imgStrBadge);
    }

    @Override
    public int getItemCount() {
        return team.size();
    }

    public class AdapterHolder extends RecyclerView.ViewHolder {
        TextView tvStrTeamm;
        ImageView imgStrBadge;
        public AdapterHolder(@NonNull View itemView) {
            super(itemView);
            tvStrTeamm = itemView.findViewById(R.id.tvStrTeam);
            imgStrBadge = itemView.findViewById(R.id.imgStrBadge);
        }
    }
}
