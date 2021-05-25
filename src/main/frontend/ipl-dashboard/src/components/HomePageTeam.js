import { React, useEffect, useState } from "react";

import "./HomePageTeam.scss";

export const HomePageTeam = ({teamName}) => {
  return (
    <div className="HomePageTeam">
      <h1>{teamName}</h1>
    </div>
  );
};
