package com.akgarg.ipldashboard.repository;

import com.akgarg.ipldashboard.model.Match;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
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


    //    List<Match> getByTeamOneAndDateBetweenOrTeamTwoAndDateBetweenOrderByDateDesc(
    //            String teamOne, LocalDate dateFirst, LocalDate dateSecond,
    //            String teamTwo, LocalDate dateOne, LocalDate dateTwo
    //    );

    @Query("select m from Match m where (m.teamOne = :teamName or m.teamTwo = :teamName) and m.date between :startDate and :endDate order by m.date desc")
    List<Match> getMatchesByTeamBetweenDates(@Param("teamName") String teamName,
                                             @Param("startDate") LocalDate startDate,
                                             @Param("endDate") LocalDate endDate
    );
}
