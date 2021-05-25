import { React, useEffect, useState } from "react";
import { MatchDetailCard } from "../components/MatchDetailCard";
import { MatchSmallCard } from "../components/MatchSmallCard";
import { useParams } from "react-router-dom";
import { PieChart } from "react-minimal-pie-chart";
import "./TeamPage.scss";

export const TeamPage = () => {
  const [team, setTeam] = useState({ matches: [] });
  const { teamName } = useParams();

  useEffect(() => {
    const fetchMatches = async () => {
      const response = await fetch(`http://localhost:8080/team/${teamName}`);
      const data = await response.json();
      setTeam(data);
    };
    fetchMatches();
  }, [teamName]);

  if (!team || !team.teamName) {
    return <h1>Team not found</h1>;
  }

  const totalWins = team.totalWins;
  const totalLoses = team.totalMatchesPlayed - team.totalWins;
  const winMatchPercent = (totalWins * (100 / team.totalMatchesPlayed)).toFixed(
    2
  );
  const loseMatchPercent = (
    totalLoses *
    (100 / team.totalMatchesPlayed)
  ).toFixed(2);

  return (
    <div className="TeamPage">
      <div className="team-name-section">
        <h1>{team.teamName}</h1>
      </div>

      <div className="win-loss-section">
        <PieChart
          className="win-lose-pie-chart"
          data={[
            {
              title: loseMatchPercent + "% lose",
              value: totalLoses,
              color: "#a34d5d",
            },
            {
              title: winMatchPercent + "% win",
              value: totalWins,
              color: "rgb(65, 138, 99)",
            },
          ]}
        />
      </div>

      <div className="latest-match-section">
        <MatchDetailCard teamName={team.teamName} match={team.matches[0]} />
      </div>

      {team.matches.slice(1).map((match) => (
        <div
          className={
            teamName === match.matchWinner
              ? "recent-matches won-card"
              : "recent-matches lost-card"
          }
        >
          <MatchSmallCard teamName={team.teamName} match={match} />
        </div>
      ))}
      <div className="more-button">
        <a href="#">More &gt;&gt;</a>
      </div>
    </div>
  );
};
