package com.akgarg.ipldashboard.data;

import com.akgarg.ipldashboard.model.Match;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;

/**
 * Author: Akhilesh Garg
 */
@SuppressWarnings("unused")
public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

    @Override
    public Match process(MatchInput matchInput) throws Exception {
        Match match = new Match();
        match.setId(Long.parseLong(matchInput.getId()));
        match.setCity(matchInput.getCity());
        match.setDate(LocalDate.parse(matchInput.getDate()));
        match.setPlayerOfMatch(matchInput.getPlayer_of_match());
        match.setVenue(matchInput.getVenue());

        // set teamOne and teamTwo depending on the who plays first inning
        String firstInningsTeam;
        String secondInningsTeam;

        if (matchInput.getToss_decision().equals("bat")) {
            firstInningsTeam = matchInput.getToss_winner();
            secondInningsTeam = matchInput.getToss_winner().equals(matchInput.getTeam1()) ?
                    matchInput.getTeam2() : matchInput.getTeam1();
        } else {
            firstInningsTeam = matchInput.getToss_winner().equals(matchInput.getTeam1()) ?
                    matchInput.getTeam2() : matchInput.getTeam1();
            secondInningsTeam = matchInput.getToss_winner();
        }
        match.setTeamOne(firstInningsTeam);
        match.setTeamTwo(secondInningsTeam);

        match.setTossWinner(matchInput.getToss_winner());
        match.setTossDecision(matchInput.getToss_decision());
        match.setMatchWinner(matchInput.getWinner());
        match.setResult(matchInput.getResult());
        match.setResultMargin(matchInput.getResult_margin());
        match.setUmpireOne(matchInput.getUmpire1());
        match.setUmpireTwo(matchInput.getUmpire2());

        return match;
    }
}