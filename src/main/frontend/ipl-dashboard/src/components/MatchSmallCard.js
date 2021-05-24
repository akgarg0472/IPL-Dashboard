import { React } from "react";
import { Link } from "react-router-dom";

export const MatchSmallCard = ({ teamName, match }) => {
  if (!match) {
    return null;
  }

  const otherTeamName =
    match.teamOne === teamName ? match.teamTwo : match.teamOne;
  const otherTeamRoute = `/teams/${otherTeamName}`;

  return (
    <div className="MatchSmallCard">
      <h1>
        vs&nbsp;
        <Link to={otherTeamRoute}>{otherTeamName}</Link>
      </h1>
      <p>
        {match.matchWinner} won by {match.resultMargin} {match.result}
      </p>
    </div>
  );
};
