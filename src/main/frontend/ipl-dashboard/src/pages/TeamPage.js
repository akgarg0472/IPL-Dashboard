import { React, useEffect, useState } from "react";
import { MatchDetailCard } from "../components/MatchDetailCard";
import { MatchSmallCard } from "../components/MatchSmallCard";
import { Link, useParams } from "react-router-dom";
import { PieChart } from "react-minimal-pie-chart";
import { Route } from "react-router";
import "./TeamPage.scss";

export const TeamPage = () => {
  const [team, setTeam] = useState({ matches: [] });
  const { teamName } = useParams();

  useEffect(() => {
    const fetchMatches = async () => {
      const response = await fetch(`/team/${teamName}`);
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

  const moreRoute = `/teams/${teamName}/matches/${process.env.REACT_APP_DATA_END_YEAR}`;

  return (
    <div className="TeamPage">
      <div className="team-name-section">
        <h2 className="go-to-home-page">
          <Route>
            <Link to="/" style={{textDecoration:'none'}}>&lt; Home</Link>
          </Route>
        </h2>

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
        <h3>Latest Match</h3>
        <MatchDetailCard teamName={team.teamName} match={team.matches[0]} />
        <h3>Most Recent matches</h3>
      </div>

      {team.matches.slice(1).map((match) => (
        <div
          key={`${match.id}`}
          className={
            teamName.toLowerCase() === match.matchWinner.toLowerCase()
              ? "recent-matches won-card"
              : "recent-matches lost-card"
          }
        >
          <MatchSmallCard teamName={team.teamName} match={match} />
        </div>
      ))}
      <div className="more-button">
        <Link to={moreRoute}>More &gt;&gt;</Link>
      </div>
    </div>
  );
};
