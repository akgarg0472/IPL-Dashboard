package com.akgarg.ipldashboard.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Author: Akhilesh Garg
 */
@SuppressWarnings("unused")
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String teamName;
    private long totalMatchesPlayed;
    private long totalWins;

    public Team() {
    }

    public Team(String teamName, long totalMatchesPlayed) {
        this.teamName = teamName;
        this.totalMatchesPlayed = totalMatchesPlayed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public long getTotalMatchesPlayed() {
        return totalMatchesPlayed;
    }

    public void setTotalMatchesPlayed(long totalMatchedPlayed) {
        this.totalMatchesPlayed = totalMatchedPlayed;
    }

    public long getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(long totalWins) {
        this.totalWins = totalWins;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", teamName='" + teamName + '\'' +
                ", totalMatchesPlayed=" + totalMatchesPlayed +
                ", totalWins=" + totalWins +
                '}';
    }
}