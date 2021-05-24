import { React } from "react";
import { Link } from "react-router-dom";

export const MatchDetailCard = ({ teamName, match }) => {
  if (!match) {
    return null;
  }

  const otherTeamName =
    match.teamOne === teamName ? match.teamTwo : match.teamOne;
  const otherTeamRoute = `/teams/${otherTeamName}`;

  return (
    <div className="MatchDetailCard">
      <h3>Latest Match</h3>
      <h1>
        vs&nbsp;
        <Link to={otherTeamRoute}>{otherTeamName}</Link>
      </h1>
      <h2>{match.date}</h2>
      <h3>at {match.venue}</h3>
      <h3>
        {match.matchWinner} won by {match.resultMargin} {match.result}
      </h3>
    </div>
  );
};
