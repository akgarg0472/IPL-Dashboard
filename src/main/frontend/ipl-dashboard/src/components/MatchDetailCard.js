import { React } from "react";
import { Link } from "react-router-dom";
import "./MatchDetailCard.scss";

export const MatchDetailCard = ({ teamName, match }) => {
  if (!match) {
    console.log("empty match");
    return null;
  }

  const otherTeamName =
    match.teamOne === teamName ? match.teamTwo : match.teamOne;
  const otherTeamRoute = `/teams/${otherTeamName}`;
  const isMatchWon = teamName.toLowerCase() === match.matchWinner.toLowerCase();

  return (
    <div
      className={
        isMatchWon ? "MatchDetailCard won-card" : "MatchDetailCard lost-card"
      }
    >
      <div className="latest-match-info">
        <h3>Latest Match</h3>
        <br />
        <span className="vs">vs&nbsp;</span>
        <h1>
          <Link to={otherTeamRoute}>{otherTeamName}</Link>
        </h1>
        <h2 className="match-date">{match.date}</h2>
        <p className="match-venue">at {match.venue}</p>
        <h3 className="match-result">
          {match.matchWinner} won by {match.resultMargin} {match.result}{" "}
          {match.method}
        </h3>
      </div>

      <div className="additional-match-details">
        <h3>Toss</h3>
        <p>{match.tossWinner}</p>
        <h3>Decision</h3>
        <p>{match.tossDecision === "bat" ? "Bat first" : "Bowl first"}</p>
        <h3>Player of the match</h3>
        <p>{match.playerOfMatch}</p>
        <h3>Umpires</h3>
        <p>
          {match.umpireOne}, {match.umpireTwo}
        </p>
      </div>
    </div>
  );
};
