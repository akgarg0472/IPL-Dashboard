package com.akgarg.ipldashboard.repository;

import com.akgarg.ipldashboard.model.Match;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Author: Akhilesh Garg
 */
public interface MatchRepository extends CrudRepository<Match, Long> {

    List<Match> getMatchesByTeamOneOrTeamTwoIgnoreCaseOrderByDateDesc(String teamNameOne, String teamNameTwo, Pageable pageable);

    default List<Match> findLatestMatchesByTeam(String teamName, int count) {
        Pageable pageable = PageRequest.of(0, count);
        return getMatchesByTeamOneOrTeamTwoIgnoreCaseOrderByDateDesc(teamName, teamName, pageable);
    }

}
