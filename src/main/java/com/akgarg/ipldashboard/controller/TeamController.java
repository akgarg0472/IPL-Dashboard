package com.akgarg.ipldashboard.controller;

import com.akgarg.ipldashboard.model.Match;
import com.akgarg.ipldashboard.model.Team;
import com.akgarg.ipldashboard.repository.MatchRepository;
import com.akgarg.ipldashboard.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: Akhilesh Garg
 */
@SuppressWarnings("unsued")
@RestController
public class TeamController {

    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;

    @Autowired
    public TeamController(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable("teamName") String teamName) {
        Team team = this.teamRepository.findByTeamNameIgnoreCase(teamName);
        List<Match> matches = this.matchRepository.findLatestMatchesByTeam(teamName, 4);
        team.setMatches(matches);

        return team;
    }

}