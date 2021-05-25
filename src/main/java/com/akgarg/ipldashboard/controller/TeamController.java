package com.akgarg.ipldashboard.controller;

import com.akgarg.ipldashboard.model.Match;
import com.akgarg.ipldashboard.model.Team;
import com.akgarg.ipldashboard.repository.MatchRepository;
import com.akgarg.ipldashboard.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Author: Akhilesh Garg
 */
@SuppressWarnings("unsued")
@RestController
@CrossOrigin
public class TeamController {

    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;

    @Autowired
    public TeamController(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }


    @RequestMapping(value = "/team/{teamName}", method = RequestMethod.GET)
    public Team getTeam(@PathVariable("teamName") String teamName) {
        Team team = this.teamRepository.findByTeamNameIgnoreCase(teamName);

        List<Match> matches = this.matchRepository.findLatestMatchesByTeam(teamName, 4);
        team.setMatches(matches);

        return team;
    }

    @RequestMapping("/team/{teamName}/matches")
    public List<Match> getMatchesForTeam(@PathVariable("teamName") String teamName, @RequestParam int year) {
        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = LocalDate.of(year + 1, 1, 1);
        teamName = getFirstCharacterUpperCaseString(teamName);
        return this.matchRepository.getMatchesByTeamBetweenDates(teamName, startDate, endDate);
    }


    //helper method to convert first character of each work from lowercase to upper of given string
    private String getFirstCharacterUpperCaseString(String teamName) {
        String[] arr = teamName.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String s : arr) {
            sb.append(Character.toUpperCase(s.charAt(0)))
                    .append(s.substring(1)).append(" ");
        }
        return sb.toString().trim();
    }

}