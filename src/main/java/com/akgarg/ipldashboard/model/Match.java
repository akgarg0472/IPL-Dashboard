package com.akgarg.ipldashboard.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Author: Akhilesh Garg
 */
@SuppressWarnings("unused")
@Entity
public class Match {

    @Id
    private long id;
    private String city;
    private LocalDate date;
    private String playerOfMatch;
    private String venue;
    private String teamOne;
    private String teamTwo;
    private String tossWinner;
    private String tossDecision;
    private String matchWinner;
    private String result;
    private String resultMargin;
    private String umpireOne;
    private String umpireTwo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPlayerOfMatch() {
        return playerOfMatch;
    }

    public void setPlayerOfMatch(String playerOfMatch) {
        this.playerOfMatch = playerOfMatch;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getTeamOne() {
        return teamOne;
    }

    public void setTeamOne(String teamOne) {
        this.teamOne = teamOne;
    }

    public String getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(String teamTwo) {
        this.teamTwo = teamTwo;
    }

    public String getTossWinner() {
        return tossWinner;
    }

    public void setTossWinner(String tossWinner) {
        this.tossWinner = tossWinner;
    }

    public String getTossDecision() {
        return tossDecision;
    }

    public void setTossDecision(String tossDecision) {
        this.tossDecision = tossDecision;
    }

    public String getMatchWinner() {
        return matchWinner;
    }

    public void setMatchWinner(String matchWinner) {
        this.matchWinner = matchWinner;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResultMargin() {
        return resultMargin;
    }

    public void setResultMargin(String resultMargin) {
        this.resultMargin = resultMargin;
    }

    public String getUmpireOne() {
        return umpireOne;
    }

    public void setUmpireOne(String umpireOne) {
        this.umpireOne = umpireOne;
    }

    public String getUmpireTwo() {
        return umpireTwo;
    }

    public void setUmpireTwo(String umpireTwo) {
        this.umpireTwo = umpireTwo;
    }
}