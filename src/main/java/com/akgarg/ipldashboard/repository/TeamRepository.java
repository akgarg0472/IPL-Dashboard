package com.akgarg.ipldashboard.repository;

import com.akgarg.ipldashboard.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: Akhilesh Garg
 */
public interface TeamRepository extends JpaRepository<Team, Long> {

    // method to fetch the team using team name
    Team findByTeamNameIgnoreCase(String teamName);
}
