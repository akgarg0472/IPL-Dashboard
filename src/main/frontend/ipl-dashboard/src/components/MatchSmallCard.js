import { React } from "react";
import { Link } from "react-router-dom";
import "./MatchSmallCard.scss";

export const MatchSmallCard = ({ teamName, match }) => {
  if (!match) {
    return null;
  }

  const otherTeamName =
    match.teamOne === teamName ? match.teamTwo : match.teamOne;
  const otherTeamRoute = `/teams/${otherTeamName}`;
  const isMatchWon = teamName === match.matchWinner;

  return (
    <div
      className={
        isMatchWon ? "MatchSmallCard won-card" : "MatchSmallCard lost-card"
      }
    >
      <div>
        <span className="vs">vs</span>
        <h1 className="other-team-name">
          <Link to={otherTeamRoute}>{otherTeamName}</Link>
        </h1>
      </div>
      <div className="match-result">
        <p>
          {match.matchWinner} won by {match.resultMargin} {match.result}
        </p>
      </div>
    </div>
  );
};
