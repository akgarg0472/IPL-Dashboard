import { React } from "react";

export const MatchSmallCard = ({ match }) => {
  if (!match) {
    return null;
  }

  return (
    <div className="MatchSmallCard">
      <p>
        {match.teamOne} vs {match.teamTwo}
      </p>
    </div>
  );
};
