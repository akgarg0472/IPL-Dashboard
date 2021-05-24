package com.akgarg.ipldashboard.controller;

import com.akgarg.ipldashboard.model.Team;
import com.akgarg.ipldashboard.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Akhilesh Garg
 */
@SuppressWarnings("unsued")
@RestController
public class TeamController {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable("teamName") String teamName) {
        return this.teamRepository.findByTeamNameIgnoreCase(teamName);
    }

}