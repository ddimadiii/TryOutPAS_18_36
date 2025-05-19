package com.example.tryoutpas_18_36.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataModel {

    @SerializedName("teams")
    private List<Teams> teams;

    public DataModel(List<Teams> teams) {
        this.teams = teams;
    }

    public List<Teams> getTeams() {
        return teams;
    }

    public static class Teams {
        @SerializedName("strTeam")
        private String strTeam;

        @SerializedName("strBadge")
        private String strBadge;

        public String getStrTeam() {
            return strTeam;
        }

        public String getStrBadge() {
            return strBadge;
        }
    }
}
