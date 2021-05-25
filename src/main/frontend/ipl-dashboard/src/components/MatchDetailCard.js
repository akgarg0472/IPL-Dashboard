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
  const isMatchWon = teamName === match.matchWinner;

  return (
    <div className={isMatchWon ? "MatchDetailCard won-card" : "MatchDetailCard lost-card"}>
      <div className="latest-match-info">
        <h3>Latest Match</h3>
        <span className="vs">vs&nbsp;</span>
        <h1>
          <Link to={otherTeamRoute}>{otherTeamName}</Link>
        </h1>
        <h2 className="match-date">{match.date}</h2>
        <h3 className="match-venue">at {match.venue}</h3>
        <h3 className="match-result">
          {match.matchWinner} won by {match.resultMargin} {match.result}
        </h3>
      </div>

      <div className="additional-match-details">
        <h3>First innings</h3>
        <p>{match.teamOne}</p>
        <h3>Second innings</h3>
        <p>{match.teamTwo}</p>
        <h3>Player of the match</h3>
        <p>{match.playerOfMatch}</p>
        <h3>Umpires</h3>
        <p>{match.umpireOne}, {match.umpireTwo}</p>
      </div>
    </div>
  );
};
