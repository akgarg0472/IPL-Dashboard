import { React, useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { MatchDetailCard } from "../components/MatchDetailCard";
import { YearSelector } from "../components/YearSelector";
import "./MatchPage.scss";

export const MatchPage = () => {
  const [matches, setMatches] = useState([]);
  const { teamName, year } = useParams();

  useEffect(() => {
    const fetchMatches = async () => {
      const response = await fetch(
        `http://localhost:8080/team/${teamName}/matches?year=${year}`
      );
      const data = await response.json();
      setMatches(data);
    };
    fetchMatches();
  }, [teamName, year]);

  return (
    <div className="MatchPage">
      <div className="year-selector">
        <YearSelector teamName={teamName} selectedYear={year}/>
      </div>
      <div className="match-info">
        {matches.length > 0 ? (
          matches.map((match) => (
            <MatchDetailCard teamName={teamName} match={match} />
          ))
        ) : (
          <h1 className="no-matches-found">
            No matches found for {teamName} in {year}
          </h1>
        )}
      </div>
    </div>
  );
};