import { React } from "react";
import { Link } from "react-router-dom";
import "./YearSelector.scss";

export const YearSelector = ({ teamName, selectedYear }) => {
  let years = [];
  const startYear = process.env.REACT_APP_DATA_START_YEAR;
  const endYear = process.env.REACT_APP_DATA_END_YEAR;

  for (let i = startYear; i <= endYear; i++) {
    years.push(i);
  }

  return (
    <div className="YearSelector">
      <ul className="year-selector-list">
        {years.map((year) => (
          <Link to={`/teams/${teamName}/matches/${year}`}>
            {/* {year === selectedYear ? <li className="active">{year}</li> : <li>{year}</li>} */}
            <li>{year}</li>
          </Link>
        ))}
      </ul>
    </div>
  );
};