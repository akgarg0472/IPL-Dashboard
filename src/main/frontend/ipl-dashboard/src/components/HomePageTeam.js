import { React } from "react";

import "./HomePageTeam.scss";

export const HomePageTeam = ({teamName}) => {
  return (
    <div className="HomePageTeam">
      <h1>{teamName}</h1>
      <br></br>
      <span>Click to know more</span>
    </div>
  );
};