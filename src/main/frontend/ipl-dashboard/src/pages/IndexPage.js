import { React, useEffect, useState } from "react";
import { Route } from "react-router";
import { Link } from "react-router-dom";
import { HomePageTeam } from "../components/HomePageTeam";

import "./IndexPage.scss";

export const IndexPage = () => {
  const [teams, setTeams] = useState([]);

  useEffect(() => {
    const fetchTeams = async () => {
      const response = await fetch(`http://localhost:8080/all-teams`);
      const data = await response.json();
      setTeams(data);
    };
    fetchTeams();
  }, []);

  return (
    <div className="IndexPage">
      <h1 className="ipl-db-head">IPL Dashboard</h1>
      {teams.map((team) => (
        <Route>
          <Link to={`/teams/${team}`} style={{textDecoration:'none'}}>
            <HomePageTeam teamName={team} />
          </Link>
        </Route>
      ))}
    </div>
  );
};