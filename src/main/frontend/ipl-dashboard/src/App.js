import "./App.scss";
import { TeamPage } from "./pages/TeamPage";
import { MatchPage } from "./pages/MatchPage";
import { HashRouter as Router, Route, Switch } from "react-router-dom";
import { IndexPage } from "./pages/IndexPage";

function App() {
  return (
    <div className="App">
      <Router>
        <Switch>
          <Route path="/teams/:teamName/matches/:year">
            <MatchPage />
          </Route>

          <Route path="/teams/:teamName">
            <TeamPage />
          </Route>

          <Route path="/">
            <IndexPage />
          </Route>
        </Switch>
      </Router>
    </div>
  );
}

export default App;
