package com.akgarg.ipldashboard.data;

import com.akgarg.ipldashboard.model.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Akhilesh Garg
 */
@SuppressWarnings("unused")
@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);
    private final EntityManager entityManager;

    @Autowired
    public JobCompletionNotificationListener(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {

            Map<String, Team> teamsData = new HashMap<>();

            this.entityManager.createQuery("select m.teamOne, count(*) from Match m group by m.teamOne", Object[].class)
                    .getResultList()
                    .stream()
                    .map(e -> new Team((String) e[0], (long) e[1]))
                    .forEach(team -> teamsData.put(team.getTeamName(), team));


            this.entityManager.createQuery("select m.teamTwo, count(*) from Match m group by m.teamTwo", Object[].class)
                    .getResultList()
                    .stream()
                    .forEach(e -> {
                        Team team = teamsData.get((String) e[0]);
                        team.setTotalMatchesPlayed(team.getTotalMatchesPlayed() + (long) e[1]);
                    });

            this.entityManager.createQuery("select m.matchWinner, count(*) from Match m group by m.matchWinner", Object[].class)
                    .getResultList()
                    .forEach(e -> {
                        Team team = teamsData.get((String) e[0]);
                        if (team != null) {
                            team.setTotalWins((long) e[1]);
                        }
                    });

            teamsData.values().forEach(this.entityManager::persist);
            teamsData.values().forEach(System.out::println);
        }
    }
}
